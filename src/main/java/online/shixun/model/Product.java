package online.shixun.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;//产品表ID
	private String productName;//产品名称
	private double productCapital;//产品总额
	private double productRate;//产品利率
	private double productMoney;//产品每份金额
	private String productMechanism;//产品发行机构
	private String productType;//产品类型
	private int productStatus;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "productId")
	private List<Investment> investments;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCapital() {
		return productCapital;
	}
	public void setProductCapital(double productCapital) {
		this.productCapital = productCapital;
	}
	public double getProductRate() {
		return productRate;
	}
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
	public double getProductMoney() {
		return productMoney;
	}
	public void setProductMoney(double productMoney) {
		this.productMoney = productMoney;
	}
	public String getProductMechanism() {
		return productMechanism;
	}
	public void setProductMechanism(String productMechanism) {
		this.productMechanism = productMechanism;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	public List<Investment> getInvestments() {
		return investments;
	}
	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Product(long productId, String productName, double productCapital, double productRate, double productMoney,
			String productMechanism, int productStatus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCapital = productCapital;
		this.productRate = productRate;
		this.productMoney = productMoney;
		this.productMechanism = productMechanism;
		this.productStatus = productStatus;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCapital=" + productCapital
				+ ", productRate=" + productRate + ", productMoney=" + productMoney + ", productMechanism="
				+ productMechanism + ", productStatus=" + productStatus + "]";
	}
	
}
