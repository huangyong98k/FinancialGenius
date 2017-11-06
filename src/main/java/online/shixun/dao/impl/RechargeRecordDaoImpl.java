/**   
* @Title: RechargeRecordDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 下午2:20:19 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import online.shixun.common.BaseDao;
import online.shixun.dao.RechargeRecordDao;
import online.shixun.model.RechargeRecord;

/** 
* @ClassName: RechargeRecordDaoImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 下午2:20:19 
*  
*/
public class RechargeRecordDaoImpl implements RechargeRecordDao {
	@Autowired
	private BaseDao baseDao;

	@Override
	public int add(RechargeRecord rr) {
		baseDao.getHibernateTemplate().save(rr);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RechargeRecord> getAll() {
		return (List<RechargeRecord>) baseDao.getHibernateTemplate().find("from RechargeRecord");
	}

	
	@Override
	public RechargeRecord getById(Long id) {
		return baseDao.getHibernateTemplate().get(RechargeRecord.class, id);
	}


	@Override
	public int delete(RechargeRecord rr) {
		baseDao.getHibernateTemplate().delete(rr);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		RechargeRecord rr = baseDao.getHibernateTemplate().load(RechargeRecord.class, id);
		baseDao.getHibernateTemplate().delete(rr);
		return 1;
	}

	@Override
	public int deleteAll(String[] str) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RechargeRecord rr) {
		baseDao.getHibernateTemplate().update(rr);
		return 1;
	}

}
