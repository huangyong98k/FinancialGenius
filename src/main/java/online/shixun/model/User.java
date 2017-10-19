package online.shixun.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	@Column(unique = true)
	private String userCard;
	private String userPassword;
	private double userBanlance;
	@Column(unique = true)
	private String userPhone;
	private String userStatus;
	@OneToMany
	@JoinColumn(name = "userId")
	private List<Investment> investments;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getUserBanlance() {
		return userBanlance;
	}
	public void setUserBanlance(double userBanlance) {
		this.userBanlance = userBanlance;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public List<Investment> getInvestments() {
		return investments;
	}
	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
	
	public User(String userName, String userEmail, String userCard, String userPassword, double userBanlance,
			String userPhone, String userStatus) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCard = userCard;
		this.userPassword = userPassword;
		this.userBanlance = userBanlance;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
	}
	public User(long userId, String userName, String userEmail, String userCard, String userPassword,
			double userBanlance, String userPhone, String userStatus, List<Investment> investments) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCard = userCard;
		this.userPassword = userPassword;
		this.userBanlance = userBanlance;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
		this.investments = investments;
	}
	public User() {
		super();
	}
	
}
