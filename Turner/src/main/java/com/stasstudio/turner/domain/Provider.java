package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provider database table.
 * 
 */
@Entity
@NamedQuery(name="Provider.findAll", query="SELECT p FROM Provider p")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_provider")
	private Integer idProvider;

	private String address;

	private String email;

	private String name;

	private String person;

	private String phone;

	//bi-directional many-to-one association to AllProvider
	@OneToMany(mappedBy="provider")
	private List<AllProvider> allProviders;

	public Provider() {
	}

	public Integer getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<AllProvider> getAllProviders() {
		return this.allProviders;
	}

	public void setAllProviders(List<AllProvider> allProviders) {
		this.allProviders = allProviders;
	}

	public AllProvider addAllProvider(AllProvider allProvider) {
		getAllProviders().add(allProvider);
		allProvider.setProvider(this);

		return allProvider;
	}

	public AllProvider removeAllProvider(AllProvider allProvider) {
		getAllProviders().remove(allProvider);
		allProvider.setProvider(null);

		return allProvider;
	}

}