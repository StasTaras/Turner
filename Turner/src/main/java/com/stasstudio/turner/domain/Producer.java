package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producer database table.
 * 
 */
@Entity
@NamedQuery(name="Producer.findAll", query="SELECT p FROM Producer p")
public class Producer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producer")
	private Integer idProducer;

	private String name;

	//bi-directional many-to-one association to AllProducer
	@OneToMany(mappedBy="producer")
	private List<AllProducer> allProducers;

	public Producer() {
	}

	public Integer getIdProducer() {
		return this.idProducer;
	}

	public void setIdProducer(Integer idProducer) {
		this.idProducer = idProducer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllProducer> getAllProducers() {
		return this.allProducers;
	}

	public void setAllProducers(List<AllProducer> allProducers) {
		this.allProducers = allProducers;
	}

	public AllProducer addAllProducer(AllProducer allProducer) {
		getAllProducers().add(allProducer);
		allProducer.setProducer(this);

		return allProducer;
	}

	public AllProducer removeAllProducer(AllProducer allProducer) {
		getAllProducers().remove(allProducer);
		allProducer.setProducer(null);

		return allProducer;
	}

}