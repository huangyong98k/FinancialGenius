package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.UserDao;
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
		System.out.println("111"+user);
		baseDao.getHibernateTemplate().save(user);
		return 1;
	}

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

	/*
	 * (非 Javadoc) <p>Title: getById</p> <p>Description:根据ID获取User </p>
	 * @param id
	 * @return
	 * @see online.shixun.dao.UserDao#getById(java.lang.Long)
	 */
	@Override
	public User getById(Long id) {
		return baseDao.getHibernateTemplate().get(User.class, id);
	}

	/*
	 * (非 Javadoc) <p>Title: getByName</p> <p>Description: </p>
	 * @param name
	 * @return
	 * @see online.shixun.dao.UserDao#getByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByName(String name) {
		String queryString = "from User u where u.userName=:name";
		String paramNames = "name";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
	}

	/*
	 * (非 Javadoc) <p>Title: delete</p> <p>Description: </p>
	 * @param user
	 * @return
	 * @see online.shixun.dao.UserDao#delete(online.shixun.model.User)
	 */
	@Override
	public int delete(User user) {
		baseDao.getHibernateTemplate().delete(user);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		User user = baseDao.getHibernateTemplate().load(User.class, id);
		baseDao.getHibernateTemplate().delete(user);
		return 1;
	}
	@Override
	public int update(User user) {
		baseDao.getHibernateTemplate().update(user);
		return 1;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByCrad(String card) {
		String queryString = "from User u where u.userCard=:card";
		String paramNames = "card";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, card);

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByEmail(String emial) {
		String queryString = "from User u where u.userEmail=:eamil";
		String paramNames = "eamil";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, emial);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getByPhone(String phone) {
		String queryString = "from User u where u.userPhone=:phone";
		String paramNames = "phone";
		return (List<User>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, phone);
	}

}
