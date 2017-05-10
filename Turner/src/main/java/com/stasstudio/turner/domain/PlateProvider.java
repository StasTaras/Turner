package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plate_provider database table.
 * 
 */
@Entity
@Table(name="plate_provider")
@NamedQuery(name="PlateProvider.findAll", query="SELECT p FROM PlateProvider p")
public class PlateProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plate_provider")
	private Integer idPlateProvider;

	//bi-directional many-to-one association to AllProvider
	@ManyToOne
	@JoinColumn(name="id_provider")
	private AllProvider allProvider;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public PlateProvider() {
	}

	public Integer getIdPlateProvider() {
		return this.idPlateProvider;
	}

	public void setIdPlateProvider(Integer idPlateProvider) {
		this.idPlateProvider = idPlateProvider;
	}

	public AllProvider getAllProvider() {
		return this.allProvider;
	}

	public void setAllProvider(AllProvider allProvider) {
		this.allProvider = allProvider;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}