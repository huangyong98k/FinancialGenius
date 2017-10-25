/**
 * 
 */

package online.shixun.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import online.shixun.model.Investment;
import online.shixun.model.Product;
import online.shixun.services.InvestmentService;
import online.shixun.services.ProductService;
import online.shixun.services.UserService;
import online.shixun.model.User;

/**
 * @author 小胖
 *
 */
@Component("investmentAction")
public class InvestmentAction {

	@Autowired
	private InvestmentService investmentService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	private List<Investment> list;
	private List<Investment> list2;
	private Investment investment;
	private List<Investment> investments;
	private Long productId;
	private Long userId;
	private User user;
	private long id;
	private Product product;

	public String add() {
		System.out.println("~~~~~~~~~~~" + userId + "~~~~~~~~~~~" + productId);
		System.out.println(investment.toString());
		investmentService.addInvestmentByUserIdAndProductId(investment, userId, productId);
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
		System.out.println(list.toString());
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
	
	
	public String modifyState(){
		investment=investmentService.getById(investment.getInvestmentId());
		investment.setInvestmentStatus(0);
		investmentService.modifyStateInvestment(investment);
		list2=investmentService.findInvestment();
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
		
		
		public String nextFrontPage(){
			list=investmentService.nextPage();
			return "nextSuccess";
		}
		public String preFrontPage(){
			list=investmentService.prevPage();
			return "preSuccess";
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

	public String deleteInvestById() {
		investmentService.deleteById(investment);
		//findInvestment();
		investments=userService.findInvestmentsByUserId(userId);
		return "deleteSuccess";
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Investment getInvestment() {
		return investment;
	}

}
