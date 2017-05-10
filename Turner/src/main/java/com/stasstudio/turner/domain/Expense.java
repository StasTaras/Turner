package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the expense database table.
 * 
 */
@Entity
@NamedQuery(name="Expense.findAll", query="SELECT e FROM Expense e")
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_expense")
	private Integer idExpense;

	private String order;

	@Column(name="plate_alloy")
	private String plateAlloy;

	@Column(name="plate_amount")
	private Integer plateAmount;

	@Column(name="plate_chipbreaker")
	private String plateChipbreaker;

	@Column(name="plate_name")
	private String plateName;

	@Column(name="plate_producer")
	private Integer plateProducer;

	private Timestamp when;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_worker")
	private AllWorker allWorker;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public Expense() {
	}

	public Integer getIdExpense() {
		return this.idExpense;
	}

	public void setIdExpense(Integer idExpense) {
		this.idExpense = idExpense;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPlateAlloy() {
		return this.plateAlloy;
	}

	public void setPlateAlloy(String plateAlloy) {
		this.plateAlloy = plateAlloy;
	}

	public Integer getPlateAmount() {
		return this.plateAmount;
	}

	public void setPlateAmount(Integer plateAmount) {
		this.plateAmount = plateAmount;
	}

	public String getPlateChipbreaker() {
		return this.plateChipbreaker;
	}

	public void setPlateChipbreaker(String plateChipbreaker) {
		this.plateChipbreaker = plateChipbreaker;
	}

	public String getPlateName() {
		return this.plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public Integer getPlateProducer() {
		return this.plateProducer;
	}

	public void setPlateProducer(Integer plateProducer) {
		this.plateProducer = plateProducer;
	}

	public Timestamp getWhen() {
		return this.when;
	}

	public void setWhen(Timestamp when) {
		this.when = when;
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}