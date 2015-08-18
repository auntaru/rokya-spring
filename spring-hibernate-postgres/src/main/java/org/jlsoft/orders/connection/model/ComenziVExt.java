// default package
// Generated Aug 17, 2015 9:12:26 PM by Hibernate Tools 3.6.0
package org.jlsoft.orders.connection.model;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ComenziVExt generated by hbm2java
 */
@Entity
@Table(name = "comenzi_v_ext", schema = "public")
public class ComenziVExt implements java.io.Serializable {

	private String comId;
	private NumereLucru numereLucru;
	private Terti terti;
	private String nrdoc;
	private Date dataC;
	private String gestiuneId;
	private Date dataL;
	private Character facturat;
	private String userId;
	private Date operare;
	private Boolean verstor;
	private Integer nivacc;
	private Character tiparit;
	private Integer zscadenta;
	private String nrfact;
	private Date dataF;
	private BigDecimal valoare;
	private BigDecimal valDiscExpl;
	private BigDecimal prDiscExpl;
	private Date creare;
	private Integer nrop;
	private String idExt;
	private String msgId;
	private Set <ComenziCvExt> comenziCvExts = new HashSet <ComenziCvExt> (0);

	public ComenziVExt() {
	}

	public ComenziVExt(String comId) {
		this.comId = comId;
	}

	public ComenziVExt(String comId, NumereLucru numereLucru, Terti terti,
			String nrdoc, Date dataC, String gestiuneId, Date dataL,
			Character facturat, String userId, Date operare, Boolean verstor,
			Integer nivacc, Character tiparit, Integer zscadenta,
			String nrfact, Date dataF, BigDecimal valoare,
			BigDecimal valDiscExpl, BigDecimal prDiscExpl, Date creare,
			Integer nrop, String idExt, String msgId, Set <ComenziCvExt> comenziCvExts) {
		this.comId = comId;
		this.numereLucru = numereLucru;
		this.terti = terti;
		this.nrdoc = nrdoc;
		this.dataC = dataC;
		this.gestiuneId = gestiuneId;
		this.dataL = dataL;
		this.facturat = facturat;
		this.userId = userId;
		this.operare = operare;
		this.verstor = verstor;
		this.nivacc = nivacc;
		this.tiparit = tiparit;
		this.zscadenta = zscadenta;
		this.nrfact = nrfact;
		this.dataF = dataF;
		this.valoare = valoare;
		this.valDiscExpl = valDiscExpl;
		this.prDiscExpl = prDiscExpl;
		this.creare = creare;
		this.nrop = nrop;
		this.idExt = idExt;
		this.msgId = msgId;
		this.comenziCvExts = comenziCvExts;
	}

	@Id
	@Column(name = "com_id", unique = true, nullable = false, length = 10)
	public String getComId() {
		return this.comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	// Lazy fetching decides whether to load child objects while loading the Parent Object. 
	// Lazy = true (means not to load child) ; By default the lazy loading of the child objects is true.
	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nrlc_id")
	public NumereLucru getNumereLucru() {
		return this.numereLucru;
	}

	public void setNumereLucru(NumereLucru numereLucru) {
		this.numereLucru = numereLucru;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tert_id")
	public Terti getTerti() {
		return this.terti;
	}

	public void setTerti(Terti terti) {
		this.terti = terti;
	}

	@Column(name = "nrdoc", length = 16)
	public String getNrdoc() {
		return this.nrdoc;
	}

	public void setNrdoc(String nrdoc) {
		this.nrdoc = nrdoc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_c", length = 13)
	public Date getDataC() {
		return this.dataC;
	}

	public void setDataC(Date dataC) {
		this.dataC = dataC;
	}

	@Column(name = "gestiune_id", length = 7)
	public String getGestiuneId() {
		return this.gestiuneId;
	}

	public void setGestiuneId(String gestiuneId) {
		this.gestiuneId = gestiuneId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_l", length = 13)
	public Date getDataL() {
		return this.dataL;
	}

	public void setDataL(Date dataL) {
		this.dataL = dataL;
	}

	@Column(name = "facturat", length = 1)
	public Character getFacturat() {
		return this.facturat;
	}

	public void setFacturat(Character facturat) {
		this.facturat = facturat;
	}

	@Column(name = "user_id", length = 5)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operare", length = 29)
	public Date getOperare() {
		return this.operare;
	}

	public void setOperare(Date operare) {
		this.operare = operare;
	}

	@Column(name = "verstor", precision = 1, scale = 0)
	public Boolean getVerstor() {
		return this.verstor;
	}

	public void setVerstor(Boolean verstor) {
		this.verstor = verstor;
	}

	@Column(name = "nivacc")
	public Integer getNivacc() {
		return this.nivacc;
	}

	public void setNivacc(Integer nivacc) {
		this.nivacc = nivacc;
	}

	@Column(name = "tiparit", length = 1)
	public Character getTiparit() {
		return this.tiparit;
	}

	public void setTiparit(Character tiparit) {
		this.tiparit = tiparit;
	}

	@Column(name = "zscadenta")
	public Integer getZscadenta() {
		return this.zscadenta;
	}

	public void setZscadenta(Integer zscadenta) {
		this.zscadenta = zscadenta;
	}

	@Column(name = "nrfact", length = 16)
	public String getNrfact() {
		return this.nrfact;
	}

	public void setNrfact(String nrfact) {
		this.nrfact = nrfact;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_f", length = 13)
	public Date getDataF() {
		return this.dataF;
	}

	public void setDataF(Date dataF) {
		this.dataF = dataF;
	}

	@Column(name = "valoare", precision = 14)
	public BigDecimal getValoare() {
		return this.valoare;
	}

	public void setValoare(BigDecimal valoare) {
		this.valoare = valoare;
	}

	@Column(name = "val_disc_expl", precision = 14)
	public BigDecimal getValDiscExpl() {
		return this.valDiscExpl;
	}

	public void setValDiscExpl(BigDecimal valDiscExpl) {
		this.valDiscExpl = valDiscExpl;
	}

	@Column(name = "pr_disc_expl", precision = 6)
	public BigDecimal getPrDiscExpl() {
		return this.prDiscExpl;
	}

	public void setPrDiscExpl(BigDecimal prDiscExpl) {
		this.prDiscExpl = prDiscExpl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creare", length = 29)
	public Date getCreare() {
		return this.creare;
	}

	public void setCreare(Date creare) {
		this.creare = creare;
	}

	@Column(name = "nrop")
	public Integer getNrop() {
		return this.nrop;
	}

	public void setNrop(Integer nrop) {
		this.nrop = nrop;
	}

	@Column(name = "id_ext", length = 10)
	public String getIdExt() {
		return this.idExt;
	}

	public void setIdExt(String idExt) {
		this.idExt = idExt;
	}

	@Column(name = "msg_id", length = 4)
	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comenziVExt")
	public Set <ComenziCvExt> getComenziCvExts() {
		return this.comenziCvExts;
	}

	public void setComenziCvExts(Set <ComenziCvExt> comenziCvExts) {
		this.comenziCvExts = comenziCvExts;
	}

	@Override
	public String toString(){
		return this.getNumereLucru().getDenumire();
		
	}
	
}

/*

-- Table: comenzi_v_ext

-- DROP TABLE comenzi_v_ext;

CREATE TABLE comenzi_v_ext
(
  com_id character(10) NOT NULL DEFAULT fpliid('comenzi_v_ext'::text, 8),
  nrdoc character(16),
  data_c date,
  gestiune_id character(7),
  nrlc_id character(7),
  tert_id character(9),
  data_l date,
  facturat character(1),
  user_id character(5),
  operare timestamp without time zone DEFAULT ('now'::text)::timestamp(6) without time zone,
  verstor numeric(1,0),
  nivacc integer,
  tiparit character(1) DEFAULT 'n'::bpchar,
  zscadenta integer,
  nrfact character(16),
  data_f date,
  valoare numeric(14,2),
  val_disc_expl numeric(14,2),
  pr_disc_expl numeric(6,2),
  creare timestamp without time zone DEFAULT ('now'::text)::timestamp(6) without time zone,
  nrop integer DEFAULT 0,
  id_ext character(10) DEFAULT ''::bpchar,
  msg_id character(4) DEFAULT ''::bpchar,
  CONSTRAINT comenzi_v_ext_com_id_pky PRIMARY KEY (com_id),
  CONSTRAINT nrlc_id FOREIGN KEY (nrlc_id)
      REFERENCES numere_lucru (nrlc_id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tert_id FOREIGN KEY (tert_id)
      REFERENCES terti (tert_id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE comenzi_v_ext OWNER TO postgres;

-- Index: comenzi_v_ext_data_c_idx

-- DROP INDEX comenzi_v_ext_data_c_idx;

CREATE INDEX comenzi_v_ext_data_c_idx
  ON comenzi_v_ext
  USING btree
  (data_c);

-- Index: "comenzi_v_ext_data_c_idx  "

-- DROP INDEX "comenzi_v_ext_data_c_idx  ";

CREATE INDEX "comenzi_v_ext_data_c_idx  "
  ON comenzi_v_ext
  USING btree
  (data_c);



*/