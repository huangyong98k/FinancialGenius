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
}
