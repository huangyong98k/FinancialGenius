/**   
* @Title: ProductDao.java 
* @Package online.shixun.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月19日 下午7:55:41 
* @version V1.0   
*/
package online.shixun.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import online.shixun.common.UtilDao;
import online.shixun.model.Product;
import online.shixun.model.User;
/** 
* @ClassName: ProductDao 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author HPEU丶小咸鱼
* @date 2017年10月19日 下午7:55:41 
*  
*/
@Repository
public interface ProductDao extends UtilDao<Product>{
	List<Product> getByName(String name);//根据姓名获取产品信息

	User getProduct(Product product);
}
