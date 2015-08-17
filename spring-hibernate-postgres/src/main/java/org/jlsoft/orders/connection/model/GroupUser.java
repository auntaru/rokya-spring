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
 * GroupUser generated by hbm2java
 */
@Entity
@Table(name = "group_user", schema = "public")
public class GroupUser implements java.io.Serializable {

	private int groupacc;
	private String denumire;
	private Boolean activat;
	private Date operare;
	private Set <UserIdent> userIdents = new HashSet(0);

	public GroupUser() {
	}

	public GroupUser(int groupacc) {
		this.groupacc = groupacc;
	}

	public GroupUser(int groupacc, String denumire, Boolean activat,
			Date operare, Set <UserIdent> userIdents) {
		this.groupacc = groupacc;
		this.denumire = denumire;
		this.activat = activat;
		this.operare = operare;
		this.userIdents = userIdents;
	}

	@Id
	@Column(name = "groupacc", unique = true, nullable = false)
	public int getGroupacc() {
		return this.groupacc;
	}

	public void setGroupacc(int groupacc) {
		this.groupacc = groupacc;
	}

	@Column(name = "denumire", length = 30)
	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	@Column(name = "activat")
	public Boolean getActivat() {
		return this.activat;
	}

	public void setActivat(Boolean activat) {
		this.activat = activat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operare", length = 29)
	public Date getOperare() {
		return this.operare;
	}

	public void setOperare(Date operare) {
		this.operare = operare;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupUser")
	public Set <UserIdent> getUserIdents() {
		return this.userIdents;
	}

	public void setUserIdents(Set <UserIdent> userIdents) {
		this.userIdents = userIdents;
	}

}
