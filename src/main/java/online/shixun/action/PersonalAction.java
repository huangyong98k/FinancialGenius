/**   
* @Title: PersonalAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午9:52:53 
* @version V1.0   
*/
package online.shixun.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;

import online.shixun.model.User;
import online.shixun.services.impl.UserService;

/** 
* @ClassName: PersonalAction 
* @Description: 个人信息的Action 
* @author HPEU丶小咸鱼
* @date 2017年11月2日 上午9:52:53 
*  
*/
@Component("personalAction")
public class PersonalAction {
	@SuppressWarnings("unused")
	private static long serialVersionUID = 1L;
	@Autowired
	private UserService userService; 
	
	private Long userId;
	private User user;
	private String result = null;
	private String newUserPassword;

	public String getNewUserPassword() {
		return newUserPassword;
	}

	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	
	//获取个人信息
	public String getUserInfo(){
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession();
        userId = (Long) session.getAttribute("userId");
		user = userService.getUserById(userId);
		return "userInfo";	
	}
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
			setResult(message);
			return ActionSupport.SUCCESS;
		}
	
 
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
