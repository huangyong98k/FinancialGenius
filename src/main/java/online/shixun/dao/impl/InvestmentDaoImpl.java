/**   
* @Title: InvestmentDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 下午2:22:33 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.InvestmentDao;
import online.shixun.model.Admin;
import online.shixun.model.Investment;

/** 
* @ClassName: InvestmentDaoImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 下午2:22:33 
*  
*/
@Repository
public class InvestmentDaoImpl implements InvestmentDao {
	@Autowired
	private BaseDao baseDao;

	@Override
	public int add(Investment investment) {
		baseDao.getHibernateTemplate().save(investment);
		return 1;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Investment> getAll() {
		return (List<Investment>) baseDao.getHibernateTemplate().find("from Investment");
	}


	@Override
	public Investment getById(Long id) {
		return baseDao.getHibernateTemplate().get(Investment.class, id);
	}

	@Override
	public int delete(Investment investment) {
		baseDao.getHibernateTemplate().delete(investment);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		Investment investment = baseDao.getHibernateTemplate().load(Investment.class, id);
		baseDao.getHibernateTemplate().delete(investment);
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
		List<Admin> list = (List<Admin>) baseDao.getHibernateTemplate().find("from Investment i where i.investmentId in (" + str + ")");
		if (list.size() > 0) {
			baseDao.getHibernateTemplate().deleteAll(list);
		}
		return 1;
	}

	@Override
	public int update(Investment investment) {
		baseDao.getHibernateTemplate().update(investment);
		return 1;
	}

	@Override
	public List<Investment> getInvestmentsByProductId(Long ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

}
