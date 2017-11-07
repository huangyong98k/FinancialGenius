/**   
* @Title: RechargeRecordDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月6日 下午2:18:59 
* @version V1.0   
*/
package online.shixun.dao;

import java.util.List;

import online.shixun.common.UtilDao;
import online.shixun.model.RechargeRecord;
import online.shixun.model.RechargeRecordDemo;

/** 
* @ClassName: RechargeRecordDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年11月6日 下午2:18:59 
*  
*/
public interface RechargeRecordDao extends UtilDao<RechargeRecord> {
	List<RechargeRecord> getRechargeRecordByUserId(String sql);//根据用户Id查找充值记录
}
