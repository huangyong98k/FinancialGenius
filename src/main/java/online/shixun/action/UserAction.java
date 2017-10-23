package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.User;
import online.shixun.services.UserService;

@Component("userAction")
public class UserAction {
	@Autowired
	private UserService userService;
	private User user;
	
	public void registerCheck(){
		System.out.println("userAction!registerCheck");
		userService.addUser(user);
	}
	public String register(){
		System.out.println("userAction!register");
		userService.addUser(user);
		return "register";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
