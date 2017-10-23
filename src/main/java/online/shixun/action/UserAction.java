package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.User;
import online.shixun.services.UserService;

@Component("userAction")
public class UserAction {
	@Autowired
	private UserService userService;

	private List<User> list;
	private User user;
	
	public String findUser(){
		list=userService.findUsers();
		System.out.println("wocao"+list.toString());
		return "list";
	}
	public String to_edit(){
		user=userService.getUser(user);
		return "to_edit";
	}
	public String do_edit(){
		userService.edit(user);;
		list = userService.findUsers();
		return "do_edit";
	}
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

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
}
