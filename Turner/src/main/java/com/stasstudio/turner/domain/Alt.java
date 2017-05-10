package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alt database table.
 * 
 */
@Entity
@NamedQuery(name="Alt.findAll", query="SELECT a FROM Alt a")
public class Alt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alt")
	private Integer idAlt;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate1")
	private Plate plate1;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate2")
	private Plate plate2;

	public Alt() {
	}

	public Integer getIdAlt() {
		return this.idAlt;
	}

	public void setIdAlt(Integer idAlt) {
		this.idAlt = idAlt;
	}

	public Plate getPlate1() {
		return this.plate1;
	}

	public void setPlate1(Plate plate1) {
		this.plate1 = plate1;
	}

	public Plate getPlate2() {
		return this.plate2;
	}

	public void setPlate2(Plate plate2) {
		this.plate2 = plate2;
	}

}