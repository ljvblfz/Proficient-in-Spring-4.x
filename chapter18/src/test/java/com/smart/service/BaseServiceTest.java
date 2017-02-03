package com.smart.service;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext( {"xiaochun-service.xml", "xiaochun-dao.xml"})
public class BaseServiceTest extends UnitilsTestNG {
	@SpringBean(value = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

}
