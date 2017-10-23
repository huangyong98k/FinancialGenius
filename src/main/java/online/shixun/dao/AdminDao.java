/**   
* @Title: AdminDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午11:01:00 
* @version V1.0   
*/
package online.shixun.dao;

import java.util.List;

import online.shixun.common.UtilDao;
import online.shixun.model.Admin;

/** 
* @ClassName: AdminDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午11:01:00 
*  
*/
public interface AdminDao extends UtilDao<Admin> {
	List<Admin> getByName(String name);//根据姓名获取管理员信息
}
