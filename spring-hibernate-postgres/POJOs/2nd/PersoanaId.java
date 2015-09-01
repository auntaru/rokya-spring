// default package
// Generated Aug 13, 2015 8:44:07 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersoanaId generated by hbm2java
 */
@Embeddable
public class PersoanaId implements java.io.Serializable {

	private int persoanaId;
	private short anulat;
	private String denumire;
	private int version;
	private String phone;

	public PersoanaId() {
	}

	public PersoanaId(int persoanaId, short anulat, String denumire, int version) {
		this.persoanaId = persoanaId;
		this.anulat = anulat;
		this.denumire = denumire;
		this.version = version;
	}

	public PersoanaId(int persoanaId, short anulat, String denumire,
			int version, String phone) {
		this.persoanaId = persoanaId;
		this.anulat = anulat;
		this.denumire = denumire;
		this.version = version;
		this.phone = phone;
	}

	@Column(name = "persoana_id", nullable = false)
	public int getPersoanaId() {
		return this.persoanaId;
	}

	public void setPersoanaId(int persoanaId) {
		this.persoanaId = persoanaId;
	}

	@Column(name = "anulat", nullable = false)
	public short getAnulat() {
		return this.anulat;
	}

	public void setAnulat(short anulat) {
		this.anulat = anulat;
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

	@Column(name = "Phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersoanaId))
			return false;
		PersoanaId castOther = (PersoanaId) other;

		return (this.getPersoanaId() == castOther.getPersoanaId())
				&& (this.getAnulat() == castOther.getAnulat())
				&& ((this.getDenumire() == castOther.getDenumire()) || (this
						.getDenumire() != null
						&& castOther.getDenumire() != null && this
						.getDenumire().equals(castOther.getDenumire())))
				&& (this.getVersion() == castOther.getVersion())
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null && castOther.getPhone() != null && this
						.getPhone().equals(castOther.getPhone())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPersoanaId();
		result = 37 * result + this.getAnulat();
		result = 37 * result
				+ (getDenumire() == null ? 0 : this.getDenumire().hashCode());
		result = 37 * result + this.getVersion();
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		return result;
	}

}