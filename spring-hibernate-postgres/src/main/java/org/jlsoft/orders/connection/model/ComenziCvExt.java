package org.jlsoft.orders.connection.model;
// Generated Aug 17, 2015 9:12:26 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ComenziCvExt generated by hbm2java
 */
@Entity
@Table(name = "comenzi_cv_ext", schema = "public")
public class ComenziCvExt implements java.io.Serializable {

	private ComenziCvExtId id;
	private ComenziVExt comenziVExt;
	private String stocId;
	private String contGest;
	private BigDecimal cantitate;
	private BigDecimal cantitater;
	private BigDecimal livrat;
	private BigDecimal pretVanzare;
	private BigDecimal prDiscIncl;
	private BigDecimal discContr;
	private BigDecimal discCom;
	private BigDecimal pretGross;

	public ComenziCvExt() {
	}

	public ComenziCvExt(ComenziCvExtId id, ComenziVExt comenziVExt,
			BigDecimal discContr, BigDecimal discCom, BigDecimal pretGross) {
		this.id = id;
		this.comenziVExt = comenziVExt;
		this.discContr = discContr;
		this.discCom = discCom;
		this.pretGross = pretGross;
	}

	public ComenziCvExt(ComenziCvExtId id, ComenziVExt comenziVExt,
			String stocId, String contGest, BigDecimal cantitate,
			BigDecimal cantitater, BigDecimal livrat, BigDecimal pretVanzare,
			BigDecimal prDiscIncl, BigDecimal discContr, BigDecimal discCom,
			BigDecimal pretGross) {
		this.id = id;
		this.comenziVExt = comenziVExt;
		this.stocId = stocId;
		this.contGest = contGest;
		this.cantitate = cantitate;
		this.cantitater = cantitater;
		this.livrat = livrat;
		this.pretVanzare = pretVanzare;
		this.prDiscIncl = prDiscIncl;
		this.discContr = discContr;
		this.discCom = discCom;
		this.pretGross = pretGross;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "comId", column = @Column(name = "com_id", nullable = false, length = 10)),
			@AttributeOverride(name = "nrlinie", column = @Column(name = "nrlinie", nullable = false, length = 3)) })
	public ComenziCvExtId getId() {
		return this.id;
	}

	public void setId(ComenziCvExtId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "com_id", nullable = false, insertable = false, updatable = false)
	public ComenziVExt getComenziVExt() {
		return this.comenziVExt;
	}

	public void setComenziVExt(ComenziVExt comenziVExt) {
		this.comenziVExt = comenziVExt;
	}

	@Column(name = "stoc_id", length = 10)
	public String getStocId() {
		return this.stocId;
	}

	public void setStocId(String stocId) {
		this.stocId = stocId;
	}

	@Column(name = "cont_gest", length = 25)
	public String getContGest() {
		return this.contGest;
	}

	public void setContGest(String contGest) {
		this.contGest = contGest;
	}

	@Column(name = "cantitate", precision = 10, scale = 3)
	public BigDecimal getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(BigDecimal cantitate) {
		this.cantitate = cantitate;
	}

	@Column(name = "cantitater", precision = 10, scale = 3)
	public BigDecimal getCantitater() {
		return this.cantitater;
	}

	public void setCantitater(BigDecimal cantitater) {
		this.cantitater = cantitater;
	}

	@Column(name = "livrat", precision = 10, scale = 3)
	public BigDecimal getLivrat() {
		return this.livrat;
	}

	public void setLivrat(BigDecimal livrat) {
		this.livrat = livrat;
	}

	@Column(name = "pret_vanzare", precision = 14)
	public BigDecimal getPretVanzare() {
		return this.pretVanzare;
	}

	public void setPretVanzare(BigDecimal pretVanzare) {
		this.pretVanzare = pretVanzare;
	}

	@Column(name = "pr_disc_incl", precision = 6)
	public BigDecimal getPrDiscIncl() {
		return this.prDiscIncl;
	}

	public void setPrDiscIncl(BigDecimal prDiscIncl) {
		this.prDiscIncl = prDiscIncl;
	}

	@Column(name = "disc_contr", nullable = false, precision = 6)
	public BigDecimal getDiscContr() {
		return this.discContr;
	}

	public void setDiscContr(BigDecimal discContr) {
		this.discContr = discContr;
	}

	@Column(name = "disc_com", nullable = false, precision = 6)
	public BigDecimal getDiscCom() {
		return this.discCom;
	}

	public void setDiscCom(BigDecimal discCom) {
		this.discCom = discCom;
	}

	@Column(name = "pret_gross", nullable = false, precision = 11)
	public BigDecimal getPretGross() {
		return this.pretGross;
	}

	public void setPretGross(BigDecimal pretGross) {
		this.pretGross = pretGross;
	}

}


/*


-- Table: comenzi_cv_ext

-- DROP TABLE comenzi_cv_ext;

CREATE TABLE comenzi_cv_ext
(
  com_id character(10) NOT NULL,
  nrlinie character(3) NOT NULL,
  stoc_id character(10),
  cont_gest character(25),
  cantitate numeric(10,3),
  cantitater numeric(10,3),
  livrat numeric(10,3),
  pret_vanzare numeric(14,2),
  pr_disc_incl numeric(6,2),
  disc_contr numeric(6,2) NOT NULL DEFAULT 0,
  disc_com numeric(6,2) NOT NULL DEFAULT 0,
  pret_gross numeric(11,2) NOT NULL DEFAULT 0,
  CONSTRAINT comenzi_cv_ext_pkey PRIMARY KEY (com_id, nrlinie),
  CONSTRAINT com_id FOREIGN KEY (com_id)
      REFERENCES comenzi_v_ext (com_id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE comenzi_cv_ext OWNER TO postgres;


*/