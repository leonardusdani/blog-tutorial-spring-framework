package com.github.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageComponent {
    
    private final MessageBean messageBean;
    
    @Autowired
    public MessageComponent(MessageBean messageBean) {
        this.messageBean = messageBean;
    }  
    
    public void printMessageBean(){
        System.out.println(messageBean.getText());
    }
    
}
