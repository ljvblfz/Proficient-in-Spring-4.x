package com.smart.oxm.xstream.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.smart.domain.User;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class PersistenceSample {
	private static List<User> users;

	@SuppressWarnings("unchecked")
	public void persist() {
		users = new ArrayList<User>();
		User user = new User();
		user.setUserId(1);
		user.setCredits(10);
		user.setUserName("tom");
		user.setPassword("123456");
		users.add(user);		
		File file = new File("out");
		PersistenceStrategy strategy = new FilePersistenceStrategy(file);
		List list = new XmlArrayList(strategy);
		list.addAll(users);
	}
	
	public static void main(String[] args)throws Exception {
		PersistenceSample converter = new PersistenceSample();
		converter.persist();
		/*
		  xstream = new XStream();
		  xstream.registerConverter(new PersistenceArrayListConverter(xstream));
		  String xml = xstream.toXML(users);
          System.out.println(xml);
        */
	}

}
