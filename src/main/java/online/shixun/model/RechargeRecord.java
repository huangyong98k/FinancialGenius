/**   
* @Title: RechargeRecord.java 
* @Package online.shixun.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 上午8:36:07 
* @version V1.0   
*/
package online.shixun.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
* @ClassName: RechargeRecord 
* @Description: 实体类：充值记录 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 上午8:36:07 
*  
*/
@Entity
@Table(name = "tb_rechargeRecord")
public class RechargeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rechargeRecordId;//充值记录ID
	@Temporal(TemporalType.DATE)
	private Date rechargeTime;//时间
	private double money;//金额
	private String rechargeType;//类型（充值/提现）
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;//所属用户
	/**
	 * @return the rechargeRecordId
	 */
	public Long getRechargeRecordId() {
		return rechargeRecordId;
	}
	/**
	 * @param rechargeRecordId the rechargeRecordId to set
	 */
	public void setRechargeRecordId(Long rechargeRecordId) {
		this.rechargeRecordId = rechargeRecordId;
	}
	/**
	 * @return the rechargeTime
	 */
	public Date getRechargeTime() {
		return rechargeTime;
	}
	/**
	 * @param rechargeTime the rechargeTime to set
	 */
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
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
	/**
	 * @return the rechargeType
	 */
	public String getRechargeType() {
		return rechargeType;
	}
	/**
	 * @param rechargeType the rechargeType to set
	 */
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	
	public RechargeRecord(Long rechargeRecordId, Date rechargeTime, double money, String rechargeType) {
		super();
		this.rechargeRecordId = rechargeRecordId;
		this.rechargeTime = rechargeTime;
		this.money = money;
		this.rechargeType = rechargeType;
	}
	
	public RechargeRecord(Date rechargeTime, double money, String rechargeType, User user) {
		super();
		this.rechargeTime = rechargeTime;
		this.money = money;
		this.rechargeType = rechargeType;
		this.user = user;
	}

	public RechargeRecord(Long rechargeRecordId) {
		super();
		this.rechargeRecordId = rechargeRecordId;
	}
	
	public RechargeRecord() {
		super();
	}

}
