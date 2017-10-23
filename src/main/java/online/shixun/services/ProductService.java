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

/** 
* @ClassName: ProductService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月19日 上午9:26:15 
*  
*/
@Service(value="productService")
public class ProductService {

	@Autowired
	private ProductDaoImpl productDaoImpl;
	
	public List<Product> getAllProducts(){
		return productDaoImpl.getAll();
	}
	
	public Product findById(Long id){
		return productDaoImpl.getById(id);
	}
	
	public int delete(Product product){
		return productDaoImpl.delete(product);
	}
	
	public int add(Product product){
		return productDaoImpl.add(product);
	}
}
