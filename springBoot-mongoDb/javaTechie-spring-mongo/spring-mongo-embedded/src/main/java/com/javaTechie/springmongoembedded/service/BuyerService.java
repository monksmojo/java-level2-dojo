package com.javaTechie.springmongoembedded.service;

import com.javaTechie.springmongoembedded.entity.Buyer;
import com.javaTechie.springmongoembedded.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    public Boolean placeOrder(Buyer buyer){
        buyerRepository.save(buyer);
        return true;
    }

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long id){
        return buyerRepository.findByBuyerId(id);
    }

    public Collection<Buyer> getBuyersBYName(String name){
        return buyerRepository.findByNameContaining(name);
    }

    public Collection<Buyer> getBuyerByStateAndCity(String city,String state){
        return buyerRepository.findByCityAndState(city,state);
    }

    public Collection<Buyer> getBuyerByPinCode(Integer pinCode){
        return buyerRepository.findByPinCode(pinCode);
    }

    public Collection<Buyer> getBuyerProducts(Long id){
        return buyerRepository.findBuyersProducts(id);
    }

    public Collection<Buyer>


    getProductsOnBasesOfMaxPrice(Double price){
        return buyerRepository.findByPriceFiler(price);
    }




}
