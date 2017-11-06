/**   
* @Title: EarningsRecord.java 
* @Package online.shixun.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 上午8:36:55 
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
* @ClassName: EarningsRecord 
* @Description: 实体类：收益记录 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 上午8:36:55 
*  
*/
@Entity
@Table(name = "tb_earningsRecord")
public class EarningsRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long earningsRecordId;//收益记录ID
	@Temporal(TemporalType.DATE)
	private Date earningsTime;//时间
	private double earningsMoney;//金额
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="investmentId")
	private Investment investment;//所属投资表
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;//所属用户
	/**
	 * @return the earningsRecordId
	 */
	public Long getEarningsRecordId() {
		return earningsRecordId;
	}
	/**
	 * @param earningsRecordId the earningsRecordId to set
	 */
	public void setEarningsRecordId(Long earningsRecordId) {
		this.earningsRecordId = earningsRecordId;
	}
	/**
	 * @return the earningsTime
	 */
	public Date getEarningsTime() {
		return earningsTime;
	}
	/**
	 * @param earningsTime the earningsTime to set
	 */
	public void setEarningsTime(Date earningsTime) {
		this.earningsTime = earningsTime;
	}
	/**
	 * @return the earningsMoney
	 */
	public double getEarningsMoney() {
		return earningsMoney;
	}
	/**
	 * @param earningsMoney the earningsMoney to set
	 */
	public void setEarningsMoney(double earningsMoney) {
		this.earningsMoney = earningsMoney;
	}
	/**
	 * @return the investment
	 */
	public Investment getInvestment() {
		return investment;
	}
	/**
	 * @param investment the investment to set
	 */
	public void setInvestment(Investment investment) {
		this.investment = investment;
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
	
	public EarningsRecord(Long earningsRecordId, Date earningsTime, double earningsMoney) {
		super();
		this.earningsRecordId = earningsRecordId;
		this.earningsTime = earningsTime;
		this.earningsMoney = earningsMoney;
	}

	public EarningsRecord(Long earningsRecordId) {
		super();
		this.earningsRecordId = earningsRecordId;
	}

	public EarningsRecord(Date earningsTime, double earningsMoney) {
		super();
		this.earningsTime = earningsTime;
		this.earningsMoney = earningsMoney;
	}

	public EarningsRecord() {
		super();
	}

}
