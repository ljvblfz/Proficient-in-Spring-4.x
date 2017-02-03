package com.smart.oxm.xstream.alias;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class XStreamAliasSample {
    private static XStream xstream;
    static{
        //new DomDriver()，这种方式不需要加xpp3包
        xstream = new XStream(new DomDriver());
        //设置类别名,默认为当前类名称加上包名
        xstream.alias("loginLog", LoginLog.class);
        xstream.alias("user", User.class);
        //设置类成员别名
        xstream.aliasField("id",User.class,"userId");

        //把 User的userId属性视为 XML属性,默认为XML的元素
        xstream.aliasAttribute(LoginLog.class, "userId","id");
        xstream.useAttributeFor(LoginLog.class, "userId");

        //去掉集合类型生成xml的父节点,即忽略 XML中的 <logs></logs>标记
        xstream.addImplicitCollection(User.class, "logs");
    }
    // 初始化转换对象
    public static User getUser() {
        LoginLog log1 = new LoginLog();
        LoginLog log2 = new LoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(new Date());
        log2.setIp("192.168.1.92");
        log2.setLoginDate(new Date());
        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);
        return user;
    }
    /**
     * JAVA对象转化为XML
     */
    public static void objectToXml()throws Exception{
        User user = getUser();
        FileOutputStream fs = new FileOutputStream("out/XStreamAliasSample.xml");
        xstream.toXML(user, fs);
    }

    /**
     * XML转化为JAVA对象
     */
    public static User xmlToObject()throws Exception{
        FileInputStream fis = new FileInputStream("out/XStreamAliasSample.xml");
        User u = (User) xstream.fromXML(fis);
        for(LoginLog log : u.getLogs()){
            if(log!=null){
                System.out.println("访问IP: " + log.getIp());
                System.out.println("访问时间: " + log.getLoginDate());
            }
        }
        return u;
    }

    public static void main(String[] args)throws Exception {
        objectToXml();
        xmlToObject();
    }
}
