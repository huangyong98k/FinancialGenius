/**   
* @Title: RechargeAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午10:00:16 
* @version V1.0   
*/
package online.shixun.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.BankCard;
import online.shixun.model.RechargeRecord;
import online.shixun.services.impl.UserService;
import online.shixun.services.impl.BankCardService;
import online.shixun.services.impl.RechargeService;

/**
 * @ClassName: RechargeAction
 * @Description: 充值记录的Action
 * @author HPEU丶小咸鱼
 * @date 2017年11月2日 上午10:00:16
 * 
 */
@Component("rechargeAction")
public class RechargeAction {

	@Autowired
	private BankCardService bankCardService;
	@Autowired
	private UserService userService;
	@Autowired
	private RechargeService rechargeService;

	private double regMoney;
	private double witMoney;
	private String bankCardId;
	private long userId;
	private BankCard bankCard;
	private RechargeRecord rechargeRecord;

	public String addRechargeRecode(){
		rechargeService.addRechargeRecord(rechargeRecord);
//		bankCardService.updateBankBalance(bankCard,bankCardId);
		return "success";
	}

	public String getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public RechargeRecord getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(RechargeRecord rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	public double getRegMoney() {
		return regMoney;
	}

	public double getWitMoney() {
		return witMoney;
	}

	public void setRegMoney(double regMoney) {
		this.regMoney = regMoney;
	}

	public void setWitMoney(double witMoney) {
		this.witMoney = witMoney;
	}

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}
	
	
}
