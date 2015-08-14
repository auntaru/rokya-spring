// default package
// Generated Aug 13, 2015 8:44:07 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ZonaId generated by hbm2java
 */
@Embeddable
public class ZonaId implements java.io.Serializable {

	private int zonaId;
	private String denumire;
	private int version;
	private int nrAgenti;
	private int nrAgentiRmn;
	private int nrAgentiTraditionali;

	public ZonaId() {
	}

	public ZonaId(int zonaId, String denumire, int version, int nrAgenti,
			int nrAgentiRmn, int nrAgentiTraditionali) {
		this.zonaId = zonaId;
		this.denumire = denumire;
		this.version = version;
		this.nrAgenti = nrAgenti;
		this.nrAgentiRmn = nrAgentiRmn;
		this.nrAgentiTraditionali = nrAgentiTraditionali;
	}

	@Column(name = "zona_id", nullable = false)
	public int getZonaId() {
		return this.zonaId;
	}

	public void setZonaId(int zonaId) {
		this.zonaId = zonaId;
	}

	@Column(name = "denumire", nullable = false)
	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	@Column(name = "Version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "NrAgenti", nullable = false)
	public int getNrAgenti() {
		return this.nrAgenti;
	}

	public void setNrAgenti(int nrAgenti) {
		this.nrAgenti = nrAgenti;
	}

	@Column(name = "NrAgentiRMN", nullable = false)
	public int getNrAgentiRmn() {
		return this.nrAgentiRmn;
	}

	public void setNrAgentiRmn(int nrAgentiRmn) {
		this.nrAgentiRmn = nrAgentiRmn;
	}

	@Column(name = "NrAgentiTraditionali", nullable = false)
	public int getNrAgentiTraditionali() {
		return this.nrAgentiTraditionali;
	}

	public void setNrAgentiTraditionali(int nrAgentiTraditionali) {
		this.nrAgentiTraditionali = nrAgentiTraditionali;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZonaId))
			return false;
		ZonaId castOther = (ZonaId) other;

		return (this.getZonaId() == castOther.getZonaId())
				&& ((this.getDenumire() == castOther.getDenumire()) || (this
						.getDenumire() != null
						&& castOther.getDenumire() != null && this
						.getDenumire().equals(castOther.getDenumire())))
				&& (this.getVersion() == castOther.getVersion())
				&& (this.getNrAgenti() == castOther.getNrAgenti())
				&& (this.getNrAgentiRmn() == castOther.getNrAgentiRmn())
				&& (this.getNrAgentiTraditionali() == castOther
						.getNrAgentiTraditionali());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getZonaId();
		result = 37 * result
				+ (getDenumire() == null ? 0 : this.getDenumire().hashCode());
		result = 37 * result + this.getVersion();
		result = 37 * result + this.getNrAgenti();
		result = 37 * result + this.getNrAgentiRmn();
		result = 37 * result + this.getNrAgentiTraditionali();
		return result;
	}

}
