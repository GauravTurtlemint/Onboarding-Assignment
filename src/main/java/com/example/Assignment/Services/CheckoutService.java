package com.example.Assignment.Services;

import com.example.Assignment.Models.Checkout;
import com.example.Assignment.dao.CheckoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;

    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Checkout getCheckoutByCheckoutId(String checkoutId) {
        return checkoutRepository.findById(checkoutId).get();
    }

    public void addCheckout(Checkout checkout) {
        checkoutRepository.save(checkout);
    }

    public Checkout updateCheckout(String checkoutId, Checkout checkout) {
        Checkout checkout1 = checkoutRepository.findById(checkoutId).get();

        if(Objects.nonNull(checkout1.getName()) && !"".equalsIgnoreCase(checkout.getName())){
            checkout1.setName(checkout.getName());
        }

        if(Objects.nonNull(checkout1.getEmail())&&!"".equalsIgnoreCase(checkout.getEmail())){
            checkout1.setEmail(checkout.getEmail());
        }

        if (Objects.nonNull(checkout1.getPhone())&&!"".equalsIgnoreCase(checkout.getPhone())){
            checkout1.setPhone(checkout.getPhone());
        }

        if (Objects.nonNull(checkout1.getInsurer())&&!"".equalsIgnoreCase(checkout.getInsurer())){
            checkout1.setInsurer(checkout.getInsurer());
        }

        checkoutRepository.save(checkout1);
        return checkout1;
    }

    public void deleteCheckout(String checkoutId) {
        checkoutRepository.deleteById(checkoutId);
    }
}
