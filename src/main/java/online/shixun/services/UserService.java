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

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
	
	public  int loginMager(String email,String userPassword){
		List<User> list =  (List<User>) userDaoImpl.getByEmail(email);
		if(list.size()>0){
			for (User user : list) {
				if(userPassword.equals(user.getUserPassword())){
					return 1;
				}
			}
			return 2;

		}
		return 0;
	}

    public void addUser(User user){
    	userDaoImpl.add(user);
    }
    public List<User> findUsers(){
    	return userDaoImpl.getAllUsePage();
    }
    public void edit(User user){
    	userDaoImpl.update(user);
    }

    public User getUser(User user) {
		return userDaoImpl.getUser(user);
	}
    
    public List<User> findByName(User user){
    	return userDaoImpl.getByName(user.getUserName());
    }
    
    public int findByEmai(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	System.out.println(users.toString());
    	if(users.size()>0){
    		return 1;
    	}
		return 0;
    	
    }
    //通过Email查询用户ID
    public long findByEmaiToID(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	System.out.println(users.toString());
    	if(users.size()>0){
    		for (User user : users) {
				return  user.getUserId();
			}
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
    //服务类用户前后端分页
    public List<User> nextPage() {
    	return userDaoImpl.nextPage();	
	}
    public List<User> prevPage() {
    	return userDaoImpl.prevPage();	
	}

}
