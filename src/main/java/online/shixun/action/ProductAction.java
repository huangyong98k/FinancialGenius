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

	public String findAllProducts() {
		System.out.println("productAction!findAllProducts");
		list = productService.getAllProducts();
		return "findAllSuccess";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

}
