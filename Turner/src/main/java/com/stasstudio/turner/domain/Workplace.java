package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the workplace database table.
 * 
 */
@Entity
@NamedQuery(name="Workplace.findAll", query="SELECT w FROM Workplace w")
public class Workplace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_workplace")
	private Integer idWorkplace;

	private String description;

	private String name;

	private String type;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="workplace")
	private List<Schedule> schedules;

	public Workplace() {
	}

	public Integer getIdWorkplace() {
		return this.idWorkplace;
	}

	public void setIdWorkplace(Integer idWorkplace) {
		this.idWorkplace = idWorkplace;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setWorkplace(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setWorkplace(null);

		return schedule;
	}

}