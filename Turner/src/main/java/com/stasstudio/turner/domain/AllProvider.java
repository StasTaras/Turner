package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_providers database table.
 * 
 */
@Entity
@Table(name="all_providers")
@NamedQuery(name="AllProvider.findAll", query="SELECT a FROM AllProvider a")
public class AllProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_all_providers")
	private Integer idAllProviders;

	private String name;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="id_provider")
	private Provider provider;

	//bi-directional many-to-one association to Indent
	@OneToMany(mappedBy="allProvider")
	private List<Indent> indents;

	//bi-directional many-to-one association to PlateProvider
	@OneToMany(mappedBy="allProvider")
	private List<PlateProvider> plateProviders;

	public AllProvider() {
	}

	public Integer getIdAllProviders() {
		return this.idAllProviders;
	}

	public void setIdAllProviders(Integer idAllProviders) {
		this.idAllProviders = idAllProviders;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Indent> getIndents() {
		return this.indents;
	}

	public void setIndents(List<Indent> indents) {
		this.indents = indents;
	}

	public Indent addIndent(Indent indent) {
		getIndents().add(indent);
		indent.setAllProvider(this);

		return indent;
	}

	public Indent removeIndent(Indent indent) {
		getIndents().remove(indent);
		indent.setAllProvider(null);

		return indent;
	}

	public List<PlateProvider> getPlateProviders() {
		return this.plateProviders;
	}

	public void setPlateProviders(List<PlateProvider> plateProviders) {
		this.plateProviders = plateProviders;
	}

	public PlateProvider addPlateProvider(PlateProvider plateProvider) {
		getPlateProviders().add(plateProvider);
		plateProvider.setAllProvider(this);

		return plateProvider;
	}

	public PlateProvider removePlateProvider(PlateProvider plateProvider) {
		getPlateProviders().remove(plateProvider);
		plateProvider.setAllProvider(null);

		return plateProvider;
	}

}