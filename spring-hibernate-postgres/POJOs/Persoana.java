// default package
// Generated Jul 24, 2015 10:13:24 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Persoana generated by hbm2java
 */
@Entity
@Table(name = "persoana", schema = "public")
public class Persoana implements java.io.Serializable {

	private PersoanaId id;

	public Persoana() {
	}

	public Persoana(PersoanaId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "persoanaId", column = @Column(name = "persoana_id", nullable = false)),
			@AttributeOverride(name = "anulat", column = @Column(name = "anulat", nullable = false)),
			@AttributeOverride(name = "denumire", column = @Column(name = "denumire", nullable = false)),
			@AttributeOverride(name = "version", column = @Column(name = "Version", nullable = false)),
			@AttributeOverride(name = "phone", column = @Column(name = "Phone")) })
	public PersoanaId getId() {
		return this.id;
	}

	public void setId(PersoanaId id) {
		this.id = id;
	}

}
