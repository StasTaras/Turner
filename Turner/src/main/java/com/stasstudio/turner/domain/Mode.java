package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mode database table.
 * 
 */
@Entity
@NamedQuery(name="Mode.findAll", query="SELECT m FROM Mode m")
public class Mode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mode")
	private Integer idMode;

	private String info;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public Mode() {
	}

	public Integer getIdMode() {
		return this.idMode;
	}

	public void setIdMode(Integer idMode) {
		this.idMode = idMode;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}