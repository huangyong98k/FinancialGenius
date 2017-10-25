/**
 * 
 */
package online.shixun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.shixun.model.Product;
import online.shixun.services.ProductService;

/**
 * @author 小胖
 *
 */
@Component("productAction")
public class ProductAction {

	@Autowired
	private ProductService productService;

	private List<Product> list;
	private Product product;
	private long productId;

	public String findAllProducts() {
		System.out.println("productAction!findAllProducts");
		list = productService.getAllProducts();
		return "findAllSuccess";
	}

	public String addInvestment(){
		return "addInvestment";
	}

	public String findProduct(){
		list=productService.findProducts();
		System.out.println("wocao"+list.toString());
		return "list";
	}
	public String addProduct(){
		productService.addProduct(product);
		findProduct();
		return "addProduct";
	}
	public String to_edit(){
		product=productService.getProduct(product);
		return "to_edit";
	}
	public String do_edit(){
		productService.edit(product);;
		findProduct();
		return "do_edit";
	}

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
	public String deleteById() {
		productService.deleteById(product);
		findProduct();
		return "list";
	}
	//产品前后端分页
	public String nextPage() {
		list=productService.nextPage();
		return "nextList";
	}
	public String prevPage() {
		list=productService.prevPage();
		return "preList";
	}
	
}
