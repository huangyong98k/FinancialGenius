package online.shixun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.model.User;


@Repository
public class UserDaoImpl  {

	@Autowired
	private BaseDao baseDao;
	
	//添加用户（新增用户）
	public void add(User user){
		baseDao.getHibernateTemplate().save(user);
	}

}
