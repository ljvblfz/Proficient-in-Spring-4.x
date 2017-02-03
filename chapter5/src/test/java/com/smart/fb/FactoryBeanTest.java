package com.smart.fb;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/com/smart/fb/beans.xml")
public class FactoryBeanTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public ApplicationContext factory = null;

    @Test
    public void testCarFactoryBean() {
        Car car_1 = factory.getBean("car1", Car.class);
        Car car_2 = factory.getBean("car1", Car.class);
        assertNotNull(car_1);
        assertNotSame(car_1, car_2);
        System.out.println(car_1);
    }

    @Test
    public void testCollFactoryBean() {
        List list = factory.getBean("favoriteList", List.class);
        Set set = factory.getBean("favoriteSet", Set.class);
        Map map = factory.getBean("emails", Map.class);
        Properties props = (Properties) factory.getBean("emailProps");
        assertEquals(set.size(), 3);
        assertEquals(list.size(), 3);
        assertEquals(map.size(), 2);
        assertEquals(props.size(), 2);
    }

    @Test
    public void testFieldFactoryBean() {
        Car car2 = (Car) factory.getBean("car2");
        assertNotNull(car2);
        System.out.println(car2);
    }

    @Test
    public void testPropPathFactoryBean() {
        Car car5 = (Car) factory.getBean("car5");
        Car car6 = (Car) factory.getBean("car6");
        assertNotNull(car5);
        assertNotNull(car6);
        System.out.println(car5);
        System.out.println(car6);
    }
}
