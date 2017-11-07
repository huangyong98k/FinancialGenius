package online.shixun.services.impl;

import org.springframework.stereotype.Service;

import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.User;

@Service(value = "portraitService")
public class PortraitService{
	private UserDaoImpl userDaoImpl;
	private User user;
public void saveUserPortrait(String PortraitCode){
	System.out.println("test");
	user.setHeadPortrait("PortraitCode");
	//System.out.println(PortraitCode.length());
	//userDaoImpl.update(user);
}
}
