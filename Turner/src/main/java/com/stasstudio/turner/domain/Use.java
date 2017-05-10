package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the use database table.
 * 
 */
@Entity
@NamedQuery(name="Use.findAll", query="SELECT u FROM Use u")
public class Use implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_use")
	private Integer idUse;

	//bi-directional many-to-one association to Cutter
	@ManyToOne
	@JoinColumn(name="id_cutter")
	private Cutter cutter;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public Use() {
	}

	public Integer getIdUse() {
		return this.idUse;
	}

	public void setIdUse(Integer idUse) {
		this.idUse = idUse;
	}

	public Cutter getCutter() {
		return this.cutter;
	}

	public void setCutter(Cutter cutter) {
		this.cutter = cutter;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}