package com.example.demo.controller;

import com.example.demo.model.PaymentModel;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/submit1")
    public PaymentModel submitMessage(@RequestBody PaymentModel paymentModel) {
        return paymentService.saveMessage(paymentModel);
    }

    @GetMapping("/messages1")
    public List<PaymentModel> getAllMessages() {
        return paymentService.getAllMessages();
    }

    @GetMapping("/messages1/{id}")
    public PaymentModel getMessageById(@PathVariable Long id) {
        return paymentService.getMessageById(id);
    }

    @PutMapping("/messages1/{id}")
    public PaymentModel updateMessage(@PathVariable Long id, @RequestBody PaymentModel paymentModel) {
        return paymentService.updateMessage(id, paymentModel);
    }

    @DeleteMapping("/messages1/{id}")
    public void deleteMessage(@PathVariable Long id) {
        paymentService.deleteMessage(id);
    }
}
