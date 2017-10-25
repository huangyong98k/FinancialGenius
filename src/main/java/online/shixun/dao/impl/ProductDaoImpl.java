/**   
* @Title: ProductDaoImpl.java 
* @Package online.shixun.dao.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午10:11:23 
* @version V1.0   
*/
package online.shixun.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.shixun.common.BaseDao;
import online.shixun.dao.ProductDao;
import online.shixun.model.Product;


/** 
* @ClassName: ProductDaoImpl 
* @Description: 实现ProductDao接口 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午10:11:23 
*  
*/
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private BaseDao baseDao;

	@Override
	public int add(Product product) {
		baseDao.getHibernateTemplate().save(product);
		return 1;
	}
	@Override
	public Product getProduct(Product product) {
		return baseDao.getHibernateTemplate().get(Product.class, product.getProductId());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll() {
		return (List<Product>) baseDao.getHibernateTemplate().find("from Product");
	}
	@Override
	public Product getById(Long id) {
		return baseDao.getHibernateTemplate().get(Product.class, id);
	}

	@Override
	public int delete(Product product) {
		baseDao.getHibernateTemplate().delete(product);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		Product product = baseDao.getHibernateTemplate().load(Product.class, id);
		baseDao.getHibernateTemplate().delete(product);
		return 1;
	}

	@Override
	public int deleteAll(String[] lid) {
		String[] ids = lid;
		String str = "";
		for (int i = 0; i < ids.length; i++) {
			str += "'" + ids[i] + "'";
			if (i != (ids.length - 1))
				str += ",";
		}
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) baseDao.getHibernateTemplate().find("from Product p where p.productId in (" + str + ")");
		if (list.size() > 0) {
			baseDao.getHibernateTemplate().deleteAll(list);
		}
		return 1;
	}

	@Override
	public int update(Product product) {
		baseDao.getHibernateTemplate().update(product);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getByName(String name) {
		String queryString = "from Product p where p.productName=:name";
		String paramNames = "name";
		baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
		return (List<Product>) baseDao.getHibernateTemplate().findByNamedParam(queryString, paramNames, name);
	}
	//产品前后端分页
	
		int firstResult=0;
		@SuppressWarnings("unchecked")
		public List<Product> getAllUsePage() {
			DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
			List<Product> list= (List<Product>) baseDao.getHibernateTemplate().findByCriteria(criteria, 0, 5);	
			return list;
		}
	    @SuppressWarnings("unchecked")
		public List<Product> nextPage(){
	    	List<Product> list=(List<Product>) baseDao.getHibernateTemplate().find("from Product");
	    	DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
	    	if(firstResult+5<list.size()){
	    		firstResult=firstResult+5;
	    	}
	    	
			list= (List<Product>) baseDao.getHibernateTemplate().findByCriteria(criteria, firstResult, 5);
			
	    	return list; 	
	    }
	    @SuppressWarnings("unchecked")
		public List<Product> prevPage(){
	    	List<Product> list=(List<Product>) baseDao.getHibernateTemplate().find("from Product");
	    	DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
	    	if(firstResult-5>=0){
	    		firstResult=firstResult-5;
	    	}
			list= (List<Product>) baseDao.getHibernateTemplate().findByCriteria(criteria, firstResult, 5);
	    	return list; 	
	    }
}
