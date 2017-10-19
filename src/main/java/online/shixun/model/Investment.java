package online.shixun.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_investment")
public class Investment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long investmentId;
	private Date beginTime;
	private Date overTime;
	private double earning;
	private int investmentStatus;
	private int number;
	private double principal;
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
	
}
