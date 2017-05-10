package com.stasstudio.turner.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stasstudio.turner.domain.Schedule;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stasstudio.turner.mappers.ScheduleMapper;
import com.stasstudio.turner.schedule.api.ScheduleApiListReply;
import com.stasstudio.turner.services.ScheduleService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;



@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ScheduleMapper scheduleMapper;

    @RequestMapping(path = "/schedules", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ScheduleApiListReply getAllSchedule() {
        ScheduleApiListReply scheduleApiListReply = new ScheduleApiListReply();
        scheduleApiListReply.scheduleApi.addAll(scheduleService.getAll()
                .stream()
                .map(schedule -> scheduleMapper.toApiGet(schedule))
                .collect(Collectors.toList()));
        return scheduleApiListReply;
    }

    @RequestMapping(path = "/schedules/{id}", method=RequestMethod.GET)
    public ModelAndView downloadExcelOutputExl(HttpServletResponse response, @PathVariable int id){
        //scheduleService.createExcelOutputExcel(response, id);
        String fileName = "Excel_Output.xls";
        WritableWorkbook writableWorkbook = null;
        try {
            response.setContentType("application/vnd.ms-excel");

            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            writableWorkbook = Workbook.createWorkbook(response.getOutputStream());

            WritableSheet excelOutputsheet = writableWorkbook.createSheet("Excel Output", 0);
            addExcelOutputHeader(excelOutputsheet);
            writeExcelOutputData(excelOutputsheet, id);

            writableWorkbook.write();
            writableWorkbook.close();

        } catch (Exception e) {
            System.out.println("Error occured while creating Excel file");

        }
        return null;
    }

    public void addExcelOutputHeader(WritableSheet sheet) throws RowsExceededException, WriteException {
        // create header row
        sheet.addCell(new Label(0, 0, "Дата"));
        sheet.addCell(new Label(1, 0, " Время начала"));
        sheet.addCell(new Label(2, 0, " Время конца"));
        sheet.addCell(new Label(3, 0, " Рабочее место"));
    }

    public void writeExcelOutputData(WritableSheet sheet, int id) throws
            RowsExceededException, WriteException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<Schedule> schedules  = scheduleService.getAll();
        int size = scheduleService.getAll().size();
        ArrayList<String> startDate = new ArrayList<>();
        ArrayList<String> startTime = new ArrayList<>();
        ArrayList<String> finishTime = new ArrayList<>();
        ArrayList<String> wPlace = new ArrayList<>();

        for(int i = 0; i < schedules.size(); i++) {
            startDate.add(simpleDateFormat.format(schedules.get(i).getStarttime()));
            startTime.add(schedules.get(i).getStarttime().toString());
            finishTime.add(schedules.get(i).getFinishtime().toString());
            wPlace.add(schedules.get(i).getWorkplace().getName());
        }

        for (int rowNo = 1, i = 0, j = 1; rowNo <= size; i++, rowNo++ ) {
            System.out.println(schedules.get(i).getAllWorker().getWorker().getIdWorker());
            if (schedules.get(i).getAllWorker().getWorker().getIdWorker() == id) {
                sheet.addCell(new Label(0, j, startDate.get(i) + (j + 0)));
                sheet.addCell(new Label(1, j, startTime.get(i) + (j + 1)));
                sheet.addCell(new Label(2, j, finishTime.get(i) + (j + 2)));
                sheet.addCell(new Label(3, j, wPlace.get(i) + (j + 3)));
                j++;
            }
        }
    }

}
