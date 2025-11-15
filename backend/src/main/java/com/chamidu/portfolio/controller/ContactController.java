package com.chamidu.portfolio.controller;

import com.chamidu.portfolio.entity.ContactMessage;
import com.chamidu.portfolio.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "https://chamiduprabodya.github.io")
public class ContactController {
    
    @Autowired
    private ContactMessageService contactMessageService;
    
    @PostMapping
    public ResponseEntity<ContactMessage> submitContactForm(@RequestBody ContactMessage contactMessage) {
        try {
            ContactMessage savedMessage = contactMessageService.saveContactMessage(contactMessage);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        try {
            List<ContactMessage> messages = contactMessageService.getAllContactMessages();
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}