// default package
// Generated Aug 13, 2015 8:44:07 PM by Hibernate Tools 3.6.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Wine generated by hbm2java
 */
@Entity
@Table(name = "wine", schema = "public")
public class Wine implements java.io.Serializable {

	private WineId id;

	public Wine() {
	}

	public Wine(WineId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id")),
			@AttributeOverride(name = "name", column = @Column(name = "name")),
			@AttributeOverride(name = "year", column = @Column(name = "year")),
			@AttributeOverride(name = "grapes", column = @Column(name = "grapes")),
			@AttributeOverride(name = "country", column = @Column(name = "country")),
			@AttributeOverride(name = "region", column = @Column(name = "region")),
			@AttributeOverride(name = "description", column = @Column(name = "description")),
			@AttributeOverride(name = "picture", column = @Column(name = "picture")) })
	public WineId getId() {
		return this.id;
	}

	public void setId(WineId id) {
		this.id = id;
	}

}