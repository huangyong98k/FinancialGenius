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

import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.Investment;
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
    	return userDaoImpl.getAll();
    }
    public void edit(User user){
    	userDaoImpl.update(user);
    }

    public User getUser(User user) {
		return userDaoImpl.getUser(user);
	}
    public int findByEmai(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	System.out.println(users.toString());
    	if(users.size()>0){
    		return 1;
    	}
		return 0;
    	
    }
    public int findByPhone(String phone){
    	List<User> users = userDaoImpl.getByPhone(phone); 
    	System.out.println(users.toString());
    	if(users.size()>0){
    		return 1;
    	}
		return 0;
    }

    public int findByCard(String card){
    	List<User> users = userDaoImpl.getByCrad(card); 
    	System.out.println(users.toString());
    	if(users.size()>0){
    		return 1;
    	}
    	return 0;
    }
    
    public List<Investment> findInvestmentsByUserId(Long userId){
		return userDaoImpl.getInvestmentsByUserId(userId);
	}
    public void deleteById(User user) {
		userDaoImpl.delete(user);
	}
}
