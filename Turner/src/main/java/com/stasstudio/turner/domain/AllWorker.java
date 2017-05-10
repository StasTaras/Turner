package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_workers database table.
 * 
 */
@Entity
@Table(name="all_workers")
@NamedQuery(name="AllWorker.findAll", query="SELECT a FROM AllWorker a")
public class AllWorker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_all_workers")
	private Integer idAllWorkers;

	private String name;

	//bi-directional many-to-one association to Worker
	@ManyToOne
	@JoinColumn(name="id_worker")
	private Worker worker;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="allWorker")
	private List<Request> requests;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="allWorker")
	private List<Expense> expenses;

	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="allWorker")
	private List<New> news;

	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="allWorker")
	private List<Salary> salaries;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="allWorker")
	private List<Schedule> schedules;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="allWorker")
	private List<Session> sessions;

	//bi-directional many-to-one association to Sick
	@OneToMany(mappedBy="allWorker")
	private List<Sick> sicks;

	//bi-directional many-to-one association to Vacation
	@OneToMany(mappedBy="allWorker")
	private List<Vacation> vacations;

	public AllWorker() {
	}

	public Integer getIdAllWorkers() {
		return this.idAllWorkers;
	}

	public void setIdAllWorkers(Integer idAllWorkers) {
		this.idAllWorkers = idAllWorkers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setAllWorker(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setAllWorker(null);

		return request;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setAllWorker(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setAllWorker(null);

		return expens;
	}

	public List<New> getNews() {
		return this.news;
	}

	public void setNews(List<New> news) {
		this.news = news;
	}
	
	public New addNew(New news) {
		getNews().add(news);
		news.setAllWorker(this);
		return news;
	}

	public New removeNew(New news) {
		getNews().remove(news);
		news.setAllWorker(null);

		return news;
	}

	public List<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public Salary addSalary(Salary salary) {
		getSalaries().add(salary);
		salary.setAllWorker(this);

		return salary;
	}

	public Salary removeSalary(Salary salary) {
		getSalaries().remove(salary);
		salary.setAllWorker(null);

		return salary;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setAllWorker(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setAllWorker(null);

		return schedule;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setAllWorker(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setAllWorker(null);

		return session;
	}

	public List<Sick> getSicks() {
		return this.sicks;
	}

	public void setSicks(List<Sick> sicks) {
		this.sicks = sicks;
	}

	public Sick addSick(Sick sick) {
		getSicks().add(sick);
		sick.setAllWorker(this);

		return sick;
	}

	public Sick removeSick(Sick sick) {
		getSicks().remove(sick);
		sick.setAllWorker(null);

		return sick;
	}

	public List<Vacation> getVacations() {
		return this.vacations;
	}

	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

	public Vacation addVacation(Vacation vacation) {
		getVacations().add(vacation);
		vacation.setAllWorker(this);

		return vacation;
	}

	public Vacation removeVacation(Vacation vacation) {
		getVacations().remove(vacation);
		vacation.setAllWorker(null);

		return vacation;
	}

}