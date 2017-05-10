package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the superuser database table.
 * 
 */
@Entity
@NamedQuery(name="Superuser.findAll", query="SELECT s FROM Superuser s")
public class Superuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_superuser")
	private Integer idSuperuser;

	private String pass;

	public Superuser() {
	}

	public Integer getIdSuperuser() {
		return this.idSuperuser;
	}

	public void setIdSuperuser(Integer idSuperuser) {
		this.idSuperuser = idSuperuser;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}