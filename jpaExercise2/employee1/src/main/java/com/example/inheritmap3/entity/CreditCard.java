package com.example.inheritmap3.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {

    private String cardNumber;

    @OneToMany(mappedBy = "creditCard",cascade = CascadeType.ALL)
    private List<Product> productList;

    public CreditCard(){
        super();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public  void addProduct(Product product){
        if(productList==null){
            productList=new ArrayList<>();
        }

        productList.add(product);
        product.setCreditCard(this);
        this.setProductList(productList);
    }
}
