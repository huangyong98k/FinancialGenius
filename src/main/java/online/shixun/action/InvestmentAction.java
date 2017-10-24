/**
 * 
 */
package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.Investment;
import online.shixun.model.User;
import online.shixun.services.InvestmentService;

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
	public Investment getInvestment() {
		return investment;
	}
	public void setList(List<Investment> list) {
		this.list = list;
	}
	public void setInvestment(Investment investment) {
		this.investment = investment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
