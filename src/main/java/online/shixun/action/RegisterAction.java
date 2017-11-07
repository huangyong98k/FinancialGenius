/**   
* @Title: RegisterAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午9:51:05 
* @version V1.0   
*/
package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;

import online.shixun.model.User;
import online.shixun.services.impl.UserService;

/** 
* @ClassName: RegisterAction 
* @Description: 注册模块的Action 
* @author HPEU丶小咸鱼
* @date 2017年11月2日 上午9:51:05 
*  
*/
@Component("registerAction")
public class RegisterAction {
	
	@Autowired
	private UserService userService;
	private User user;
	private String result = null;
	
	
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

}
