package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cell database table.
 * 
 */
@Entity
@NamedQuery(name="Cell.findAll", query="SELECT c FROM Cell c")
public class Cell implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cell")
	private Integer idCell;

	private Integer number;

	@Column(name="plate_amount")
	private Integer plateAmount;

	private Boolean reserve;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public Cell() {
	}

	public Integer getIdCell() {
		return this.idCell;
	}

	public void setIdCell(Integer idCell) {
		this.idCell = idCell;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPlateAmount() {
		return this.plateAmount;
	}

	public void setPlateAmount(Integer plateAmount) {
		this.plateAmount = plateAmount;
	}

	public Boolean getReserve() {
		return this.reserve;
	}

	public void setReserve(Boolean reserve) {
		this.reserve = reserve;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}