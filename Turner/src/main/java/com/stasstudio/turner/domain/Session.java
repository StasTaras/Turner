package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_session")
	private Integer idSession;

	@Temporal(TemporalType.DATE)
	private Date day;

	private BigDecimal dayshift;

	private Time factfinish;

	private Time factstart;

	private Time formfinish;

	private Time formstart;

	private Boolean isfinished;

	private BigDecimal nightshift;

	private String photofinish;

	private String photostart;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	public Session() {
	}

	public Integer getIdSession() {
		return this.idSession;
	}

	public void setIdSession(Integer idSession) {
		this.idSession = idSession;
	}

	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public BigDecimal getDayshift() {
		return this.dayshift;
	}

	public void setDayshift(BigDecimal dayshift) {
		this.dayshift = dayshift;
	}

	public Time getFactfinish() {
		return this.factfinish;
	}

	public void setFactfinish(Time factfinish) {
		this.factfinish = factfinish;
	}

	public Time getFactstart() {
		return this.factstart;
	}

	public void setFactstart(Time factstart) {
		this.factstart = factstart;
	}

	public Time getFormfinish() {
		return this.formfinish;
	}

	public void setFormfinish(Time formfinish) {
		this.formfinish = formfinish;
	}

	public Time getFormstart() {
		return this.formstart;
	}

	public void setFormstart(Time formstart) {
		this.formstart = formstart;
	}

	public Boolean getIsfinished() {
		return this.isfinished;
	}

	public void setIsfinished(Boolean isfinished) {
		this.isfinished = isfinished;
	}

	public BigDecimal getNightshift() {
		return this.nightshift;
	}

	public void setNightshift(BigDecimal nightshift) {
		this.nightshift = nightshift;
	}

	public String getPhotofinish() {
		return this.photofinish;
	}

	public void setPhotofinish(String photofinish) {
		this.photofinish = photofinish;
	}

	public String getPhotostart() {
		return this.photostart;
	}

	public void setPhotostart(String photostart) {
		this.photostart = photostart;
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

}