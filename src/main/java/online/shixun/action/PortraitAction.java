package online.shixun.action;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder; 
import sun.misc.BASE64Encoder;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.model.User;
import online.shixun.services.impl.PortraitService;
import online.shixun.services.impl.UserService;

import java.util.Calendar;
/** 
* @ClassName: EarningAction 
* @Description: 头像设置的Action 
* @author 刘杰生
* @date 2017年11月6日 下午14:28:16 
*  
*/
@SuppressWarnings({ "restriction", "unused" })
@Component("portraitAction")
public class PortraitAction {
	private PortraitService portraitService;
	private String userPortaitCode;
	
	@Autowired
	private UserService userService;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private String result = null;
	private Long userId;
    public String getUserPortaitCode() {
		return userPortaitCode;
	}
	public void setUserPortaitCode(String userPortaitCode) {
		this.userPortaitCode = userPortaitCode;
	}
	@ResponseBody
	public void saveImage(){
		HttpServletRequest request=ServletActionContext.getRequest();//获得session
        HttpSession session=request.getSession();
        
        userId = (Long) session.getAttribute("userId");
		//对字节数组字符串进行Base64解码并生成图片  
        if (userPortaitCode == null) //图像数据为空  
        	{
        	System.out.println("null");
            result="头像为空";  
            }
        //System.out.println(userPortaitCode);
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(userPortaitCode);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int second = c.get(Calendar.SECOND);
            String time = ""+second;
            System.out.println(second);
            StringBuilder sb = new StringBuilder();
            StringBuilder newName = new StringBuilder();
            String imgFilePath = "C:\\Users\\jiaboya\\Desktop\\mywebapps\\wtpwebapps\\FinancialGenius\\userInfo\\img\\investor_page\\";//新生成的图片  
            String imgFileName = userId.toString();
            sb.append(imgFilePath);
            sb.append(imgFileName);
            sb.append(time);
            sb.append("Portait.jpg");
            newName.append(imgFileName);
            newName.append(time);
            newName.append("Portait.jpg");
            OutputStream out = new FileOutputStream(sb.toString()); 
            user=userService.getUserById(userId);
            user.setHeadPortrait(newName.toString());
            userService.edit(user);
            out.write(b);  
            out.flush();  
            out.close();  
            result="success";
        }   
        catch (Exception e)   
        {  
        	System.out.println("error");
            result="error";  
        }  
    
    }
}
