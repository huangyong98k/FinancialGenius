/**
 * 
 */

package online.shixun.action;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import online.shixun.model.Investment;

import online.shixun.services.InvestmentService;
import online.shixun.model.User;


/**
 * @author 小胖
 *
 */
@Component("investmentAction")
public class InvestmentAction {

	@Autowired
	private InvestmentService investmentService;

	private List<Investment> list;
	private Investment investment;
	private User user;
	
	public String add(){
		investmentService.addInvestment(investment);
		return "addSuccess";
	}
	public List<Investment> getList() {
		return list;
	}

	public void setList(List<Investment> list) {
		this.list = list;
	}

	public String findInvestment(){
		list=investmentService.findInvestment();
		
		return "list";	
	}
	public String deleteById(){
		investmentService.deleteById(investment);
		findInvestment();
		return "list";
	}
	//用户前后端分页
		public String nextPage() {
			list=investmentService.nextPage();
			for(Investment user:list) {
				System.out.println(user);
			}
			return "list";
		}
		public String prevPage() {
			list=investmentService.prevPage();
			return "list";
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInvestment(Investment investment) {
		this.investment = investment;
	}

}
