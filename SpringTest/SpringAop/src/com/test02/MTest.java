package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Person man = (Person)factory.getBean("man");
		Person woman = factory.getBean("woman",Person.class);
		
		man.work();
		
		woman.work();
	}
}
