package online.shixun.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.UserDao;
import online.shixun.model.Investment;
import online.shixun.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	 * @Title: addUser
	 * @Description: 新增一个用户
	 * @param 
	 * @return int
	 */
	@Override
	public int add(User user) {
		baseDao.getHibernateTemplate().save(user);
		return 1;
	}
//    public User findUserById(User user){
//    	baseDao.getHibernateTemplate().fin
//    }
	/**
	 * 
	 * @Title: getUsers
	 * @Description: 获取所有用户
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return (List<User>) baseDao.getHibernateTemplate().find("from User");
	}

	/**
	 * 用id获取用户
	 */
	@Override
	public User getById(Long id) {
		return baseDao.getHibernateTemplate().get(User.class, id);
	}
	@Override
	public User getUser(User user) {
		return baseDao.getHibernateTemplate().get(User.class, user.getUserId());		
	}
	
	//通过用户名来查询，返回对象集合
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByName(String name) {
		String queryString = "from User u where u.userName=:name";
		String paramNames = "name";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
	}
     //删除user
	@Override
	public int delete(User user) {
		baseDao.getHibernateTemplate().delete(user);
		return 1;
	}
    //通过id删除user
	@Override
	public int deleteById(Long id) {
		User user = baseDao.getHibernateTemplate().load(User.class, id);
		baseDao.getHibernateTemplate().delete(user);
		return 1;
	}
	//修改用户属性
	@Override
	public int update(User user) {
		baseDao.getHibernateTemplate().update(user);
		return 1;
	}
	public void edit(User user) {
		baseDao.getHibernateTemplate().saveOrUpdate(user);;
	}
	
	@Override
	public int deleteAll(String[] lid) {
		String[] ids = lid;
		String str = "";
		for (int i = 0; i < ids.length; i++) {
			str += "'" + ids[i] + "'";
			if (i != (ids.length - 1))
				str += ",";
		}
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) baseDao.getHibernateTemplate().find("from User u where u.userId in (" + str + ")");
		if (list.size() > 0) {
			baseDao.getHibernateTemplate().deleteAll(list);
		}
		return 1;
	}
     //通过id来查找用户
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByCrad(String card) {
		String queryString = "from User u where u.userCard=:card";
		String paramNames = "card";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, card);

	}

    //邮箱来查找用户，返回一个集合
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByEmail(String emial) {
		String queryString = "from User u where u.userEmail=:eamil";
		String paramNames = "eamil";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, emial);
	}
   //返回通过电话号查到用户的集合
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByPhone(String phone) {
		String queryString = "from User u where u.userPhone=:phone";
		String paramNames = "phone";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, phone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Investment> getInvestmentsByUserId(Long userId) {
		String queryString = "select u.investments from User u where u.userId=:userId";
		String paramNames = "userId";
		baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, userId);
		return (List<Investment>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, userId);
	}
	
   //用户前后端分页
	
	int firstResult=0;
	@SuppressWarnings("unchecked")
	public List<User> getAllUsePage() {
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		List<User> list= (List<User>) baseDao.getHibernateTemplate().findByCriteria(criteria, 0, 5);	
		return list;
	}
    @SuppressWarnings("unchecked")
	public List<User> nextPage(){
    	List<User> list=(List<User>) baseDao.getHibernateTemplate().find("from User");
    	DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
    	if(firstResult+5<list.size()){
    		firstResult=firstResult+5;
    	}
    	
		list= (List<User>) baseDao.getHibernateTemplate().findByCriteria(criteria, firstResult, 5);
		
    	return list; 	
    }
    @SuppressWarnings("unchecked")
	public List<User> prevPage(){
    	List<User> list=(List<User>) baseDao.getHibernateTemplate().find("from User");
    	DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
    	if(firstResult-5>=0){
    		firstResult=firstResult-5;
    	}
		list= (List<User>) baseDao.getHibernateTemplate().findByCriteria(criteria, firstResult, 5);
    	return list; 	
    }
}
