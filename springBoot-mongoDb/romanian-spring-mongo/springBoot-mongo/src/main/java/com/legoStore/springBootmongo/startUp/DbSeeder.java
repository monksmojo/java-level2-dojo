package com.legoStore.springBootmongo.startUp;

import com.legoStore.springBootmongo.entity.DeliveryInfo;
import com.legoStore.springBootmongo.entity.Difficulty;
import com.legoStore.springBootmongo.entity.LegoModel;
import com.legoStore.springBootmongo.entity.ProductReview;
import com.legoStore.springBootmongo.repository.LegoModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;


public class DbSeeder implements CommandLineRunner {

    // making a MongoTemplate data members
    private MongoTemplate mongoTemplate;

    @Autowired
    LegoModelRepository legoModelRepository;

    // doing constructor injection
    public DbSeeder(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {


        // removing all the documents inside a collection
        this.mongoTemplate.dropCollection(LegoModel.class);

        LegoModel falcon=new LegoModel(
                "millennium falcon",
                Difficulty.MEDIUM,
                "Star Wars",
                new DeliveryInfo(LocalDate.now(),30.00,true),
                Arrays.asList(
                        new ProductReview("dan",7.0),
                        new ProductReview("nate",9.0),
                        new ProductReview("powder",8.5)
                )
        );

        LegoModel mcSenna=new LegoModel(
                "mcSenna burger",
                Difficulty.EASY,
                "Fast Food",
                new DeliveryInfo(LocalDate.now(),8.00,false),
                Arrays.asList(
                        new ProductReview("peter",6.0),
                        new ProductReview("pan",8.0),
                        new ProductReview("berlin",8.5)
                )
        );

        LegoModel skyPolice=new LegoModel(
                "skyPolice Air Base",
                Difficulty.HARD,
                "Space City",
                new DeliveryInfo(LocalDate.now(),300.00,true),
                Arrays.asList(
                        new ProductReview("gibson",9.0),
                        new ProductReview("nate",9.5),
                        new ProductReview("powder",8.5)
                )
        );

        LegoModel gothamCity=new LegoModel(
                "Gotham City",
                Difficulty.HARD,
                "Crime City",
                new DeliveryInfo(LocalDate.now(),300.00,true),
                Arrays.asList(
                        new ProductReview("jagger",9.0),
                        new ProductReview("starlin",9.5),
                        new ProductReview("mink",8.5)
                )
        );

        // crating the collection of the models as initialModel
        Collection<LegoModel> initialModels=new HashSet<LegoModel>();
        initialModels.add(falcon);
        initialModels.add(mcSenna);
        initialModels.add(skyPolice);
        initialModels.add(gothamCity);

        //pre-populating the database
        legoModelRepository.insert(initialModels);
        System.out.println("models added");
    }
}
