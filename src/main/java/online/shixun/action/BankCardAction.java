/**
 * 
 */
package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.BankCard;
import online.shixun.services.UserService;
import online.shixun.services.impl.BankCardService;

/**
 * @author 小胖
 *银行卡的Action
 */
@Component("bankCardAction")
public class BankCardAction {

	@Autowired
	private BankCardService bankCardService;
	
	//绑定银行卡
	public String addBankCard(){
		
		return "success";
	}
}
