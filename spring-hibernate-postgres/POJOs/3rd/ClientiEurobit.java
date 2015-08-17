// default package
// Generated Aug 17, 2015 9:12:26 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClientiEurobit generated by hbm2java
 */
@Entity
@Table(name = "clienti_eurobit", schema = "public")
public class ClientiEurobit implements java.io.Serializable {

	private String tertId;
	private String cui;
	private String plt;
	private String client;
	private String categorie;
	private String grupa;
	private String clasa;
	private String categorieId;
	private String grupaId;
	private String clasaId;

	public ClientiEurobit() {
	}

	public ClientiEurobit(String tertId) {
		this.tertId = tertId;
	}

	public ClientiEurobit(String tertId, String cui, String plt, String client,
			String categorie, String grupa, String clasa, String categorieId,
			String grupaId, String clasaId) {
		this.tertId = tertId;
		this.cui = cui;
		this.plt = plt;
		this.client = client;
		this.categorie = categorie;
		this.grupa = grupa;
		this.clasa = clasa;
		this.categorieId = categorieId;
		this.grupaId = grupaId;
		this.clasaId = clasaId;
	}

	@Id
	@Column(name = "tert_id", unique = true, nullable = false, length = 9)
	public String getTertId() {
		return this.tertId;
	}

	public void setTertId(String tertId) {
		this.tertId = tertId;
	}

	@Column(name = "cui", length = 14)
	public String getCui() {
		return this.cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	@Column(name = "plt", length = 2)
	public String getPlt() {
		return this.plt;
	}

	public void setPlt(String plt) {
		this.plt = plt;
	}

	@Column(name = "client")
	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Column(name = "categorie", length = 35)
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Column(name = "grupa", length = 35)
	public String getGrupa() {
		return this.grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	@Column(name = "clasa", length = 35)
	public String getClasa() {
		return this.clasa;
	}

	public void setClasa(String clasa) {
		this.clasa = clasa;
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

}
