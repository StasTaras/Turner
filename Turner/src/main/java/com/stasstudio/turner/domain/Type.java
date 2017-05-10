package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_type")
	private Integer idType;

	private String name;

	//bi-directional many-to-one association to PlateType
	@OneToMany(mappedBy="type")
	private List<PlateType> plateTypes;

	public Type() {
	}

	public Integer getIdType() {
		return this.idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PlateType> getPlateTypes() {
		return this.plateTypes;
	}

	public void setPlateTypes(List<PlateType> plateTypes) {
		this.plateTypes = plateTypes;
	}

	public PlateType addPlateType(PlateType plateType) {
		getPlateTypes().add(plateType);
		plateType.setType(this);

		return plateType;
	}

	public PlateType removePlateType(PlateType plateType) {
		getPlateTypes().remove(plateType);
		plateType.setType(null);

		return plateType;
	}

}