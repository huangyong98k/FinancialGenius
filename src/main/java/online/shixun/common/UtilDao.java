/**   
* @Title: UtilDao.java 
* @Package online.shixun.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017年10月20日 上午9:12:11 
* @version V1.0   
*/
package online.shixun.common;

import java.util.List;


/** 
* @ClassName: UtilDao 
* @Description: Dao工具接口，定义通用方法。 
* @author HPEU丶小咸鱼
* @date 2017年10月20日 上午9:12:11 
*  
*/
public interface UtilDao <E>{
	int add(E obj);//增加
	List<E> getAll();//获取全部
	E getById(Long l);//根据id获取
	int delete(E obj);//删除
	int deleteById(Long l);//根据Id删除
	int deleteAll(String[] str);//删除所选
	int update(E obj);//修改
}
