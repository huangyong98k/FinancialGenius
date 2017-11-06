package online.shixun.action;

import java.io.FileOutputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder; 
import sun.misc.BASE64Encoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import online.shixun.services.impl.PortraitService;

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
	
	private String result = null;
	
    public String getUserPortaitCode() {
		return userPortaitCode;
	}
	public void setUserPortaitCode(String userPortaitCode) {
		this.userPortaitCode = userPortaitCode;
	}
	@ResponseBody
	public void saveImage(){
		System.out.println("666");
		//对字节数组字符串进行Base64解码并生成图片  
        if (userPortaitCode == null) //图像数据为空  
        	{
        	System.out.println("null");
            result="头像为空";  
            }
        System.out.println(userPortaitCode);
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
            String imgFilePath = "C:\\images\\new.jpg";//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);    
            System.out.println(b);
            out.write(b);  
            out.flush();  
            out.close();  
        
        }   
        catch (Exception e)   
        {  
        	System.out.println("error");
            result="error";  
        }  
    
    	//portraitService.saveUserPortrait(userPortaitCode);
    	result="xiugai";
    	//return result;
    }
}
