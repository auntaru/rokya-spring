// default package
// Generated Aug 17, 2015 9:12:26 PM by Hibernate Tools 3.6.0
package org.jlsoft.orders.connection.model;
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
 * NumereLucru generated by hbm2java
 */
@Entity
@Table(name = "numere_lucru", schema = "public")
public class NumereLucru implements java.io.Serializable {

	private String nrlcId;
	private String superior;
	private String nick;
	private String denumire;
	private String denumireExt;
	private String categorieId;
	private String grupaId;
	private String clasaId;
	private Date data0;
	private Character sw0;
	private String userId;
	private Date operare;
	private Integer nivacc;
	private String idExt;
	private Set <ComenziVExt> comenziVExts = new HashSet <ComenziVExt> (0);

	public NumereLucru() {
	}

	public NumereLucru(String nrlcId) {
		this.nrlcId = nrlcId;
	}

	public NumereLucru(String nrlcId, String superior, String nick,
			String denumire, String denumireExt, String categorieId,
			String grupaId, String clasaId, Date data0, Character sw0,
			String userId, Date operare, Integer nivacc, String idExt,
			Set <ComenziVExt> comenziVExts) {
		this.nrlcId = nrlcId;
		this.superior = superior;
		this.nick = nick;
		this.denumire = denumire;
		this.denumireExt = denumireExt;
		this.categorieId = categorieId;
		this.grupaId = grupaId;
		this.clasaId = clasaId;
		this.data0 = data0;
		this.sw0 = sw0;
		this.userId = userId;
		this.operare = operare;
		this.nivacc = nivacc;
		this.idExt = idExt;
		this.comenziVExts = comenziVExts;
	}

	@Id
	@Column(name = "nrlc_id", unique = true, nullable = false, length = 7)
	public String getNrlcId() {
		return this.nrlcId;
	}

	public void setNrlcId(String nrlcId) {
		this.nrlcId = nrlcId;
	}

	@Column(name = "superior", length = 7)
	public String getSuperior() {
		return this.superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	@Column(name = "nick", length = 10)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "denumire", length = 40)
	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	@Column(name = "denumire_ext", length = 55)
	public String getDenumireExt() {
		return this.denumireExt;
	}

	public void setDenumireExt(String denumireExt) {
		this.denumireExt = denumireExt;
	}

	@Column(name = "categorie_id", length = 4)
	public String getCategorieId() {
		return this.categorieId;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	@Column(name = "grupa_id", length = 4)
	public String getGrupaId() {
		return this.grupaId;
	}

	public void setGrupaId(String grupaId) {
		this.grupaId = grupaId;
	}

	@Column(name = "clasa_id", length = 4)
	public String getClasaId() {
		return this.clasaId;
	}

	public void setClasaId(String clasaId) {
		this.clasaId = clasaId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_0", length = 13)
	public Date getData0() {
		return this.data0;
	}

	public void setData0(Date data0) {
		this.data0 = data0;
	}

	@Column(name = "sw_0", length = 1)
	public Character getSw0() {
		return this.sw0;
	}

	public void setSw0(Character sw0) {
		this.sw0 = sw0;
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

	@Column(name = "nivacc")
	public Integer getNivacc() {
		return this.nivacc;
	}

	public void setNivacc(Integer nivacc) {
		this.nivacc = nivacc;
	}

	@Column(name = "id_ext", length = 7)
	public String getIdExt() {
		return this.idExt;
	}

	public void setIdExt(String idExt) {
		this.idExt = idExt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "numereLucru")
	public Set <ComenziVExt> getComenziVExts() {
		return this.comenziVExts;
	}

	public void setComenziVExts(Set <ComenziVExt> comenziVExts) {
		this.comenziVExts = comenziVExts;
	}

	@Override
	public String toString(){
		// return this.getDenumire();
		return denumire;
	}

}
