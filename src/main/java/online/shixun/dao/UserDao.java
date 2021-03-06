/**   
* @Title: UserDao.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午9:02:11 
* @version V1.0   
*/
package online.shixun.dao;

import java.util.List;

import online.shixun.common.UtilDao;
import online.shixun.model.BankCard;
import online.shixun.model.Investment;
import online.shixun.model.User;

/** 
* @ClassName: UserDao 
* @Description: 用户Dao接口
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午9:02:11 
*  
*/
public interface UserDao extends UtilDao<User>{
	
	List<User> getByName(String name);//根据姓名获取用户信息
	List<User> getByCrad(String crad);//根据身份证号查询用户
	List<User> getByEmail(String email);//根据邮箱查询
	List<User> getByPhone(String phone);//根据手机号查询
	List<Investment> getInvestmentsByUserId(Long userId);//根据用户id获取用户投资信息
	List<BankCard> getBankCardsByUserId(Long userId);//根据用户id获取用户银行卡信息
	User getUser(User user);
}
