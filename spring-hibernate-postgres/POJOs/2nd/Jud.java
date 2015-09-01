// default package
// Generated Aug 13, 2015 8:44:07 PM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jud generated by hbm2java
 */
@Entity
@Table(name = "jud", schema = "public")
public class Jud implements java.io.Serializable {

	private byte jud;
	private String denj;
	private Byte fsj;
	private String mnemonic;
	private Boolean zona;
	private Set sirutas = new HashSet(0);

	public Jud() {
	}

	public Jud(byte jud) {
		this.jud = jud;
	}

	public Jud(byte jud, String denj, Byte fsj, String mnemonic, Boolean zona,
			Set sirutas) {
		this.jud = jud;
		this.denj = denj;
		this.fsj = fsj;
		this.mnemonic = mnemonic;
		this.zona = zona;
		this.sirutas = sirutas;
	}

	@Id
	@Column(name = "jud", unique = true, nullable = false, precision = 2, scale = 0)
	public byte getJud() {
		return this.jud;
	}

	public void setJud(byte jud) {
		this.jud = jud;
	}

	@Column(name = "denj", length = 20)
	public String getDenj() {
		return this.denj;
	}

	public void setDenj(String denj) {
		this.denj = denj;
	}

	@Column(name = "fsj", precision = 2, scale = 0)
	public Byte getFsj() {
		return this.fsj;
	}

	public void setFsj(Byte fsj) {
		this.fsj = fsj;
	}

	@Column(name = "mnemonic", length = 2)
	public String getMnemonic() {
		return this.mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	@Column(name = "zona", precision = 1, scale = 0)
	public Boolean getZona() {
		return this.zona;
	}

	public void setZona(Boolean zona) {
		this.zona = zona;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jud")
	public Set getSirutas() {
		return this.sirutas;
	}

	public void setSirutas(Set sirutas) {
		this.sirutas = sirutas;
	}

}