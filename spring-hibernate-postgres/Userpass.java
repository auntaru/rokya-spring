// default package
// Generated Jul 24, 2015 10:13:24 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userpass generated by hbm2java
 */
@Entity
@Table(name = "userpass", schema = "public")
public class Userpass implements java.io.Serializable {

	private int userId;
	private String secret;
	private Integer chiefId;
	private Integer zoneId;

	public Userpass() {
	}

	public Userpass(int userId, String secret) {
		this.userId = userId;
		this.secret = secret;
	}

	public Userpass(int userId, String secret, Integer chiefId, Integer zoneId) {
		this.userId = userId;
		this.secret = secret;
		this.chiefId = chiefId;
		this.zoneId = zoneId;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "secret", nullable = false)
	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Column(name = "chief_id")
	public Integer getChiefId() {
		return this.chiefId;
	}

	public void setChiefId(Integer chiefId) {
		this.chiefId = chiefId;
	}

	@Column(name = "zone_id")
	public Integer getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

}
