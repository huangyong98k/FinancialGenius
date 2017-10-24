package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;

import online.shixun.model.User;
import online.shixun.services.UserService;


@Component("userAction")
public class UserAction {

	private static final long serialVersionUID = 1L;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Autowired
	private UserService userService;

	private List<User> list;
	private User user;
	private String email;
	private String userPassword;
	
	public String addUser(){
		userService.addUser(user);
		findUser();
		return "add";
	}
	
	public String findUser(){
		list=userService.findUsers();
		return "list";
	}
	public String deleteById() {
		userService.deleteById(user);
		findUser();
		return "list";
	}
	public String to_edit(){
		user=userService.getUser(user);
		return "to_edit";
	}
	public String do_edit(){
		userService.edit(user);
		findUser();
		return "list";
	}
	@ResponseBody
	//注册时验证Emali是否已存在
	public String registerCheckByUserEmail() {
		System.out.println("userAction!registerCheckByUserEmail");
		// 获取数据
		int isExist = userService.findByEmai(user.getUserEmail());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		//Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			message="已注册";
			//map.put("message", "此邮箱已被注册");
		} else {
			message="未注册";
			//map.put("message", "可以使用此邮箱注册");
		}
		//result =map.toString();//给result赋值，传递给页面
		result=message;
		System.out.println(result);
		return ActionSupport.SUCCESS;
	}
	//注册时验证手机号是否已存在
	public String registerCheckByphoneNumber() {
		System.out.println("userAction!registerCheckByphoneNumber");
		int isExist = userService.findByPhone(user.getUserPhone());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		//Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			message="已注册";
			//map.put("message", "此手机号已被注册");
		} else {
			message="未注册";
			//map.put("message","可以使用此手机号注册");
		}
		//result =map.toString();//给result赋值，传递给页面
		result=message;
		System.out.println(result);
		return ActionSupport.SUCCESS;
	}
    //注册时验证身份证号码是否已存在
	public String registerCheckByIDCard() {
		System.out.println("userAction!registerCheckByIDCard");
		System.out.println(user.getUserCard());
		int isExist = userService.findByCard(user.getUserCard());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		//Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			//map.put("message","此身份证已被注册");
			message="已注册";
		} else {
			//map.put("message", "可以使用此身份证注册");
			message="未注册";
		}
		//result=map.toString();//给result赋值，传递给页面
		result=message;
		return ActionSupport.SUCCESS;
	}
    //注册方法
	public String register() {
		System.out.println("userAction!register");
		userService.addUser(user);
		return "register";
	}
	
	public String login(){
		System.out.println("userAction!login");
		System.out.println(email);
		System.out.println(userPassword);
		int count = userService.loginMager(
				email, userPassword);
		System.out.println(count);
		if (count == 1) {
			return "loginSuccess";
		}
		return "loginFaile";
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
