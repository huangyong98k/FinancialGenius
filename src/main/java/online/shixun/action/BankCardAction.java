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
	
	private BankCard bankCard;
	
	//绑定银行卡
	public String addBankCard(){
		bankCardService.addBankCardByUserId(bankCard);
		return "success";
	}

	public BankCard getBankCard() {
		return bankCard;
	}


	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

}
