/**   
* @Title: InvestmentService.java 
* @Package online.shixun.services 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 下午3:40:41 
* @version V1.0   
*/
package online.shixun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.InvestmentDaoImpl;
import online.shixun.model.Investment;

/** 
* @ClassName: InvestmentService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 下午3:40:41 
*  
*/
@Service(value="investmentService")
public class InvestmentService {
	@Autowired
	private InvestmentDaoImpl investmentDaoImpl;
	public List<Investment> getInvestmentsByUserId(Long userId){
		return investmentDaoImpl.getInvestmentsByUserId(userId);
	}

}