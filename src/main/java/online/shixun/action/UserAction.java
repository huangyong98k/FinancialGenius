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
		List<User> list=userService.findUsers();
		System.out.println(list.toString());
		System.out.println("gshdgshgidg");
		return "findUser";
	}
}
