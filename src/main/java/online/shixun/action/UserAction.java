package online.shixun.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import online.shixun.model.Investment;
import online.shixun.model.User;
import online.shixun.services.UserService;

@Component("userAction")
public class UserAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private int intResult;

	private List<User> list;
	private List<Investment> investments;
	private User user;
	private String email;
	private String userPassword;
	private String adminName;
	private String AdminPassword;
	private static Map<String, Object> session;
	private Map<String, Object> map = new HashMap<String, Object>();
	private String result = null;
	private long userId;
	// 静态模块初始化session 添加 对象loginInfo 属性值为"请登录"
	static {
		session = new HashMap<String, Object>();
		session.put("loginInfo", "请登录");
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	private List<User> users;

	private String newUserPassword;

	public String getNewUserPassword() {
		return newUserPassword;
	}

	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}

	// 静态模块初始化session 添加 对象loginInfo 属性值为"请登录"
	static {
		session = new HashMap<String, Object>();
		session.put("loginInfo", "请登录");
	}

	public String addUser() {
		userService.addUser(user);
		findUser();
		return "add";
	}

	public String findUserByPhone() {
		System.out.println(user.getUserPhone());
		result = userService.findByPhone(user.getUserPhone()) + "";
		System.out.println(intResult);
		return ActionSupport.SUCCESS;
	}

	public String findUserByEmail() {
		System.out.println(user.getUserEmail());
		result = userService.findByEmai(user.getUserEmail()) + "";
		System.out.println(intResult);
		return ActionSupport.SUCCESS;
	}

	public String findUserByCard() {
		System.out.println(user.getUserCard());
		result = userService.findByCard(user.getUserCard()) + "";
		System.out.println(intResult);
		return ActionSupport.SUCCESS;
	}

	public String findUser() {
		list = userService.findUsers();
		return "list";
	}

	public String deleteById() {
		userService.deleteById(user);
		findUser();
		return "list";
	}

	public String to_edit() {
		user = userService.getUser(user);
		return "to_edit";
	}

	public String do_edit() {
		userService.edit(user);
		findUser();
		return "list";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInvestmentById() {
		System.out.println("~~~~~~~~~~~userId为" + userId);
		investments = userService.findInvestmentsByUserId(userId);
		return "getSuccess";
	}

	@ResponseBody
	// 注册时验证Emali是否已存在
	public String registerCheckByUserEmail() {
		System.out.println("userAction!registerCheckByUserEmail");
		// 获取数据
		int isExist = userService.findByEmai(user.getUserEmail());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		// Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			message = "已注册";
			// map.put("message", "此邮箱已被注册");
		} else {
			message = "未注册";
			// map.put("message", "可以使用此邮箱注册");
		}
		result = message;
		return ActionSupport.SUCCESS;
	}
	
	@ResponseBody
	// 登陆时验证Emali是否正确
	public String loginCheckByUserEmail() {
		System.out.println("userAction!loginCheckByUserEmail");
		// 获取数据
		int isExists = userService.findByEmai(user.getUserEmail());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		// Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExists > 0) {
			message = "正确！";
			// map.put("message", "此邮箱已被注册");
		} else {
			message = "账户不存在";
			// map.put("message", "可以使用此邮箱注册");
		}
		// result =map.toString();//给result赋值，传递给页面
		result = message;
		System.out.println(result);
		return ActionSupport.SUCCESS;
	}
	
	

	// 注册时验证手机号是否已存在
	@ResponseBody
	public String registerCheckByphoneNumber() {
		System.out.println("userAction!registerCheckByphoneNumber");
		int isExist = userService.findByPhone(user.getUserPhone());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		// Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			message = "已注册";
			// map.put("message", "此手机号已被注册");
		} else {
			message = "未注册";
			// map.put("message","可以使用此手机号注册");
		}
		// result =map.toString();//给result赋值，传递给页面
		result = message;
		return ActionSupport.SUCCESS;
	}

	// 注册时验证身份证号码是否已存在
	@ResponseBody
	public String registerCheckByIDCard() {
		System.out.println("userAction!registerCheckByIDCard");
		System.out.println(user.getUserCard());
		int isExist = userService.findByCard(user.getUserCard());
		// 将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
		// Map<String, Object> map = new HashMap<String, Object>();
		String message;
		if (isExist > 0) {
			// map.put("message","此身份证已被注册");
			message = "已注册";
		} else {
			// map.put("message", "可以使用此身份证注册");
			message = "未注册";
		}
		// result=map.toString();//给result赋值，传递给页面
		result = message;
		return ActionSupport.SUCCESS;
	}

	// 注册方法
	public String register() {
		System.out.println("userAction!register");
		userService.addUser(user);
		return "register";
	}

	// 通过查看session值判断是否登录 未登录返回 "请登录" 已登录返回 userName
	@ResponseBody
	public String queryUserName() {
		System.out.println("userAction!queryUserName");
		session.get("loginInfo");
		result = (String) session.get("loginInfo");
		if (result.equals("请登录")) {
			// 不做改变
		} else {
			result = userService.findByEmaiTouserName(result);
		}
		return ActionSupport.SUCCESS;

	}

	// 通过查看session值判断是否登录 未登录返回 "请登录" 已登录返回 userID 但userID为String类型
	// 需要调用请在前端转为long类型
	@ResponseBody
	public String queryUserID() {
		System.out.println("userAction!queryUserID");
		session.get("loginInfo");
		result = (String) session.get("loginInfo");
		if (result.equals("请登录")) {
			// 不做改变
		} else {
			long userID = userService.findByEmaiToID(result);
			result = String.valueOf(userID);
		}
		return ActionSupport.SUCCESS;

	}

	// 查询当前登录用户所有信息
	@ResponseBody
	public String queryUserMessage() {
		System.out.println("userAction!queryUserMessage");
		session.get("loginInfo");
		String message;
		message = (String) session.get("loginInfo");
		if (message.equals("请登录")) {
			// 不做改变
		} else {
			list = userService.findUserByUserEmail(message);
		}
		return "users";
	}

	// 修改个人信息
	@ResponseBody
	public String modifyUserMessage() {
		System.out.println(user);
		userService.edit(user);
		String message;
		message = "个人信息已修改成功";
		result = message;
		return ActionSupport.SUCCESS;
	}

	public String findByName() {
		list = userService.findByName(user);
		return "userByName";
	}


    //普通用户登录
	// 个人信息界面修改密码
	@ResponseBody
	public String changePassword() {
		String message;
		String dataBasePassword = userService.findByUserIDToUser(user.getUserId());

		if (dataBasePassword.equals(newUserPassword)) {
			message = "新密码不可以和原密码相同";
		} else if (dataBasePassword.equals(user.getUserPassword())) {
			user = userService.findByUserIDToUserMessage(user.getUserId());
			user.setUserPassword(newUserPassword);
			userService.modifyUserPassword(user);
			message = "密码已修改成功";
		} else {

			message = "原密码错误";
		}
		result = message;
		return ActionSupport.SUCCESS;
	}

	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session2=actionContext.getSession();
		long userID = userService.loginMager(email, userPassword);
		user = userService.getUserById(userID);
		if (userId == -2l || userId==-1l) {
			session.put("loginError", "用户密码不正确！");
			return "loginFaile";
		}
		session2.put("userId", userID);
		session.put("loginInfo",email);
		return "loginSuccess";
	}

	//管理员登陆
	public String adminLogin(){
		System.out.println("userAction!adminLogin");
		System.out.println(adminName);
		System.out.println(AdminPassword);
		int count = userService.loginMagerAdmin(adminName, AdminPassword);
		System.out.println(count);
		if (count == 1) {
			//session.put("loginInfo",email);
			return "adminLoginSuccess";
		}
		    //session.put("loginError", "用户密码不正确！");
		    return "loginFaile";
	}
	
	//用户前后端分页

	public String nextPage() {
		list = userService.nextPage();
		return "list";
	}

	public String prevPage() {
		list = userService.prevPage();
		return "list";
	}

	@ResponseBody
	// 退出系统 清除session
	public String quitSystem() {
		session.put("loginInfo", "请登录");
		result = "退出成功";
		return ActionSupport.SUCCESS;

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

	public static Map<String, Object> getSession() {
		return session;
	}

	public static void setSession(Map<String, Object> session) {
		UserAction.session = session;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getIntResult() {
		return intResult;
	}

	public void setIntResult(int intResult) {
		this.intResult = intResult;
	}


	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	

}
