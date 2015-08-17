// default package
// Generated Aug 17, 2015 9:12:26 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductId generated by hbm2java
 */
@Embeddable
public class ProductId implements java.io.Serializable {

	private int productId;
	private String productName;
	private Integer aromaId;
	private Integer grupaId;
	private Integer marcaId;
	private Integer tipId;
	private Integer litrajId;
	private Integer tipAmbalajId;
	private Integer greutateId;
	private Integer producatorId;
	private Integer umid;
	private Integer classId;
	private BigDecimal price;
	private BigDecimal pret2;
	private BigDecimal pret3;
	private BigDecimal pret4;
	private BigDecimal pret5;
	private int version;
	private char anulat;
	private String valabilitate;
	private String bucDisplay;
	private String bucBax;
	private String baxPal;
	private String symbol;
	private String gramaj;
	private Integer categorieId;
	private int customVersion;
	private char blocatLaDiscount;
	private BigDecimal discount;
	private char blocareGratuitate;

	public ProductId() {
	}

	public ProductId(int productId, BigDecimal price, BigDecimal pret2,
			BigDecimal pret3, BigDecimal pret4, BigDecimal pret5, int version,
			char anulat, int customVersion, char blocatLaDiscount,
			BigDecimal discount, char blocareGratuitate) {
		this.productId = productId;
		this.price = price;
		this.pret2 = pret2;
		this.pret3 = pret3;
		this.pret4 = pret4;
		this.pret5 = pret5;
		this.version = version;
		this.anulat = anulat;
		this.customVersion = customVersion;
		this.blocatLaDiscount = blocatLaDiscount;
		this.discount = discount;
		this.blocareGratuitate = blocareGratuitate;
	}

	public ProductId(int productId, String productName, Integer aromaId,
			Integer grupaId, Integer marcaId, Integer tipId, Integer litrajId,
			Integer tipAmbalajId, Integer greutateId, Integer producatorId,
			Integer umid, Integer classId, BigDecimal price, BigDecimal pret2,
			BigDecimal pret3, BigDecimal pret4, BigDecimal pret5, int version,
			char anulat, String valabilitate, String bucDisplay, String bucBax,
			String baxPal, String symbol, String gramaj, Integer categorieId,
			int customVersion, char blocatLaDiscount, BigDecimal discount,
			char blocareGratuitate) {
		this.productId = productId;
		this.productName = productName;
		this.aromaId = aromaId;
		this.grupaId = grupaId;
		this.marcaId = marcaId;
		this.tipId = tipId;
		this.litrajId = litrajId;
		this.tipAmbalajId = tipAmbalajId;
		this.greutateId = greutateId;
		this.producatorId = producatorId;
		this.umid = umid;
		this.classId = classId;
		this.price = price;
		this.pret2 = pret2;
		this.pret3 = pret3;
		this.pret4 = pret4;
		this.pret5 = pret5;
		this.version = version;
		this.anulat = anulat;
		this.valabilitate = valabilitate;
		this.bucDisplay = bucDisplay;
		this.bucBax = bucBax;
		this.baxPal = baxPal;
		this.symbol = symbol;
		this.gramaj = gramaj;
		this.categorieId = categorieId;
		this.customVersion = customVersion;
		this.blocatLaDiscount = blocatLaDiscount;
		this.discount = discount;
		this.blocareGratuitate = blocareGratuitate;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "product_name")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "AromaID")
	public Integer getAromaId() {
		return this.aromaId;
	}

	public void setAromaId(Integer aromaId) {
		this.aromaId = aromaId;
	}

	@Column(name = "GrupaID")
	public Integer getGrupaId() {
		return this.grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	@Column(name = "MarcaID")
	public Integer getMarcaId() {
		return this.marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	@Column(name = "TipID")
	public Integer getTipId() {
		return this.tipId;
	}

	public void setTipId(Integer tipId) {
		this.tipId = tipId;
	}

	@Column(name = "LitrajID")
	public Integer getLitrajId() {
		return this.litrajId;
	}

	public void setLitrajId(Integer litrajId) {
		this.litrajId = litrajId;
	}

	@Column(name = "TipAmbalajID")
	public Integer getTipAmbalajId() {
		return this.tipAmbalajId;
	}

	public void setTipAmbalajId(Integer tipAmbalajId) {
		this.tipAmbalajId = tipAmbalajId;
	}

	@Column(name = "GreutateID")
	public Integer getGreutateId() {
		return this.greutateId;
	}

	public void setGreutateId(Integer greutateId) {
		this.greutateId = greutateId;
	}

	@Column(name = "ProducatorID")
	public Integer getProducatorId() {
		return this.producatorId;
	}

	public void setProducatorId(Integer producatorId) {
		this.producatorId = producatorId;
	}

	@Column(name = "UMID")
	public Integer getUmid() {
		return this.umid;
	}

	public void setUmid(Integer umid) {
		this.umid = umid;
	}

	@Column(name = "class_id")
	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Column(name = "price", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "Pret2", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getPret2() {
		return this.pret2;
	}

	public void setPret2(BigDecimal pret2) {
		this.pret2 = pret2;
	}

	@Column(name = "Pret3", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getPret3() {
		return this.pret3;
	}

	public void setPret3(BigDecimal pret3) {
		this.pret3 = pret3;
	}

	@Column(name = "Pret4", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getPret4() {
		return this.pret4;
	}

	public void setPret4(BigDecimal pret4) {
		this.pret4 = pret4;
	}

	@Column(name = "Pret5", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getPret5() {
		return this.pret5;
	}

	public void setPret5(BigDecimal pret5) {
		this.pret5 = pret5;
	}

	@Column(name = "Version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "Anulat", nullable = false, length = 1)
	public char getAnulat() {
		return this.anulat;
	}

	public void setAnulat(char anulat) {
		this.anulat = anulat;
	}

	@Column(name = "Valabilitate")
	public String getValabilitate() {
		return this.valabilitate;
	}

	public void setValabilitate(String valabilitate) {
		this.valabilitate = valabilitate;
	}

	@Column(name = "BucDisplay")
	public String getBucDisplay() {
		return this.bucDisplay;
	}

	public void setBucDisplay(String bucDisplay) {
		this.bucDisplay = bucDisplay;
	}

	@Column(name = "BucBax")
	public String getBucBax() {
		return this.bucBax;
	}

	public void setBucBax(String bucBax) {
		this.bucBax = bucBax;
	}

	@Column(name = "BaxPal")
	public String getBaxPal() {
		return this.baxPal;
	}

	public void setBaxPal(String baxPal) {
		this.baxPal = baxPal;
	}

	@Column(name = "symbol")
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name = "Gramaj")
	public String getGramaj() {
		return this.gramaj;
	}

	public void setGramaj(String gramaj) {
		this.gramaj = gramaj;
	}

	@Column(name = "CategorieId")
	public Integer getCategorieId() {
		return this.categorieId;
	}

	public void setCategorieId(Integer categorieId) {
		this.categorieId = categorieId;
	}

	@Column(name = "CustomVersion", nullable = false)
	public int getCustomVersion() {
		return this.customVersion;
	}

	public void setCustomVersion(int customVersion) {
		this.customVersion = customVersion;
	}

	@Column(name = "BlocatLaDiscount", nullable = false, length = 1)
	public char getBlocatLaDiscount() {
		return this.blocatLaDiscount;
	}

	public void setBlocatLaDiscount(char blocatLaDiscount) {
		this.blocatLaDiscount = blocatLaDiscount;
	}

	@Column(name = "Discount", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Column(name = "BlocareGratuitate", nullable = false, length = 1)
	public char getBlocareGratuitate() {
		return this.blocareGratuitate;
	}

	public void setBlocareGratuitate(char blocareGratuitate) {
		this.blocareGratuitate = blocareGratuitate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductId))
			return false;
		ProductId castOther = (ProductId) other;

		return (this.getProductId() == castOther.getProductId())
				&& ((this.getProductName() == castOther.getProductName()) || (this
						.getProductName() != null
						&& castOther.getProductName() != null && this
						.getProductName().equals(castOther.getProductName())))
				&& ((this.getAromaId() == castOther.getAromaId()) || (this
						.getAromaId() != null && castOther.getAromaId() != null && this
						.getAromaId().equals(castOther.getAromaId())))
				&& ((this.getGrupaId() == castOther.getGrupaId()) || (this
						.getGrupaId() != null && castOther.getGrupaId() != null && this
						.getGrupaId().equals(castOther.getGrupaId())))
				&& ((this.getMarcaId() == castOther.getMarcaId()) || (this
						.getMarcaId() != null && castOther.getMarcaId() != null && this
						.getMarcaId().equals(castOther.getMarcaId())))
				&& ((this.getTipId() == castOther.getTipId()) || (this
						.getTipId() != null && castOther.getTipId() != null && this
						.getTipId().equals(castOther.getTipId())))
				&& ((this.getLitrajId() == castOther.getLitrajId()) || (this
						.getLitrajId() != null
						&& castOther.getLitrajId() != null && this
						.getLitrajId().equals(castOther.getLitrajId())))
				&& ((this.getTipAmbalajId() == castOther.getTipAmbalajId()) || (this
						.getTipAmbalajId() != null
						&& castOther.getTipAmbalajId() != null && this
						.getTipAmbalajId().equals(castOther.getTipAmbalajId())))
				&& ((this.getGreutateId() == castOther.getGreutateId()) || (this
						.getGreutateId() != null
						&& castOther.getGreutateId() != null && this
						.getGreutateId().equals(castOther.getGreutateId())))
				&& ((this.getProducatorId() == castOther.getProducatorId()) || (this
						.getProducatorId() != null
						&& castOther.getProducatorId() != null && this
						.getProducatorId().equals(castOther.getProducatorId())))
				&& ((this.getUmid() == castOther.getUmid()) || (this.getUmid() != null
						&& castOther.getUmid() != null && this.getUmid()
						.equals(castOther.getUmid())))
				&& ((this.getClassId() == castOther.getClassId()) || (this
						.getClassId() != null && castOther.getClassId() != null && this
						.getClassId().equals(castOther.getClassId())))
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())))
				&& ((this.getPret2() == castOther.getPret2()) || (this
						.getPret2() != null && castOther.getPret2() != null && this
						.getPret2().equals(castOther.getPret2())))
				&& ((this.getPret3() == castOther.getPret3()) || (this
						.getPret3() != null && castOther.getPret3() != null && this
						.getPret3().equals(castOther.getPret3())))
				&& ((this.getPret4() == castOther.getPret4()) || (this
						.getPret4() != null && castOther.getPret4() != null && this
						.getPret4().equals(castOther.getPret4())))
				&& ((this.getPret5() == castOther.getPret5()) || (this
						.getPret5() != null && castOther.getPret5() != null && this
						.getPret5().equals(castOther.getPret5())))
				&& (this.getVersion() == castOther.getVersion())
				&& (this.getAnulat() == castOther.getAnulat())
				&& ((this.getValabilitate() == castOther.getValabilitate()) || (this
						.getValabilitate() != null
						&& castOther.getValabilitate() != null && this
						.getValabilitate().equals(castOther.getValabilitate())))
				&& ((this.getBucDisplay() == castOther.getBucDisplay()) || (this
						.getBucDisplay() != null
						&& castOther.getBucDisplay() != null && this
						.getBucDisplay().equals(castOther.getBucDisplay())))
				&& ((this.getBucBax() == castOther.getBucBax()) || (this
						.getBucBax() != null && castOther.getBucBax() != null && this
						.getBucBax().equals(castOther.getBucBax())))
				&& ((this.getBaxPal() == castOther.getBaxPal()) || (this
						.getBaxPal() != null && castOther.getBaxPal() != null && this
						.getBaxPal().equals(castOther.getBaxPal())))
				&& ((this.getSymbol() == castOther.getSymbol()) || (this
						.getSymbol() != null && castOther.getSymbol() != null && this
						.getSymbol().equals(castOther.getSymbol())))
				&& ((this.getGramaj() == castOther.getGramaj()) || (this
						.getGramaj() != null && castOther.getGramaj() != null && this
						.getGramaj().equals(castOther.getGramaj())))
				&& ((this.getCategorieId() == castOther.getCategorieId()) || (this
						.getCategorieId() != null
						&& castOther.getCategorieId() != null && this
						.getCategorieId().equals(castOther.getCategorieId())))
				&& (this.getCustomVersion() == castOther.getCustomVersion())
				&& (this.getBlocatLaDiscount() == castOther
						.getBlocatLaDiscount())
				&& ((this.getDiscount() == castOther.getDiscount()) || (this
						.getDiscount() != null
						&& castOther.getDiscount() != null && this
						.getDiscount().equals(castOther.getDiscount())))
				&& (this.getBlocareGratuitate() == castOther
						.getBlocareGratuitate());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductId();
		result = 37
				* result
				+ (getProductName() == null ? 0 : this.getProductName()
						.hashCode());
		result = 37 * result
				+ (getAromaId() == null ? 0 : this.getAromaId().hashCode());
		result = 37 * result
				+ (getGrupaId() == null ? 0 : this.getGrupaId().hashCode());
		result = 37 * result
				+ (getMarcaId() == null ? 0 : this.getMarcaId().hashCode());
		result = 37 * result
				+ (getTipId() == null ? 0 : this.getTipId().hashCode());
		result = 37 * result
				+ (getLitrajId() == null ? 0 : this.getLitrajId().hashCode());
		result = 37
				* result
				+ (getTipAmbalajId() == null ? 0 : this.getTipAmbalajId()
						.hashCode());
		result = 37
				* result
				+ (getGreutateId() == null ? 0 : this.getGreutateId()
						.hashCode());
		result = 37
				* result
				+ (getProducatorId() == null ? 0 : this.getProducatorId()
						.hashCode());
		result = 37 * result
				+ (getUmid() == null ? 0 : this.getUmid().hashCode());
		result = 37 * result
				+ (getClassId() == null ? 0 : this.getClassId().hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result
				+ (getPret2() == null ? 0 : this.getPret2().hashCode());
		result = 37 * result
				+ (getPret3() == null ? 0 : this.getPret3().hashCode());
		result = 37 * result
				+ (getPret4() == null ? 0 : this.getPret4().hashCode());
		result = 37 * result
				+ (getPret5() == null ? 0 : this.getPret5().hashCode());
		result = 37 * result + this.getVersion();
		result = 37 * result + this.getAnulat();
		result = 37
				* result
				+ (getValabilitate() == null ? 0 : this.getValabilitate()
						.hashCode());
		result = 37
				* result
				+ (getBucDisplay() == null ? 0 : this.getBucDisplay()
						.hashCode());
		result = 37 * result
				+ (getBucBax() == null ? 0 : this.getBucBax().hashCode());
		result = 37 * result
				+ (getBaxPal() == null ? 0 : this.getBaxPal().hashCode());
		result = 37 * result
				+ (getSymbol() == null ? 0 : this.getSymbol().hashCode());
		result = 37 * result
				+ (getGramaj() == null ? 0 : this.getGramaj().hashCode());
		result = 37
				* result
				+ (getCategorieId() == null ? 0 : this.getCategorieId()
						.hashCode());
		result = 37 * result + this.getCustomVersion();
		result = 37 * result + this.getBlocatLaDiscount();
		result = 37 * result
				+ (getDiscount() == null ? 0 : this.getDiscount().hashCode());
		result = 37 * result + this.getBlocareGratuitate();
		return result;
	}

}
