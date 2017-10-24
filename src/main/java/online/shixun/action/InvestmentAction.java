package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.Investment;
import online.shixun.services.InvestmentService;

@Component("InvestmentAction")
public class InvestmentAction {
	@Autowired
	private InvestmentService investmentService;
	private List<Investment>list;
	private Investment investment;
	
	public List<Investment> getList() {
		return list;
	}

	public void setList(List<Investment> list) {
		this.list = list;
	}

	public String findInvestment(){
		list=investmentService.findInvestment();
		System.out.println(list.toString());
		return "list";	
	}
	public String deleteById(){
		investmentService.deleteById(investment);
		findInvestment();
		return "list";
	}

	public Investment getInvestment() {
		return investment;
	}

	public void setInvestment(Investment investment) {
		this.investment = investment;
	}
	
}
