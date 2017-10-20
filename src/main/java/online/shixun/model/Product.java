package online.shixun.model;

import java.util.List;

import javax.persistence.Entity;
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
	private long productId;
	private String productName;
	private double productCapital;
	private double productRate;
	private String productMoney;
	private String productMechanism;
	private int productStatus;
	@OneToMany
	@JoinColumn(name = "productId")
	private List<Investment> investments;
	
	
	
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productCapital
	 */
	public double getProductCapital() {
		return productCapital;
	}
	/**
	 * @param productCapital the productCapital to set
	 */
	public void setProductCapital(double productCapital) {
		this.productCapital = productCapital;
	}
	/**
	 * @return the productRate
	 */
	public double getProductRate() {
		return productRate;
	}
	/**
	 * @param productRate the productRate to set
	 */
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
	/**
	 * @return the productMoney
	 */
	public String getProductMoney() {
		return productMoney;
	}
	/**
	 * @param productMoney the productMoney to set
	 */
	public void setProductMoney(String productMoney) {
		this.productMoney = productMoney;
	}
	/**
	 * @return the productMechanism
	 */
	public String getProductMechanism() {
		return productMechanism;
	}
	/**
	 * @param productMechanism the productMechanism to set
	 */
	public void setProductMechanism(String productMechanism) {
		this.productMechanism = productMechanism;
	}
	/**
	 * @return the productStatus
	 */
	public int getProductStatus() {
		return productStatus;
	}
	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	/**
	 * @return the investments
	 */
	public List<Investment> getInvestments() {
		return investments;
	}
	/**
	 * @param investments the investments to set
	 */
	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
}
