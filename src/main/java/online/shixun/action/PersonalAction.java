/**   
* @Title: PersonalAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午9:52:53 
* @version V1.0   
*/
package online.shixun.action;

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
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService; 
	
	private int userId;
	private User user;
	
	public String getUserInfo(){
		user = userService.getUserById((long)userId);
		return "userInfo";	
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
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

}
