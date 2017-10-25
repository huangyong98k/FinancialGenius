package online.shixun.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.InvestmentDaoImpl;

@Service
public class StatisticsService {
	@Autowired
	private InvestmentDaoImpl investmentDaoImpl;
	
	/**
	 * 获取某一天之前的投资额，格式'yyyy-mm-dd'
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Double getTotalInvestment(String date){
		String sql = "select sum(principal) as TotalInvestment from tb_investment where beginTime < '"+date+"'";
		List list = investmentDaoImpl.getTotalInvestment(sql);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			return ObjectToDouble(it.next());
		}
		return null;
	}
	public Double ObjectToDouble(Object obj){
		return Double.parseDouble(""+obj);
	}

}
