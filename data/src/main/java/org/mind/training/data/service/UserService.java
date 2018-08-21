package org.mind.training.data.service;

import org.mind.training.data.entity.User;
import org.mind.training.data.entity.UserRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private JmsTemplate jmsTemplate;

    public UserService(UserRepository userRepository, JmsTemplate jmsTemplate) {
        this.userRepository = userRepository;
        this.jmsTemplate = jmsTemplate;
    }

    public void add(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", "insert");
    }


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
