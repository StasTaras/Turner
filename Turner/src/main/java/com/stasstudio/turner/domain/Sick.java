package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sick database table.
 * 
 */
@Entity
@NamedQuery(name="Sick.findAll", query="SELECT s FROM Sick s")
public class Sick implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sick")
	private Integer idSick;

	@Temporal(TemporalType.DATE)
	private Date from;

	@Temporal(TemporalType.DATE)
	private Date to;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	public Sick() {
	}

	public Integer getIdSick() {
		return this.idSick;
	}

	public void setIdSick(Integer idSick) {
		this.idSick = idSick;
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