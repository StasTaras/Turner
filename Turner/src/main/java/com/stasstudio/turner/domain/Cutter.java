package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cutter database table.
 * 
 */
@Entity
@NamedQuery(name="Cutter.findAll", query="SELECT c FROM Cutter c")
public class Cutter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cutter")
	private Integer idCutter;

	private String name;

	private String purpose;

	//bi-directional many-to-one association to AllProducer
	@ManyToOne
	@JoinColumn(name="id_producer")
	private AllProducer allProducer;

	//bi-directional many-to-one association to Use
	@OneToMany(mappedBy="cutter")
	private List<Use> uses;

	public Cutter() {
	}

	public Integer getIdCutter() {
		return this.idCutter;
	}

	public void setIdCutter(Integer idCutter) {
		this.idCutter = idCutter;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public AllProducer getAllProducer() {
		return this.allProducer;
	}

	public void setAllProducer(AllProducer allProducer) {
		this.allProducer = allProducer;
	}

	public List<Use> getUses() {
		return this.uses;
	}

	public void setUses(List<Use> uses) {
		this.uses = uses;
	}

	public Use addUs(Use us) {
		getUses().add(us);
		us.setCutter(this);

		return us;
	}

	public Use removeUs(Use us) {
		getUses().remove(us);
		us.setCutter(null);

		return us;
	}

}