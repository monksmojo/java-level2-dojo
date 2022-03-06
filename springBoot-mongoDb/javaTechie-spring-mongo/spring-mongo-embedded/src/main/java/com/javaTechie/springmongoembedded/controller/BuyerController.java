package com.javaTechie.springmongoembedded.controller;

import com.javaTechie.springmongoembedded.entity.Buyer;
import com.javaTechie.springmongoembedded.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/order-app")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    // generate buyers
    @PostMapping(path = "/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody Buyer buyer){
        if(buyerService.placeOrder(buyer)){
            return new ResponseEntity<>("the order has been created", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("the order cannot be created", HttpStatus.BAD_REQUEST);
        }
    }

    // get all
    @GetMapping(path = "/get-all-buyers/")
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        List<Buyer> buyerList=buyerService.getAllBuyers();
        return new ResponseEntity<>(buyerList,HttpStatus.OK);
    }

    // get-buyers-by-name
    @GetMapping(path = "/get-buyer-by-name/{name}")
    public ResponseEntity<Collection<Buyer>> getBuyersByName(@PathVariable String name){
        Collection<Buyer> buyerList=buyerService.getBuyersBYName(name);
        return new ResponseEntity<>(buyerList,HttpStatus.OK);
    }

    // get-buyer-by-id
    @GetMapping(path = "/get-buyer-by-id/{buyerId}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long buyerId){
        Buyer buyer=buyerService.getBuyerById(buyerId);
        return new ResponseEntity<>(buyer,HttpStatus.OK);
    }

    // get-buyer-by-name
    @GetMapping(path = "/get-buyer-by-address")
    public ResponseEntity<Collection<Buyer>> getBuyerByAddress(@RequestParam String city,@RequestParam String state){
        Collection<Buyer> buyerCollection=buyerService.getBuyerByStateAndCity(city,state);
        return new ResponseEntity<>(buyerCollection,HttpStatus.OK);
    }

    // get-buyer-by-pin-code
    @GetMapping(path = "/get-buyer-by-pin-code")
    public ResponseEntity<Collection<Buyer>> getBuyerByAddress(@RequestParam Integer pinCode){
        Collection<Buyer> buyerCollection=buyerService.getBuyerByPinCode(pinCode);
        return new ResponseEntity<>(buyerCollection,HttpStatus.OK);
    }

    //get-buyer-products
    @GetMapping(path = "/get-buyer-products/{buyerId}")
    public ResponseEntity<Collection<Buyer>>getBuyerProduct(@PathVariable Long buyerId){
        Collection<Buyer> buyerCollection=buyerService.getBuyerProducts(buyerId);
        return new ResponseEntity<>(buyerCollection,HttpStatus.OK);
    }

    //filter-products
    @GetMapping(path = "/filter-products/{price}")
    public ResponseEntity<Collection<Buyer>>getFilteredProducts(@PathVariable Double price) {
        Collection<Buyer> buyerCollection = buyerService.getProductsOnBasesOfMaxPrice(price);
        return new ResponseEntity<>(buyerCollection, HttpStatus.OK);
    }

}
