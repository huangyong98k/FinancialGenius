package online.shixun.model;

import java.util.Date;

public class RechargeRecordDemo {
	private Long rechargeRecordId;//充值记录ID
	private Date rechargeTime;//时间
	private double money;//金额
	private String rechargeType;//类型（充值/提现）
	private Long userId;//所属用户
	public Long getRechargeRecordId() {
		return rechargeRecordId;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public double getMoney() {
		return money;
	}
	public String getRechargeType() {
		return rechargeType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setRechargeRecordId(Long rechargeRecordId) {
		this.rechargeRecordId = rechargeRecordId;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
