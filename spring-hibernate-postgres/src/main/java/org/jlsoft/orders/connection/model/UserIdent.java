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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserIdent generated by hbm2java
 */
@Entity
@Table(name = "user_ident", schema = "public")
public class UserIdent implements java.io.Serializable {

	private String userId;
	private GroupUser groupUser;
	private String pli;
	private String nick;
	private String numePrenume;
	private String privacy;
	private String cnp;
	private Date operare;
	private String ci;
	// private Set <Terti> tertis = new HashSet(0);

	public UserIdent() {
	}

	public UserIdent(String userId) {
		this.userId = userId;
	}

	public UserIdent(String userId, GroupUser groupUser, String pli,
			String nick, String numePrenume, String privacy, String cnp,
			Date operare, String ci, Set <Terti> tertis) {
		this.userId = userId;
		this.groupUser = groupUser;
		this.pli = pli;
		this.nick = nick;
		this.numePrenume = numePrenume;
		this.privacy = privacy;
		this.cnp = cnp;
		this.operare = operare;
		this.ci = ci;
		// this.tertis = tertis;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 5)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupacc")
	public GroupUser getGroupUser() {
		return this.groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}

	@Column(name = "pli", length = 2)
	public String getPli() {
		return this.pli;
	}

	public void setPli(String pli) {
		this.pli = pli;
	}

	@Column(name = "nick", length = 10)
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "nume_prenume", length = 40)
	public String getNumePrenume() {
		return this.numePrenume;
	}

	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}

	@Column(name = "privacy", length = 10)
	public String getPrivacy() {
		return this.privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	@Column(name = "cnp", length = 16)
	public String getCnp() {
		return this.cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operare", length = 29)
	public Date getOperare() {
		return this.operare;
	}

	public void setOperare(Date operare) {
		this.operare = operare;
	}

	@Column(name = "ci", length = 20)
	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}
/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userIdent")
	public Set <Terti> getTertis() {
		return this.tertis;
	}

	public void setTertis(Set <Terti> tertis) {
		this.tertis = tertis;
	}
*/
}
