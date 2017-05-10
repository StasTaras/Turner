package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the processing database table.
 * 
 */
@Entity
@NamedQuery(name="Processing.findAll", query="SELECT p FROM Processing p")
public class Processing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_processing")
	private Integer idProcessing;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	//bi-directional many-to-one association to Sort
	@ManyToOne
	@JoinColumn(name="id_sort")
	private Sort sort;

	public Processing() {
	}

	public Integer getIdProcessing() {
		return this.idProcessing;
	}

	public void setIdProcessing(Integer idProcessing) {
		this.idProcessing = idProcessing;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public Sort getSort() {
		return this.sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}