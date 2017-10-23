/**   
* @Title: AdminDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午11:02:57 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.AdminDao;
import online.shixun.model.Admin;

/** 
* @ClassName: AdminDaoImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午11:02:57 
*  
*/
@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private BaseDao baseDao;

	@Override
	public int add(Admin admin) {
		baseDao.getHibernateTemplate().save(admin);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAll() {
		return (List<Admin>) baseDao.getHibernateTemplate().find("from Admin");
	}

	@Override
	public Admin getById(Long id) {
		return baseDao.getHibernateTemplate().get(Admin.class, id);
	}

	@Override
	public int delete(Admin admin) {
		baseDao.getHibernateTemplate().delete(admin);
		return 1;
	}


	@Override
	public int deleteById(Long id) {
		Admin admin = baseDao.getHibernateTemplate().load(Admin.class, id);
		baseDao.getHibernateTemplate().delete(admin);
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
		List<Admin> list = (List<Admin>) baseDao.getHibernateTemplate().find("from Admin a where a.adminId in (" + str + ")");
		if (list.size() > 0) {
			baseDao.getHibernateTemplate().deleteAll(list);
		}
		return 1;
	}

	@Override
	public int update(Admin admin) {
		baseDao.getHibernateTemplate().update(admin);
		return 1;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getByName(String name) {
		String queryString = "from Admin p where p.adminName=:name";
		String paramNames = "name";
		baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
		return (List<Admin>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
	}

}
