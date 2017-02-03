package com.smart.oxm;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class SpringOxmSample {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    
    private User getUser(){
    	 LoginLog log1 = new LoginLog();
         log1.setIp("192.168.1.91");
         log1.setLoginDate(new Date());
         LoginLog log2 = new LoginLog();
         log2.setIp("192.168.1.92");
         log2.setLoginDate(new Date());  
         LoginLog log3 = new LoginLog();
         log3.setIp("192.168.1.93");
         log3.setLoginDate(new Date());
         User user = new User();
         user.setUserName("spring-oxm");
         user.addLoginLog(log1);
         user.addLoginLog(log2);
         user.addLoginLog(log3);
         return user;
    }
    /**
     * JAVA对象转化为XML
     */
    public  void objectToXml()throws Exception{
        User user = getUser();
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("D:\\masterSpring\\chapter14\\out\\SpringOxmSample.xml");
            this.marshaller.marshal(user, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
    
    /**
     * XML转化为JAVA对象
     */
    public  void xmlToObject()throws Exception{
    	 FileInputStream is = null;
    	 User u = null;
         try {
             is = new FileInputStream("D:\\masterSpring\\chapter14\\out\\SpringOxmSample.xml");
             u = (User) this.unmarshaller.unmarshal(new StreamSource(is));
         } finally {
             if (is != null) {
                 is.close();
             }
         }
        for(LoginLog log : u.getLogs()){
        	if(log!=null){
        		System.out.println("访问IP: " + log.getIp());
        		System.out.println("访问时间: " + log.getLoginDate());
            }
        }
       
    }

    public static void main(String[] args) throws Exception {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
        SpringOxmSample oxm = (SpringOxmSample) appContext.getBean("springOxm");
        oxm.objectToXml();
        oxm.xmlToObject();
    }
    
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}

