package com.example.demo.service;

import com.example.demo.model.ContactModel;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactModel saveMessage(ContactModel contactModel) {
        return contactRepository.save(contactModel);
    }

    public List<ContactModel> getAllMessages() {
        return contactRepository.findAll();
    }

    public ContactModel getMessageById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public ContactModel updateMessage(Long id, ContactModel contactModel) {
        Optional<ContactModel> existingMessageOpt = contactRepository.findById(id);
        if (existingMessageOpt.isPresent()) {
            ContactModel existingMessage = existingMessageOpt.get();
            existingMessage.setName(contactModel.getName());
            existingMessage.setEmail(contactModel.getEmail());
            existingMessage.setPhone(contactModel.getPhone());
            existingMessage.setAddress(contactModel.getAddress());
            existingMessage.setMessage(contactModel.getMessage());
            return contactRepository.save(existingMessage);
        } else {
            return null;
        }
    }

    public void deleteMessage(Long id) {
        contactRepository.deleteById(id);
    }
}