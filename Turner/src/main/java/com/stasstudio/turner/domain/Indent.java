package com.stasstudio.turner.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the indent database table.
 * 
 */
@Entity
@NamedQuery(name="Indent.findAll", query="SELECT i FROM Indent i")
public class Indent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_indent")
	private Integer idIndent;

	@Temporal(TemporalType.DATE)
	private Date checkout;

	@Temporal(TemporalType.DATE)
	private Date pay;

	@Column(name="plate_alloy")
	private String plateAlloy;

	@Column(name="plate_amount")
	private Integer plateAmount;

	@Column(name="plate_chipbreaker")
	private String plateChipbreaker;

	@Column(name="plate_cost")
	private double plateCost;

	@Column(name="plate_name")
	private String plateName;

	@Column(name="plate_producer")
	private Integer plateProducer;

	private Boolean status;

	@Temporal(TemporalType.DATE)
	private Date supply;

	//bi-directional many-to-one association to AllProvider
	@ManyToOne
	@JoinColumn(name="id_provider")
	private AllProvider allProvider;

	//bi-directional many-to-one association to Plate
	@ManyToOne
	@JoinColumn(name="id_plate")
	private Plate plate;

	public Indent() {
	}

	public Integer getIdIndent() {
		return this.idIndent;
	}

	public void setIdIndent(Integer idIndent) {
		this.idIndent = idIndent;
	}

	public Date getCheckout() {
		return this.checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public Date getPay() {
		return this.pay;
	}

	public void setPay(Date pay) {
		this.pay = pay;
	}

	public String getPlateAlloy() {
		return this.plateAlloy;
	}

	public void setPlateAlloy(String plateAlloy) {
		this.plateAlloy = plateAlloy;
	}

	public Integer getPlateAmount() {
		return this.plateAmount;
	}

	public void setPlateAmount(Integer plateAmount) {
		this.plateAmount = plateAmount;
	}

	public String getPlateChipbreaker() {
		return this.plateChipbreaker;
	}

	public void setPlateChipbreaker(String plateChipbreaker) {
		this.plateChipbreaker = plateChipbreaker;
	}

	public double getPlateCost() {
		return this.plateCost;
	}

	public void setPlateCost(double plateCost) {
		this.plateCost = plateCost;
	}

	public String getPlateName() {
		return this.plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public Integer getPlateProducer() {
		return this.plateProducer;
	}

	public void setPlateProducer(Integer plateProducer) {
		this.plateProducer = plateProducer;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getSupply() {
		return this.supply;
	}

	public void setSupply(Date supply) {
		this.supply = supply;
	}

	public AllProvider getAllProvider() {
		return this.allProvider;
	}

	public void setAllProvider(AllProvider allProvider) {
		this.allProvider = allProvider;
	}

	public Plate getPlate() {
		return this.plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

}