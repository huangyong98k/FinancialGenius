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
	private Investment investment;
	private List<Investment> investments;
	private Long productId;
	private Long userId;
	private User user;
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

	public String findInvestment() {
		list = investmentService.findInvestment();
		System.out.println(list.toString());
		return "list";
	}

	public String deleteById() {
		investmentService.deleteById(investment);
		findInvestment();
		return "list";
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
