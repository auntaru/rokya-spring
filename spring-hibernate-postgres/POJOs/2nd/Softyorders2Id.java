// default package
// Generated Aug 13, 2015 8:44:07 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Softyorders2Id generated by hbm2java
 */
@Embeddable
public class Softyorders2Id implements java.io.Serializable {

	private BigDecimal lineorder;
	private String client;
	private String product;
	private String pieces;
	private String discount;

	public Softyorders2Id() {
	}

	public Softyorders2Id(BigDecimal lineorder, String client, String product,
			String pieces, String discount) {
		this.lineorder = lineorder;
		this.client = client;
		this.product = product;
		this.pieces = pieces;
		this.discount = discount;
	}

	@Column(name = "lineorder", precision = 131089, scale = 0)
	public BigDecimal getLineorder() {
		return this.lineorder;
	}

	public void setLineorder(BigDecimal lineorder) {
		this.lineorder = lineorder;
	}

	@Column(name = "client")
	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Column(name = "product")
	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "pieces")
	public String getPieces() {
		return this.pieces;
	}

	public void setPieces(String pieces) {
		this.pieces = pieces;
	}

	@Column(name = "discount")
	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Softyorders2Id))
			return false;
		Softyorders2Id castOther = (Softyorders2Id) other;

		return ((this.getLineorder() == castOther.getLineorder()) || (this
				.getLineorder() != null && castOther.getLineorder() != null && this
				.getLineorder().equals(castOther.getLineorder())))
				&& ((this.getClient() == castOther.getClient()) || (this
						.getClient() != null && castOther.getClient() != null && this
						.getClient().equals(castOther.getClient())))
				&& ((this.getProduct() == castOther.getProduct()) || (this
						.getProduct() != null && castOther.getProduct() != null && this
						.getProduct().equals(castOther.getProduct())))
				&& ((this.getPieces() == castOther.getPieces()) || (this
						.getPieces() != null && castOther.getPieces() != null && this
						.getPieces().equals(castOther.getPieces())))
				&& ((this.getDiscount() == castOther.getDiscount()) || (this
						.getDiscount() != null
						&& castOther.getDiscount() != null && this
						.getDiscount().equals(castOther.getDiscount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLineorder() == null ? 0 : this.getLineorder().hashCode());
		result = 37 * result
				+ (getClient() == null ? 0 : this.getClient().hashCode());
		result = 37 * result
				+ (getProduct() == null ? 0 : this.getProduct().hashCode());
		result = 37 * result
				+ (getPieces() == null ? 0 : this.getPieces().hashCode());
		result = 37 * result
				+ (getDiscount() == null ? 0 : this.getDiscount().hashCode());
		return result;
	}

}
