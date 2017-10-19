/**   
* @Title: BaseDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 上午10:56:45 
* @version V1.0   
*/
package online.shixun.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/** 
* @ClassName: BaseDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月19日 上午10:56:45 
*  
*/
public abstract class BaseDao<E> extends HibernateDaoSupport{
	HibernateTemplate ht = this.getHibernateTemplate();
	public abstract List<E> getAll();
	public abstract E find(E obj);
	public abstract E findById(Long l);
	public abstract E findByName(String str);
	public abstract int delete(E obj);
	public abstract int sava(E obj);
	public abstract int update(E obj);

}
