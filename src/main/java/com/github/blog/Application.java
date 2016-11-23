/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.blog;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@ComponentScan
public class Application {
    
    @Bean(name = "MessageBean1")
    @Primary
    public MessageBean initMessageBean1(){
        MessageBean message = new MessageBean("Hello MessageBean1");
        return message;
    }
    
    @Bean(name = "MessageBean2")
    public MessageBean initMessageBean2(){
        MessageBean message = new MessageBean("Hello MessageBean2");
        return message;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        System.out.println("Daftar beans");
        List<String> listContainerAwal = Arrays.asList(applicationContext.getBeanDefinitionNames());
        for (String bean : listContainerAwal) {
            System.out.println("Bean name: " + bean);
        }
        
        MessageBean message1 = applicationContext.getBean("MessageBean1",MessageBean.class);
        MessageBean message2 = applicationContext.getBean("MessageBean2",MessageBean.class);
        System.out.println(message1.getText());
        System.out.println(message2.getText());

        message1.setText("Hello MessageBean1 Baru");
        MessageBean message3 = applicationContext.getBean("MessageBean1",MessageBean.class);
        System.out.println(message3.getText());
        
        MessageComponent messageComponent = applicationContext.getBean(MessageComponent.class);
        messageComponent.printMessageBean();
    }
}
