/**
 * 
 */
package online.shixun.services.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.BankCardDaoImpl;
import online.shixun.dao.impl.UserDaoImpl;
import online.shixun.model.BankCard;

/**
 * @author 小胖 银行卡业务
 */
@Service(value = "bankCardService")
public class BankCardService {

	@Autowired
	private BankCardDaoImpl bankCardDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;

	// 添加银行卡
	public void addBankCardByUserId(BankCard bankCard) {
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession(); 
        long userId = (long) session.getAttribute("userId");
		bankCard.setUser(userDaoImpl.getById(userId));
		bankCardDaoImpl.add(bankCard);
	}
	//修改银行卡余额
//	public void updateBankBalance(BankCard bankCard){
//		HttpServletRequest request=ServletActionContext.getRequest();//获得session
//        HttpSession session=request.getSession(); 
//        long userId = (long) session.getAttribute("userId");
//        System.out.println("++++++++++++++++"+userId);
//		bankCard.setUser(userDaoImpl.getById(userId));
//		bankCardDaoImpl.update(bankCard);
//	}
}
