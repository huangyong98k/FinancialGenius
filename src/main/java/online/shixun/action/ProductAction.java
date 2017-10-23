package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.Product;
import online.shixun.services.ProductService;

@Component("productAction")
public class ProductAction {
	@Autowired
	private ProductService productService;

	private List<Product> list;
	private Product product;
	
	public String findProduct(){
		list=productService.findProducts();
		System.out.println("wocao"+list.toString());
		return "list";
	}
//	public String to_edit(){
//		user=userService.getUser(user);
//		return "to_edit";
//	}
//	public String do_edit(){
//		userService.edit(user);;
//		list = userService.findUsers();
//		return "do_edit";
//	}
//	public void registerCheck(){
//		System.out.println("userAction!registerCheck");
//		userService.addUser(user);
//	}
//	public String register(){
//		System.out.println("userAction!register");
//		userService.addUser(user);
//		return "register";
//	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
