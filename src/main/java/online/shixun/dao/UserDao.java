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
}
