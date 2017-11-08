/**   
* @Title: RechargeAction.java 
* @Package online.shixun.action 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年11月2日 上午10:00:16 
* @version V1.0   
*/
package online.shixun.action;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.BankCard;
import online.shixun.model.RechargeRecord;
import online.shixun.model.RechargeRecordDemo;
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

	private BankCard bankCard;
	private RechargeRecord rechargeRecord;
	private List<RechargeRecord> list;
	private double recharge;
	private int flag;

	public String addRechargeRecode() {
		rechargeService.addRechargeRecord(rechargeRecord);
		userService.updateUserBanlance(recharge, flag);
		return "success";
	}

	public String findAllRechargeRecode() {
		list = rechargeService.getRechargeByUserId();
		return "list";
	}

	public RechargeRecord getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(RechargeRecord rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

	public List<RechargeRecord> getList() {
		return list;
	}

	public void setList(List<RechargeRecord> list) {
		this.list = list;
	}

	public double getRecharge() {
		return recharge;
	}

	public int getFlag() {
		return flag;
	}

	public void setRecharge(double recharge) {
		this.recharge = recharge;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
