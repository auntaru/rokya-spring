package org.jlsoft.orders.connection.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
	private String nrdoc;
	private Date dataC;
	private String gestiuneId;
	private String nrlcId;
	private String tertId;
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
	// private Set comenziCvExts = new HashSet(0);
	// Caused by: org.hibernate.AnnotationException: Collection has neither generic type or OneToMany.targetEntity() defined: org.jlsoft.orders.connection.model.ComenziVExt.comenziCvExts
	// http://www.mkyong.com/hibernate/org-hibernate-annotationexception-collection-has-neither-generic-type-or-onetomany-targetentity/
	private Set <ComenziCvExt> comenziCvExts = new HashSet(0);

	
	public ComenziVExt() {
	}

	public ComenziVExt(String comId) {
		this.comId = comId;
	}

	public ComenziVExt(String comId, String nrdoc, Date dataC,
			String gestiuneId, String nrlcId, String tertId, Date dataL,
			Character facturat, String userId, Date operare, Boolean verstor,
			Integer nivacc, Character tiparit, Integer zscadenta,
			String nrfact, Date dataF, BigDecimal valoare,
			BigDecimal valDiscExpl, BigDecimal prDiscExpl, Date creare,
			Integer nrop, String idExt, String msgId, Set <ComenziCvExt> comenziCvExts) {
		this.comId = comId;
		this.nrdoc = nrdoc;
		this.dataC = dataC;
		this.gestiuneId = gestiuneId;
		this.nrlcId = nrlcId;
		this.tertId = tertId;
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
	
/*
	public ComenziVExt(String comId, String nrdoc, Date dataC,
			String gestiuneId, String nrlcId, String tertId, Date dataL,
			Character facturat, String userId, Date operare, Boolean verstor,
			Integer nivacc, Character tiparit, Integer zscadenta,
			String nrfact, Date dataF, BigDecimal valoare,
			BigDecimal valDiscExpl, BigDecimal prDiscExpl, Date creare,
			Integer nrop, String idExt, String msgId, Set comenziCvExts) {
		this.comId = comId;
		this.nrdoc = nrdoc;
		this.dataC = dataC;
		this.gestiuneId = gestiuneId;
		this.nrlcId = nrlcId;
		this.tertId = tertId;
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
*/
	
	
	
	@Id
	@Column(name = "com_id", unique = true, nullable = false, length = 10)
	public String getComId() {
		return this.comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
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

	@Column(name = "nrlc_id", length = 7)
	public String getNrlcId() {
		return this.nrlcId;
	}

	public void setNrlcId(String nrlcId) {
		this.nrlcId = nrlcId;
	}

	@Column(name = "tert_id", length = 9)
	public String getTertId() {
		return this.tertId;
	}

	public void setTertId(String tertId) {
		this.tertId = tertId;
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
/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comenziVExt")
	public Set getComenziCvExts() {
		return this.comenziCvExts;
	}

	public void setComenziCvExts(Set comenziCvExts) {
		this.comenziCvExts = comenziCvExts;
	}
*/	
	
}
