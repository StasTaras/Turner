package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the worker database table.
 * 
 */
@Entity
@NamedQuery(name="Worker.findAll", query="SELECT w FROM Worker w")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_worker")
	private Integer idWorker;

	@Temporal(TemporalType.DATE)
	private Date birth;

	private String email;

	private String login;

	@Column(name="middle_name")
	private String middleName;

	private String name;

	private String phone;

	private String surname;

	//bi-directional many-to-one association to AllWorker
	@OneToMany(mappedBy="worker")
	private List<AllWorker> allWorkers;

	public Worker() {
	}

	public Integer getIdWorker() {
		return this.idWorker;
	}

	public void setIdWorker(Integer idWorker) {
		this.idWorker = idWorker;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<AllWorker> getAllWorkers() {
		return this.allWorkers;
	}

	public void setAllWorkers(List<AllWorker> allWorkers) {
		this.allWorkers = allWorkers;
	}

	public AllWorker addAllWorker(AllWorker allWorker) {
		getAllWorkers().add(allWorker);
		allWorker.setWorker(this);

		return allWorker;
	}

	public AllWorker removeAllWorker(AllWorker allWorker) {
		getAllWorkers().remove(allWorker);
		allWorker.setWorker(null);

		return allWorker;
	}

}