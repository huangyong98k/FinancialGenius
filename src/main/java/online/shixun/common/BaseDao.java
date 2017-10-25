/**   
* @Title: BaseDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 上午10:56:45 
* @version V1.0   
*/
package online.shixun.common;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/** 
* @ClassName: BaseDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月19日 上午10:56:45 
*  
*/
@Repository
public class BaseDao extends HibernateDaoSupport{
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
    @Resource  
    public void setSessionFacotry(SessionFactory sessionFacotry) {  
        super.setSessionFactory(sessionFacotry);  
    } 
}
