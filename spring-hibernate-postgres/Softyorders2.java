// default package
// Generated Jul 24, 2015 10:13:24 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Softyorders2 generated by hbm2java
 */
@Entity
@Table(name = "softyorders2", schema = "public")
public class Softyorders2 implements java.io.Serializable {

	private Softyorders2Id id;

	public Softyorders2() {
	}

	public Softyorders2(Softyorders2Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "lineorder", column = @Column(name = "lineorder", precision = 131089, scale = 0)),
			@AttributeOverride(name = "client", column = @Column(name = "client")),
			@AttributeOverride(name = "product", column = @Column(name = "product")),
			@AttributeOverride(name = "pieces", column = @Column(name = "pieces")),
			@AttributeOverride(name = "discount", column = @Column(name = "discount")) })
	public Softyorders2Id getId() {
		return this.id;
	}

	public void setId(Softyorders2Id id) {
		this.id = id;
	}

}
