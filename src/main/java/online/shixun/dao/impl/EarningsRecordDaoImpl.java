/**   
* @Title: EarningsRecordDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 下午2:22:40 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import online.shixun.common.BaseDao;
import online.shixun.dao.EarningsRecordDao;
import online.shixun.model.EarningsRecord;

/** 
* @ClassName: EarningsRecordDaoImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 下午2:22:40 
*  
*/
public class EarningsRecordDaoImpl implements EarningsRecordDao {
	@Autowired
	private BaseDao baseDao;
	@Override
	public int add(EarningsRecord er) {
		baseDao.getHibernateTemplate().save(er);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EarningsRecord> getAll() {
		return (List<EarningsRecord>) baseDao.getHibernateTemplate().find("from EarningsRecord");
	}

	@Override
	public EarningsRecord getById(Long id) {
		return baseDao.getHibernateTemplate().get(EarningsRecord.class, id);
	}

	
	@Override
	public int delete(EarningsRecord er) {
		baseDao.getHibernateTemplate().delete(er);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		EarningsRecord er = baseDao.getHibernateTemplate().load(EarningsRecord.class, id);
		baseDao.getHibernateTemplate().delete(er);
		return 1;
	}

	@Override
	public int deleteAll(String[] str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EarningsRecord er) {
		baseDao.getHibernateTemplate().update(er);
		return 1;
	}

}
