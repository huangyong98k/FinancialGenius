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
import online.shixun.services.impl.UserService;

@Component("userAction")
public class UserAction {
	@SuppressWarnings("unused")
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


	// 静态模块初始化session 添加 对象loginInfo 属性值为"请登录"
	static {
		session = new HashMap<String, Object>();
		session.put("loginInfo", "请登录");
	}
   //添加用户，传递整个user对象到数据库中
	public String addUser() {
		userService.addUser(user);
		findUser();
		return "add";
	}


	

	//ajax传值，通过电话号码来查询用户是否存在，返回0，或者1，若为0，则不存在，为1存在
	public String findUserByPhone(){
		//取得返回值
		result=userService.findByPhone(user.getUserPhone())+"";
		return ActionSupport.SUCCESS;
	}
	//同上，用email来判断用户是否存在，验证注册用户是否合法
	public String findUserByEmail(){
		result=userService.findByEmai(user.getUserEmail())+"";
		return ActionSupport.SUCCESS;
	}
	//用身份证来判断用户存在
	public String findUserByCard(){
		//取值
		result=userService.findByCard(user.getUserCard())+"";
		//返回data
		return ActionSupport.SUCCESS;
	}
	/*
	 * 查询所有用户，显示在页面上
	 */

	public String findUser() {
		list = userService.findUsers();
		return "list";
	}
   /*
    * 通过传过来的用户id来删除整个用户
    */
	public String deleteById() {
		userService.deleteById(user);
		findUser();
		return "list";
	}
    /*
     * 获取到选中元素的id，并通过id来获取到选中的元素的属性
     */
	public String to_edit() {
		user = userService.getUser(user);
		return "to_edit";
	}
/*
 * 对对象内的属性进行修改操作，调用update方法
 */
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
			System.out.println("list"+list);
		}
		return "users";
	}
	//查询已购产品
	public String getInvestmentById() {
		investments = userService.findInvestmentsByUserId();
		return "getSuccess";
	}

	//查询用户银行卡信息
	public String findBankCard(){
		userService.findBankCardsByUserId();
		return "bankCard";
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
	
	public String login() {
		int count = userService.loginMager(email, userPassword);
		System.out.println(count);
		if (count == 1) {
			session.put("loginInfo", email);
			return "loginSuccess";
		}
		session.put("loginError", "用户密码不正确！");
		    return "loginFaile";

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

	//查询当前登录用户的余额
	@ResponseBody
	public String queryUserBalance() {
		session.get("loginInfo");
		result = (String) session.get("loginInfo");
		if (result.equals("请登录")) {
			// 不做改变
		} else {
			result = String.valueOf(userService.findByEmailToBalance(result));
		}
		return ActionSupport.SUCCESS;

	}
	
	//查询当前登录用户的电话
	@ResponseBody
	public String queryUserPhone(){
		session.get("loginInfo");
		result = (String) session.get("loginInfo");
		if (result.equals("请登录")) {
			// 不做改变
		} else {
			result = String.valueOf(userService.findByEmailToPhone(result));
		}
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
		this.userId =  userId;
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
