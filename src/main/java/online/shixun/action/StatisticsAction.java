package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

import online.shixun.services.impl.StatisticsService;

@Component("statisticsAction")
public class StatisticsAction {
	@Autowired
	private StatisticsService statisticsAction;
	private String date;
	private Double totalInvestment;

	public String totalInvestment(){
		totalInvestment = statisticsAction.getTotalInvestment(date);
		return Action.SUCCESS;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

}
