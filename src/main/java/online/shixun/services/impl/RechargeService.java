/**
 * 
 */
package online.shixun.services.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.RechargeRecordDaoImpl;
import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.RechargeRecord;
import online.shixun.model.RechargeRecordDemo;

/**
 * @author 小胖
 *
 */
@Service(value="rechargeService")
public class RechargeService {

	@Autowired
	private RechargeRecordDaoImpl rechargeRecordDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	//添加充值/提现记录
	public void addRechargeRecord(RechargeRecord rechargeRecord){
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession(); 
        long userId = (long) session.getAttribute("userId");
		System.out.println(userId+"$$$$$$$$$$$$$$$$$$");
		rechargeRecord.setUser(userDaoImpl.getById(userId));
		rechargeRecordDaoImpl.add(rechargeRecord);
	}
	
	public List<RechargeRecord> getRechargeByUserId(){
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession(); 
        long userId = (long) session.getAttribute("userId");
		String sql = "select * from tb_rechargeRecord where userId = "+userId+"";
		return rechargeRecordDaoImpl.getRechargeRecordByUserId(sql);
	}
}
