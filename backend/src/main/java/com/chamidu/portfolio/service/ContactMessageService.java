package com.chamidu.portfolio.service;

import com.chamidu.portfolio.entity.ContactMessage;
import com.chamidu.portfolio.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {
    
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    
    public ContactMessage saveContactMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }
    
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageRepository.findAll();
    }
    
    public ContactMessage getContactMessageById(Long id) {
        return contactMessageRepository.findById(id).orElse(null);
    }
}