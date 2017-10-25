/**   
* @Title: ProductService.java 
* @Package online.shixun.services 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 上午9:26:15 
* @version V1.0   
*/
package online.shixun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shixun.dao.impl.ProductDaoImpl;
import online.shixun.model.Product;
import online.shixun.model.User;

/**
 * @ClassName: ProductService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author HPEU丶小咸鱼
 * @date 2017年10月19日 上午9:26:15
 * 
 */
@Service(value = "productService")
public class ProductService {
	@Autowired
	private ProductDaoImpl productDaoImpl;

	public void addProduct(Product product) {
		productDaoImpl.add(product);
	}

	public List<Product> findProducts() {
		return productDaoImpl.getAllProductPage();

	}

	public Product getProduct(Product product) {
		return productDaoImpl.getProduct(product);
	}

	public void deleteById(Product product) {
		productDaoImpl.delete(product);

	}

	public List<Product> getAllProducts() {
		return productDaoImpl.getAll();
	}

	public Product findById(Long id) {
		return productDaoImpl.getById(id);
	}

	public int add(Product product) {
		return productDaoImpl.add(product);
	}

	public void edit(Product product) {
		productDaoImpl.update(product);
	}


	// 添加产品 产品名 ajax
	public int findByName(String name) {
		List<Product> product = productDaoImpl.getByName(name);
		if (product.size() > 0) {
			return 1;
		}
		return 0;
	}

	// 服务类产品后端分页
	public List<Product> nextPage() {
		return productDaoImpl.nextPage();
	}

	public List<Product> prevPage() {
		return productDaoImpl.prevPage();
	}

	// 通过产品名搜索
	public List<Product> findUseName(String name) {
		List<Product> list = productDaoImpl.getByName(name);
		return list;
	}

}
