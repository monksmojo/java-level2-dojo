package com.javaTechie.springmongoembedded.repository;

import com.javaTechie.springmongoembedded.entity.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer,Long> {

    Buyer findByBuyerId(Long id);

    Collection<Buyer> findByNameContaining(String name);

    @Query(value = "{'address.city':?0.'address.state':?1}")
    Collection<Buyer> findByCityAndState(String city,String state);


    @Query(value = "{'address.pinCode':?0}")
    Collection<Buyer> findByPinCode(Integer pinCode);

    @Query(value = "{'buyerId' : ?0}",
            fields = "{ 'productList.name' : 1, 'productList.price' : 1, 'productList.quantity' : 1}")
    Collection<Buyer> findBuyersProducts(Long id);

    @Query(value = "{'productList.price' : { '$lte' : ?0 }}",
            fields = "{ 'productList.name' : 1, 'productList.price' : 1, 'productList.quantity' : 1}")
    Collection<Buyer> findByPriceFiler(Double price);
}
