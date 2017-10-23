package registerTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import online.shixun.model.User;
import online.shixun.services.UserService;

public class Register {
public static void main(String[] args) {
	User user = new User("userName", "userEmail", "userCard", "userPassword",
			1000d, "userPhone");
	System.out.println(user);
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
	UserService userService = (UserService)context.getBean("userService");
	userService.addUser(user);
}
}
