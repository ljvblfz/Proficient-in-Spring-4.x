package com.smart.oxm;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.smart.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.jibx.JibxMarshaller;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.Date;

@ContextConfiguration("classpath*:/applicationContext.xml")
public class SpringOxmSampleTest  extends AbstractTestNGSpringContextTests {
    private static  String FILE_NAME = "";

	@Autowired
	private XStreamMarshaller xstreamMarshaller;

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Autowired
	private CastorMarshaller castorMarshaller;

	//@Autowired
	//private JibxMarshaller jibxMarshaller;

	private User u;
	
	@BeforeClass
	public static void initClass(){
		FILE_NAME = ResourceUtils.getResourceFullPath(SpringOxmSample.class, "spring-oxm-sample.xml");
	}

	@BeforeTest
	public void init() {
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		u = new User();
		u.setUserName("spring-oxm");
		u.addLoginLog(log1);
		u.addLoginLog(log2);
		
	}

	@Test
	public void marshaller()throws Exception {
		Assert.assertNotNull(xstreamMarshaller);
		Assert.assertNotNull(jaxb2Marshaller);
		Assert.assertNotNull(castorMarshaller);
		//Assert.assertNotNull(jibxMarshaller);

		FileOutputStream os = null;
		try {
			os = new FileOutputStream(FILE_NAME);
			xstreamMarshaller.marshal(u, new StreamResult(os));
			//jaxb2Marshaller.marshal(u, new StreamResult(os));
			//castorMarshaller.marshal(u, new StreamResult(os));
			//jibxMarshaller.marshal(u, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

}
