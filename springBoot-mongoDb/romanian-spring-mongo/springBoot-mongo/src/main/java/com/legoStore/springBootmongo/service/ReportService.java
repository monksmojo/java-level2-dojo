package com.legoStore.springBootmongo.service;

import com.legoStore.springBootmongo.entity.AvgRatingModel;
import com.legoStore.springBootmongo.entity.LegoModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;


@Service
public class ReportService {
    private MongoTemplate mongoTemplate;

    public ReportService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<AvgRatingModel> avgRatingModeReport(){
        ProjectionOperation projectionOperation=project()
                .andExpression("name").as("productName")
                .andExpression("{$avg:'$reviews.rating'}").as("avgRating");
        Aggregation avgRatingAggregation =newAggregation(LegoModel.class);
        return this.mongoTemplate.aggregate(avgRatingAggregation,LegoModel.class,AvgRatingModel.class)
                .getMappedResults();
    }
}
