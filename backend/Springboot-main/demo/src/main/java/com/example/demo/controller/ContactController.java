package com.example.demo.controller;

import com.example.demo.model.ContactModel;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/submit")
    public ContactModel submitMessage(@RequestBody ContactModel contactModel) {
        return contactService.saveMessage(contactModel);
    }

    @GetMapping("/messages")
    public List<ContactModel> getAllMessages() {
        return contactService.getAllMessages();
    }

    @GetMapping("/messages/{id}")
    public ContactModel getMessageById(@PathVariable Long id) {
        return contactService.getMessageById(id);
    }

    @PutMapping("/messages/{id}")
    public ContactModel updateMessage(@PathVariable Long id, @RequestBody ContactModel contactModel) {
        return contactService.updateMessage(id, contactModel);
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable Long id) {
        contactService.deleteMessage(id);
    }
}