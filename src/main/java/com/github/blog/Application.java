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

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        System.out.println("Daftar beans");
        List<String> listContainer = Arrays.asList(applicationContext.getBeanDefinitionNames());
        for (String bean : listContainer) {
            System.out.println("Bean name: " + bean);
        }
    }
}
