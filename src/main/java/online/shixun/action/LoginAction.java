/**   
* @Title: LoginAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午9:50:25 
* @version V1.0   
*/
package online.shixun.action;


import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.services.impl.UserService;


/** 
* @ClassName: LoginAction 
* @Description: 登录模块的Action 
* @author HPEU丶小咸鱼
* @date 2017年11月2日 上午9:50:25 
*  
*/
@Component("loginAction")
public class LoginAction{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	
	
	private String email;
	private String userPassword;
	private static Map<String, Object> session;
	
	// 静态模块初始化session 添加 对象loginInfo 属性值为"请登录"
		static {
			session = new HashMap<String, Object>();
			session.put("loginInfo", "请登录");
		}
	
		/**
		* @Description:  普通用户登录验证！
		 */
		public String login() {
			HttpSession session = ServletActionContext.getRequest().getSession();
			int count = userService.loginMager(email, userPassword);
			if(email.equals("")||userPassword.equals("")){
				
				session.setAttribute("email", 1);
				return "loginFaile";
			}else {
				if (count == 1) {
					session.setAttribute("email", 1);
					return "loginSuccess";
				}else {
					session.setAttribute("email", 2);
					return "loginFaile";
				}
			}
		}
		
		/**
		 * 退出，清除Session
		 */
		public String quit(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("userId");
	        session.removeAttribute("nickName");
	        session.removeAttribute("userName");
	        session.removeAttribute("userEmail");
	        session.removeAttribute("userBanlance");
	        session.removeAttribute("headPortrait");

	        session.removeAttribute("userPhone");
	        session.removeAttribute("payPassword");
			session.invalidate();
			return "quit";
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the userPassword
		 */
		public String getUserPassword() {
			return userPassword;
		}
		/**
		 * @param userPassword the userPassword to set
		 */
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

}
