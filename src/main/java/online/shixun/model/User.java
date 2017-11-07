package online.shixun.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;// 用户ID
	private String userName;// 用户真实姓名
	private String nickName;// 用户昵称
	@Column(unique = true)
	private String userEmail;// 用户Email（唯一）
	@Column(unique = true)
	private String userCard;// 用户身份证号（唯一）
	private String userPassword;// 用户密码
	private String payPassword;// 用户支付密码
	private String householdRegister;// 户籍
	private double userBanlance;// 用户余额
	private String headPortrait;// 用户头像地址
	@Column(unique = true)
	private String userPhone;// 用户手机号（唯一）
	private String userStatus;// 用户状态，默认值为 正常 正常/冻结
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<EarningsRecord> earningsRecord;// 用户充值记录
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<RechargeRecord> rechargeRecord;// 用户受益记录
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<Investment> investments;// 用户购买的投资
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<BankCard> bankCards;// 用户银行卡信息
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private List<RechargeRecord> rechargeRecords;//充值/提现记录
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userCard
	 */
	public String getUserCard() {
		return userCard;
	}

	/**
	 * @param userCard
	 *            the userCard to set
	 */
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the payPassword
	 */
	public String getPayPassword() {
		return payPassword;
	}

	/**
	 * @param payPassword
	 *            the payPassword to set
	 */
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	/**
	 * @return the householdRegister
	 */
	public String getHouseholdRegister() {
		return householdRegister;
	}

	/**
	 * @param householdRegister
	 *            the householdRegister to set
	 */
	public void setHouseholdRegister(String householdRegister) {
		this.householdRegister = householdRegister;
	}

	/**
	 * @return the userBanlance
	 */
	public double getUserBanlance() {
		return userBanlance;
	}

	/**
	 * @param userBanlance
	 *            the userBanlance to set
	 */
	public void setUserBanlance(double userBanlance) {
		this.userBanlance = userBanlance;
	}

	/**
	 * @return the headPortrait
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}

	/**
	 * @param headPortrait
	 *            the headPortrait to set
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone
	 *            the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the earningsRecord
	 */
	public List<EarningsRecord> getEarningsRecord() {
		return earningsRecord;
	}

	/**
	 * @param earningsRecord
	 *            the earningsRecord to set
	 */
	public void setEarningsRecord(List<EarningsRecord> earningsRecord) {
		this.earningsRecord = earningsRecord;
	}

	/**
	 * @return the rechargeRecord
	 */
	public List<RechargeRecord> getRechargeRecord() {
		return rechargeRecord;
	}

	/**
	 * @param rechargeRecord
	 *            the rechargeRecord to set
	 */
	public void setRechargeRecord(List<RechargeRecord> rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	/**
	 * @return the investments
	 */
	public List<Investment> getInvestments() {
		return investments;
	}

	/**
	 * @param investments
	 *            the investments to set
	 */
	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public User(long userId, String userName, String nickName, String userEmail, String userCard, String userPassword,
			String payPassword, String householdRegister, double userBanlance, String headPortrait, String userPhone,
			String userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.userEmail = userEmail;
		this.userCard = userCard;
		this.userPassword = userPassword;
		this.payPassword = payPassword;
		this.householdRegister = householdRegister;
		this.userBanlance = userBanlance;
		this.headPortrait = headPortrait;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
	}

	public User() {
		super();
	}

	public User(long userId) {
		super();
		this.userId = userId;
	}

	public List<BankCard> getBankCards() {
		return bankCards;
	}

	public void setBankCards(List<BankCard> bankCards) {
		this.bankCards = bankCards;
	}
	
	public List<RechargeRecord> getRechargeRecords() {
		return rechargeRecords;
	}

	public void setRechargeRecords(List<RechargeRecord> rechargeRecords) {
		this.rechargeRecords = rechargeRecords;
	}

	public User(String userName, String nickName, String userEmail, String userCard, String userPassword,
			String payPassword, String householdRegister, double userBanlance, String headPortrait, String userPhone,
			String userStatus) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.userEmail = userEmail;
		this.userCard = userCard;
		this.userPassword = userPassword;
		this.payPassword = payPassword;
		this.householdRegister = householdRegister;
		this.userBanlance = userBanlance;
		this.headPortrait = headPortrait;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + "]";
	}

	public String toStringAndEarningsRecord() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + ","
				+ ", earningsRecord=" + earningsRecord + "]";
	}

	public String toStringAndRechargeRecord() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + ","
				+ ", rechargeRecord=" + rechargeRecord + "]";
	}

	public String toStringAndInvestments() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + ","
				+ ", investments=" + investments + "]";
	}

	public String toStringAndBankCards() {
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + ","
				+ ", bankCards=" + bankCards + "]";
	}
	
	public String toStringAndRechargeRecords(){
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", userEmail="
				+ userEmail + ", userCard=" + userCard + ", userPassword=" + userPassword + ", payPassword="
				+ payPassword + ", householdRegister=" + householdRegister + ", userBanlance=" + userBanlance
				+ ", headPortrait=" + headPortrait + ", userPhone=" + userPhone + ", userStatus=" + userStatus + ","
				+ ", rechargeRecords=" + rechargeRecords + "]";
	}
	
}
