package com.ysh.test_project.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ysh.test_project.test.improvedqury.CommonProcess;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  // Spring 컨테이너 초기화
        //ApplicationContext context = new AnnotationConfigApplicationContext("servlet-context.xml");
		 // Spring 컨테이너 초기화
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:root-context.xml");
        
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("Beans defined in the context:");
        for (String beanName : beanNames) {
            System.out.println("beanName : " + beanName);
        }



        // Spring 컨테이너에서 CommonProcess Bean 가져오기
        CommonProcess commonProcess = (CommonProcess)context.getBean(CommonProcess.class);


		
		//CommonProcess commonProcess = new CommonProcess();
		commonProcess.process();

	}

}
