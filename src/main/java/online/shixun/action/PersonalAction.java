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
	private String oldPassword;
	private String newPassword;
	
	//获取个人信息
	public String getUserInfo(){
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession();
        userId = (Long) session.getAttribute("userId");
		user = userService.getUserById(userId);
		return "userInfo";	
	}
	
	//通过老密码修改密码
	public String modifyUserPassword(){
		System.out.println(user.toString());
		System.out.println(oldPassword);
		System.out.println(newPassword);
		
		return "modifyUserPassword";
		
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

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
