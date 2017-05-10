package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_producers database table.
 * 
 */
@Entity
@Table(name="all_producers")
@NamedQuery(name="AllProducer.findAll", query="SELECT a FROM AllProducer a")
public class AllProducer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_all_producers")
	private Integer idAllProducers;

	private String name;

	//bi-directional many-to-one association to Producer
	@ManyToOne
	@JoinColumn(name="id_producer")
	private Producer producer;

	//bi-directional many-to-one association to Cutter
	@OneToMany(mappedBy="allProducer")
	private List<Cutter> cutters;

	//bi-directional many-to-one association to Plate
	@OneToMany(mappedBy="allProducer")
	private List<Plate> plates;

	public AllProducer() {
	}

	public Integer getIdAllProducers() {
		return this.idAllProducers;
	}

	public void setIdAllProducers(Integer idAllProducers) {
		this.idAllProducers = idAllProducers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public List<Cutter> getCutters() {
		return this.cutters;
	}

	public void setCutters(List<Cutter> cutters) {
		this.cutters = cutters;
	}

	public Cutter addCutter(Cutter cutter) {
		getCutters().add(cutter);
		cutter.setAllProducer(this);

		return cutter;
	}

	public Cutter removeCutter(Cutter cutter) {
		getCutters().remove(cutter);
		cutter.setAllProducer(null);

		return cutter;
	}

	public List<Plate> getPlates() {
		return this.plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	public Plate addPlate(Plate plate) {
		getPlates().add(plate);
		plate.setAllProducer(this);

		return plate;
	}

	public Plate removePlate(Plate plate) {
		getPlates().remove(plate);
		plate.setAllProducer(null);

		return plate;
	}

}