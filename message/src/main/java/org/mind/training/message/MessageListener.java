package org.mind.training.message;

import org.mind.training.entity.Address;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(String text) {
        System.out.println("Received <" + text + ">");
    }

}
