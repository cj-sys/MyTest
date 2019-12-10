package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test02.Hello_Ko;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Hello h = (Hello) factory.getBean("helloEn");
		h.prn("spring");
		
		com.test02.Hello h1 = factory.getBean("helloKo", Hello_Ko.class);
		h1.prn("½ºÇÁ¸µ");
		
	}
}
