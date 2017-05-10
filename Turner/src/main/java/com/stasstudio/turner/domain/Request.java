package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * The persistent class for the request database table.
 * 
 */
@Entity
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;
	public DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Id
	@Column(name="id_request")
	private Integer idRequest;

	private String content;

	private Boolean isdone;

	private Integer priority;

	private String whencreate;

	private String whendone;

	//bi-directional many-to-one association to AllWorker
	@ManyToOne
	@JoinColumn(name="id_all_workers")
	private AllWorker allWorker;

	public Request() {
	}

	public Integer getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsdone() {
		return this.isdone;
	}

	public void setIsdone(Boolean isdone) {
		this.isdone = isdone;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
	public String getWhencreate() {
		return this.whencreate;
	}

	public void setWhencreate(Timestamp whencreate) {
		this.whencreate = whencreate.toString();
	}

	public String getWhendone() {
		return this.whendone;
	}

	public void setWhendone(Timestamp whendone) {
		this.whendone = whendone.toString();
	}

	public AllWorker getAllWorker() {
		return this.allWorker;
	}

	public void setAllWorker(AllWorker allWorker) {
		this.allWorker = allWorker;
	}

}