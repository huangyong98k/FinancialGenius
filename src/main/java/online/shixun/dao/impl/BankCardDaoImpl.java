/**   
* @Title: BankCardDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 下午2:21:51 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.BankCardDao;
import online.shixun.model.BankCard;

/** 
* @ClassName: BankCardDaoImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 下午2:21:51 
*  
*/
@Repository
public class BankCardDaoImpl implements BankCardDao {
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public int add(BankCard bc) {
		baseDao.getHibernateTemplate().save(bc);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankCard> getAll() {
		return (List<BankCard>) baseDao.getHibernateTemplate().find("from BankCard");
	}

	@Override
	public BankCard getById(Long id) {
		return baseDao.getHibernateTemplate().get(BankCard.class, id);
	}

	@Override
	public int delete(BankCard bc) {
		baseDao.getHibernateTemplate().delete(bc);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		BankCard bc = baseDao.getHibernateTemplate().load(BankCard.class, id);
		baseDao.getHibernateTemplate().delete(bc);
		return 1;
	}

	@Override
	public int deleteAll(String[] str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BankCard bc) {
		baseDao.getHibernateTemplate().update(bc);
		return 1;
	}

}
