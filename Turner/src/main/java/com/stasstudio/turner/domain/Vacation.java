package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vacation database table.
 * 
 */
@Entity
@NamedQuery(name="Vacation.findAll", query="SELECT v FROM Vacation v")
public class Vacation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vacation")
	private Integer idVacation;

	@Temporal(TemporalType.DATE)
	private Date from;

	@Temporal(TemporalType.DATE)
	private Date to;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	public Vacation() {
	}

	public Integer getIdVacation() {
		return this.idVacation;
	}

	public void setIdVacation(Integer idVacation) {
		this.idVacation = idVacation;
	}

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

}