package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the salary database table.
 * 
 */
@Entity
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_salary")
	private Integer idSalary;

	private BigDecimal dayrate;

	@Temporal(TemporalType.DATE)
	private Date month;

	private BigDecimal nightrate;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	public Salary() {
	}

	public Integer getIdSalary() {
		return this.idSalary;
	}

	public void setIdSalary(Integer idSalary) {
		this.idSalary = idSalary;
	}

	public BigDecimal getDayrate() {
		return this.dayrate;
	}

	public void setDayrate(BigDecimal dayrate) {
		this.dayrate = dayrate;
	}

	public Date getMonth() {
		return this.month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public BigDecimal getNightrate() {
		return this.nightrate;
	}

	public void setNightrate(BigDecimal nightrate) {
		this.nightrate = nightrate;
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

}