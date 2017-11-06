/**   
* @Title: BankCard.java 
* @Package online.shixun.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 上午8:35:15 
* @version V1.0   
*/
package online.shixun.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
* @ClassName: BankCard 
* @Description: 实体类：银行卡 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 上午8:35:15 
*  
*/
@Entity
@Table(name = "tb_bankCard")
public class BankCard {
	@Id
	private String bankCardId;//银行卡号
	private double bankBalance;//余额
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;//所属用户
	/**
	 * @return the bankCardId
	 */
	public String getBankCardId() {
		return bankCardId;
	}
	/**
	 * @param bankCardId the bankCardId to set
	 */
	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
	/**
	 * @return the bankBalance
	 */
	public double getBankBalance() {
		return bankBalance;
	}
	/**
	 * @param bankBalance the bankBalance to set
	 */
	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public BankCard(String bankCardId, double bankBalance, User user) {
		super();
		this.bankCardId = bankCardId;
		this.bankBalance = bankBalance;
		this.user = user;
	}

	public BankCard(double bankBalance, User user) {
		super();
		this.bankBalance = bankBalance;
		this.user = user;
	}
	public BankCard() {
		super();
	}

}
