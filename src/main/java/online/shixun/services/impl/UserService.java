/**   
* @Title: UserService.java 
* @Package online.shixun.services 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 上午9:25:44 
* @version V1.0   
*/
package online.shixun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.dao.AdminDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.AdminDaoImpl;
import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.Admin;
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
	@Autowired
	private AdminDaoImpl adminDaoImpl;
	
	public  int loginMager(String email,String userPassword){
		List<User> list =  (List<User>) userDaoImpl.getByEmail(email);
		if(list.size()>0){
			for (User user : list) {
				if(userPassword.equals(user.getUserPassword())){	
					HttpServletRequest request=ServletActionContext.getRequest();//获得session
			        HttpSession session=request.getSession();          
			        session.setAttribute("userId", (int)user.getUserId());
			        session.setAttribute("nickName", user.getNickName());

					return 1;
				}
			}
			return 2;

		}
		return 0;
	}

	
	public  int loginMagerAdmin(String adminName,String AdminPassword){
		List<Admin> list =  (List<Admin>) adminDaoImpl.getByName(adminName);
		if(list.size()>0){
			for (Admin admin : list) {
				if(AdminPassword.equals(admin.getAdminPassword())){
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
    	if(users.size()>0){
    		return 1;
    	}
		return 0;
    	
    }
  //通过Email查询用户userName
    public String findByEmaiTouserName(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	if(users.size()>0){
    		for (User user : users) {
				return  user.getUserName();
			}
    	}
		return "error";
    	
    }
    //通过Email查询用户userBalance
    public double findByEmailToBalance(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	if(users.size()>0){
    		for (User user : users) {
				return  user.getUserBanlance();
			}
    	}
		return 0;
    	
    }
    //通过Email查询用户ID
    public long findByEmaiToID(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	if(users.size()>0){
    		for (User user : users) {
				return  user.getUserId();
			}
    	}
		return 0;
    	
    }

    //通过Email查询用户电话
    public String findByEmailToPhone(String Email){
    	List<User> users = userDaoImpl.getByEmail(Email); 
    	if(users.size()>0){
    		for (User user : users) {
				return user.getUserPhone();
			}
    	}
    	return "0";
    }

    //通过userID查询用户密码
    public String findByUserIDToUser(Long userID){
    	User user = userDaoImpl.getById(userID);
    	return user.getUserPassword();
    	
    }
  //通过userID查询用户
    public User findByUserIDToUserMessage(Long userID){
    	User user = userDaoImpl.getById(userID);
    	return user;
    	
    }
    public int findByPhone(String phone){
    	List<User> users = userDaoImpl.getByPhone(phone); 
    	if(users.size()>0){
    		return 1;
    	}
		return 0;
    }
    /**
     * 修改密码
     * @param newPassword
     * @param userId
     * @return
     */
    public void modifyUserPassword(User user){
    	userDaoImpl.update(user);
    }

    public int findByCard(String card){
    	List<User> users = userDaoImpl.getByCrad(card); 
    	if(users.size()>0){
    		return 1;
    	}
    	return 0;
    }
    
    public List<User> findUserByUserEmail(String email){
    	System.out.println(userDaoImpl.getByEmail(email));
		return userDaoImpl.getByEmail(email);
    	
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

    //根据Id查询用户
    public User getUserById(Long id){
    	return userDaoImpl.getById(id);
    }

    //余额修改
    public void modifyUserBanlance(Long id,double spend){
    	User user=userDaoImpl.getById(id);
    	double balance = user.getUserBanlance();
    	user.setUserBanlance(balance-spend);
    	userDaoImpl.add(user);
    }

}
