package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sort database table.
 * 
 */
@Entity
@NamedQuery(name="Sort.findAll", query="SELECT s FROM Sort s")
public class Sort implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sort")
	private Integer idSort;

	private String name;

	//bi-directional many-to-one association to Processing
	@OneToMany(mappedBy="sort")
	private List<Processing> processings;

	public Sort() {
	}

	public Integer getIdSort() {
		return this.idSort;
	}

	public void setIdSort(Integer idSort) {
		this.idSort = idSort;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Processing> getProcessings() {
		return this.processings;
	}

	public void setProcessings(List<Processing> processings) {
		this.processings = processings;
	}

	public Processing addProcessing(Processing processing) {
		getProcessings().add(processing);
		processing.setSort(this);

		return processing;
	}

	public Processing removeProcessing(Processing processing) {
		getProcessings().remove(processing);
		processing.setSort(null);

		return processing;
	}

}