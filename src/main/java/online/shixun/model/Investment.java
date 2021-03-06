﻿package online.shixun.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_investment")
public class Investment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long investmentId;//投资表ID
	
	private Date beginTime;//投资起始时间
	
	private Date overTime;//投资结束时间
	private double earning;//预计收益金额
	private int investmentStatus;//投资状态(进行中/已完成/失效)
	private int number;//投资数量（购买产品份数）
	private double principal;//投资金额
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;//所属用户
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="productId")
	private Product product;//投资产品
	public long getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getOverTime() {
		return overTime;
	}
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	public double getEarning() {
		return earning;
	}
	public void setEarning(double earning) {
		this.earning = earning;
	}
	public int getInvestmentStatus() {
		return investmentStatus;
	}
	public void setInvestmentStatus(int investmentStatus) {
		this.investmentStatus = investmentStatus;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public Investment(long investmentId, Date beginTime, Date overTime, double earning, int investmentStatus,
			int number, double principal) {
		super();
		this.investmentId = investmentId;
		this.beginTime = beginTime;
		this.overTime = overTime;
		this.earning = earning;
		this.investmentStatus = investmentStatus;
		this.number = number;
		this.principal = principal;
	}
	public Investment() {
		super();
	}

	/* (非 Javadoc) 
	* <p>Title: toString</p> 
	* <p>Description: </p> 
	* @return 
	* @see java.lang.Object#toString() 
	*/
	@Override
	public String toString() {
		return "Investment [investmentId=" + investmentId + ", beginTime=" + beginTime + ", overTime=" + overTime
				+ ", earning=" + earning + ", investmentStatus=" + investmentStatus + ", number=" + number
				+ ", principal=" + principal + "]";
	}
	public User getUser() {
		return user;
	}
	public Product getProduct() {
		return product;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
