package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plate database table.
 * 
 */
@Entity
@NamedQuery(name="Plate.findAll", query="SELECT p FROM Plate p")
public class Plate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plate")
	private Integer idPlate;

	private String alloy;

	private String chipbreaker;

	private String comment;

	private Integer edges;

	private String h;

	private String k;

	private String m;

	private String n;

	private String name;

	private String p;

	private String photo1;

	private String photo2;

	private String photo3;

	private String s;

	//bi-directional many-to-one association to Alt
	@OneToMany(mappedBy="plate1")
	private List<Alt> alts1;

	//bi-directional many-to-one association to Alt
	@OneToMany(mappedBy="plate2")
	private List<Alt> alts2;

	//bi-directional many-to-one association to Cell
	@OneToMany(mappedBy="plate")
	private List<Cell> cells;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="plate")
	private List<Expense> expenses;

	//bi-directional many-to-one association to Indent
	@OneToMany(mappedBy="plate")
	private List<Indent> indents;

	//bi-directional many-to-one association to Mode
	@OneToMany(mappedBy="plate")
	private List<Mode> modes;

	//bi-directional many-to-one association to AllProducer
	@ManyToOne
	@JoinColumn(name="id_producer")
	private AllProducer allProducer;

	//bi-directional many-to-one association to PlateProvider
	@OneToMany(mappedBy="plate")
	private List<PlateProvider> plateProviders;

	//bi-directional many-to-one association to PlateType
	@OneToMany(mappedBy="plate")
	private List<PlateType> plateTypes;

	//bi-directional many-to-one association to Processing
	@OneToMany(mappedBy="plate")
	private List<Processing> processings;

	//bi-directional many-to-one association to Use
	@OneToMany(mappedBy="plate")
	private List<Use> uses;

	public Plate() {
	}

	public Integer getIdPlate() {
		return this.idPlate;
	}

	public void setIdPlate(Integer idPlate) {
		this.idPlate = idPlate;
	}

	public String getAlloy() {
		return this.alloy;
	}

	public void setAlloy(String alloy) {
		this.alloy = alloy;
	}

	public String getChipbreaker() {
		return this.chipbreaker;
	}

	public void setChipbreaker(String chipbreaker) {
		this.chipbreaker = chipbreaker;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getEdges() {
		return this.edges;
	}

	public void setEdges(Integer edges) {
		this.edges = edges;
	}

	public String getH() {
		return this.h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getK() {
		return this.k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getM() {
		return this.m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getN() {
		return this.n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getP() {
		return this.p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getPhoto1() {
		return this.photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return this.photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return this.photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getS() {
		return this.s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public List<Alt> getAlts1() {
		return this.alts1;
	}

	public void setAlts1(List<Alt> alts1) {
		this.alts1 = alts1;
	}

	public Alt addAlts1(Alt alts1) {
		getAlts1().add(alts1);
		alts1.setPlate1(this);

		return alts1;
	}

	public Alt removeAlts1(Alt alts1) {
		getAlts1().remove(alts1);
		alts1.setPlate1(null);

		return alts1;
	}

	public List<Alt> getAlts2() {
		return this.alts2;
	}

	public void setAlts2(List<Alt> alts2) {
		this.alts2 = alts2;
	}

	public Alt addAlts2(Alt alts2) {
		getAlts2().add(alts2);
		alts2.setPlate2(this);

		return alts2;
	}

	public Alt removeAlts2(Alt alts2) {
		getAlts2().remove(alts2);
		alts2.setPlate2(null);

		return alts2;
	}

	public List<Cell> getCells() {
		return this.cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public Cell addCell(Cell cell) {
		getCells().add(cell);
		cell.setPlate(this);

		return cell;
	}

	public Cell removeCell(Cell cell) {
		getCells().remove(cell);
		cell.setPlate(null);

		return cell;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setPlate(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setPlate(null);

		return expens;
	}

	public List<Indent> getIndents() {
		return this.indents;
	}

	public void setIndents(List<Indent> indents) {
		this.indents = indents;
	}

	public Indent addIndent(Indent indent) {
		getIndents().add(indent);
		indent.setPlate(this);

		return indent;
	}

	public Indent removeIndent(Indent indent) {
		getIndents().remove(indent);
		indent.setPlate(null);

		return indent;
	}

	public List<Mode> getModes() {
		return this.modes;
	}

	public void setModes(List<Mode> modes) {
		this.modes = modes;
	}

	public Mode addMode(Mode mode) {
		getModes().add(mode);
		mode.setPlate(this);

		return mode;
	}

	public Mode removeMode(Mode mode) {
		getModes().remove(mode);
		mode.setPlate(null);

		return mode;
	}

	public AllProducer getAllProducer() {
		return this.allProducer;
	}

	public void setAllProducer(AllProducer allProducer) {
		this.allProducer = allProducer;
	}

	public List<PlateProvider> getPlateProviders() {
		return this.plateProviders;
	}

	public void setPlateProviders(List<PlateProvider> plateProviders) {
		this.plateProviders = plateProviders;
	}

	public PlateProvider addPlateProvider(PlateProvider plateProvider) {
		getPlateProviders().add(plateProvider);
		plateProvider.setPlate(this);

		return plateProvider;
	}

	public PlateProvider removePlateProvider(PlateProvider plateProvider) {
		getPlateProviders().remove(plateProvider);
		plateProvider.setPlate(null);

		return plateProvider;
	}

	public List<PlateType> getPlateTypes() {
		return this.plateTypes;
	}

	public void setPlateTypes(List<PlateType> plateTypes) {
		this.plateTypes = plateTypes;
	}

	public PlateType addPlateType(PlateType plateType) {
		getPlateTypes().add(plateType);
		plateType.setPlate(this);

		return plateType;
	}

	public PlateType removePlateType(PlateType plateType) {
		getPlateTypes().remove(plateType);
		plateType.setPlate(null);

		return plateType;
	}

	public List<Processing> getProcessings() {
		return this.processings;
	}

	public void setProcessings(List<Processing> processings) {
		this.processings = processings;
	}

	public Processing addProcessing(Processing processing) {
		getProcessings().add(processing);
		processing.setPlate(this);

		return processing;
	}

	public Processing removeProcessing(Processing processing) {
		getProcessings().remove(processing);
		processing.setPlate(null);

		return processing;
	}

	public List<Use> getUses() {
		return this.uses;
	}

	public void setUses(List<Use> uses) {
		this.uses = uses;
	}

	public Use addUs(Use us) {
		getUses().add(us);
		us.setPlate(this);

		return us;
	}

	public Use removeUs(Use us) {
		getUses().remove(us);
		us.setPlate(null);

		return us;
	}

}