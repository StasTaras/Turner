package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plate_type database table.
 * 
 */
@Entity
@Table(name="plate_type")
@NamedQuery(name="PlateType.findAll", query="SELECT p FROM PlateType p")
public class PlateType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plate_type")
	private Integer idPlateType;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="id_type")
	private Type type;

	public PlateType() {
	}

	public Integer getIdPlateType() {
		return this.idPlateType;
	}

	public void setIdPlateType(Integer idPlateType) {
		this.idPlateType = idPlateType;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}