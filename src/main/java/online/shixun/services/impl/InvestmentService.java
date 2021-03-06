/**   
* @Title: InvestmentService.java 
* @Package online.shixun.services 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 下午3:40:41 
* @version V1.0   
*/
package online.shixun.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.InvestmentDaoImpl;
import online.shixun.dao.impl.ProductDaoImpl;
import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.Investment;


/**
 * @ClassName: InvestmentService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author HPEU丶小咸鱼
 * @date 2017年10月20日 下午3:40:41
 * 
 */
@Service(value = "investmentService")
public class InvestmentService {
	@Autowired
	private InvestmentDaoImpl investmentDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Autowired
	private ProductDaoImpl productDaoImpl;

	public int deleteById(Long id){
		return investmentDaoImpl.deleteById(id);
	}

	public void addInvestment(Investment investment) {
		investmentDaoImpl.add(investment);
	}
//    public List<Investment> findInvestmentId(Long id){
//    	List<Investment> list= investmentDaoImpl.getById(id);
//		return list;
//    	
//    }
	
	
    //投资查询所有
    public List<Investment> findInvestment() {
		
		return investmentDaoImpl.getAll();
	}
	
	public void deleteById(Investment investment) {
		investmentDaoImpl.delete(investment);
	}
	


	public void addInvestmentByUserIdAndProductId(Investment investment,Long userId,Long productId){
		investment.setUser(userDaoImpl.getById(userId));
		investment.setProduct(productDaoImpl.getById(productId));
		investmentDaoImpl.add(investment);
	}

	public void modifyStateInvestment(Investment investment){
		investmentDaoImpl.update(investment);
	}
	
	public Investment getById(long id){
		return investmentDaoImpl.getById(id);
	}
	

	//服务类用户前后端分页
    public List<Investment> nextPage() {
    	return investmentDaoImpl.nextPage();	
	}
    public List<Investment> prevPage() {
    	return investmentDaoImpl.prevPage();	

	}

}
