package com.smart.oxm.xstream.converters;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.smart.utils.ResourceUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamConverterSample {
	public static String FILE_NAME = "";
	private static XStream xstream;
	private static User u;
	static{
        //new DomDriver()�����ַ�ʽ����Ҫ��xpp3��
	    xstream = new XStream(new DomDriver());
	    //���������,Ĭ��Ϊ��ǰ�����Ƽ��ϰ���
        xstream.alias("loginLog", LoginLog.class);
        xstream.alias("user", User.class);
        //�������Ա����
        xstream.aliasField("id",User.class,"userId");
        //�� User��userId������Ϊ XML����,Ĭ��ΪXML��Ԫ��
        xstream.useAttributeFor(User.class, "userId");
        //ȥ��������������xml�ĸ��ڵ�,������ XML�е� <logs></logs>���
        xstream.addImplicitCollection(User.class, "logs");
        //ע���Զ���ת����
        xstream.registerConverter(new DateConverter(Locale.SIMPLIFIED_CHINESE));
	}
	// ��ʼ��ת������
	public static void initUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
        u = new User();
		u.setUserId(1);
		u.setUserName("xstream");
		u.addLoginLog(log1);
		u.addLoginLog(log2);
	}
	 /**
     * JAVA����ת��ΪXML
     */
    public static void objectToXml()throws Exception{
    	initUser();
        FileOutputStream fs = new FileOutputStream(FILE_NAME);
        OutputStreamWriter writer = new OutputStreamWriter(fs, Charset.forName("UTF-8"));    
        xstream.toXML(u, writer);
    }
    
    /**
     * XMLת��ΪJAVA����
     */
    public static User xmlToObject()throws Exception{
    	FileInputStream fis = new FileInputStream(FILE_NAME);
    	InputStreamReader reader = new InputStreamReader(fis, Charset.forName("UTF-8")); 
        User u = (User) xstream.fromXML(fis);
        for(LoginLog log : u.getLogs()){
        	if(log!=null){
        		System.out.println("����IP: " + log.getIp());
        		System.out.println("����ʱ��: " + log.getLoginDate());
            }
        }
        return u;
    }

    public static void main(String[] args)throws Exception {
    	FILE_NAME = ResourceUtils.getResourceFullPath(XStreamConverterSample.class, "XStreamConverterSample.xml");
        objectToXml();
        xmlToObject();
    }
}
