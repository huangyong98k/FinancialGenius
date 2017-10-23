/**   
* @Title: InvestmentDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午11:11:58 
* @version V1.0   
*/
package online.shixun.dao;

import java.util.List;

import online.shixun.common.UtilDao;
import online.shixun.model.Investment;

/** 
* @ClassName: InvestmentDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午11:11:58 
*  
*/
public interface InvestmentDao extends UtilDao<Investment> {
	List<Investment> getInvestmentsByUserId(Long userId);//根据用户id获取用户投资信息
	List<Investment> getInvestmentsByProductId(Long ProductId);//根据产品id获取用户投资信息
}