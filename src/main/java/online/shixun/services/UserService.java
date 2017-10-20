/**   
* @Title: UserService.java 
* @Package online.shixun.services 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 上午9:25:44 
* @version V1.0   
*/
package online.shixun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.UserDaoImpl;
import online.shixun.model.User;

/** 
* @ClassName: UserService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月19日 上午9:25:44 
*  
*/
@Service(value="userService")
public class UserService {
	@Autowired
    private UserDaoImpl userDaoImpl;
    public void addUser(User user){
    	userDaoImpl.add(user);
    }
    public List<User> findUsers(){
    	return userDaoImpl.findUsers();
    }
}
