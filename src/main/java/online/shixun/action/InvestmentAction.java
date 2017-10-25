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
	private List<Investment> list2;
	private long id;
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
	//投资查询
	public String findInvestment(){
		list=investmentService.findInvestment();
		return "list";	
	}
	//投资失效查询
	public String findInvestment2(){
		list2=investmentService.findInvestment();
		return "list2";	
	}
	public String deleteById(){
		investmentService.deleteById(investment);
		findInvestment();
		return "list";
	}
	//单独通过ID来查询投资
	/*public String findInvestmentId(){
		investmentService.getById(investment.getInvestmentId());
		findInvestment();
		return "list3";
	}*/
	
	/*public String updateInvestment(){
		findInvestment();
		return "list2";
		
	}*/
	
	public String modifyState(){
		investment=investmentService.getById(investment.getInvestmentId());
		investment.setInvestmentStatus(0);
		investmentService.modifyStateInvestment(investment);
		findInvestment();
		return "list2";
		
	}
	//投资查询前后端分页
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
		
	//投资失效前后台查询
		public String nextPage2() {
			list2=investmentService.nextPage();
			for(Investment user:list2) {
				System.out.println(user);
			}
			return "list2";
		}
		
		public String prevPage2() {
			list2=investmentService.prevPage();
			return "list2";
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
	public List<Investment> getList2() {
		return list2;
	}
	public void setList2(List<Investment> list2) {
		this.list2 = list2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
