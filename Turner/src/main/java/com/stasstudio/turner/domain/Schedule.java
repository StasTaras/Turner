package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_schedule")
	private Integer idSchedule;

	private Timestamp finishtime;

	private Timestamp starttime;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	//bi-directional many-to-one association to Workplace
	@ManyToOne
	@JoinColumn(name="id_workplace")
	private Workplace workplace;

	public Schedule() {
	}

	public Integer getIdSchedule() {
		return this.idSchedule;
	}

	public void setIdSchedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Timestamp getFinishtime() {
		return this.finishtime;
	}

	public void setFinishtime(Timestamp finishtime) {
		this.finishtime = finishtime;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

	public Workplace getWorkplace() {
		return this.workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}

}