package com.legoStore.springBootmongo.repository;

import com.legoStore.springBootmongo.entity.LegoModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LegoModelRepository extends MongoRepository<LegoModel,String> {
    Collection<LegoModel> findAllByThemeContains(String theme, Sort sort);

    Collection<LegoModel> findAllByDifficultyModeAndNameStartsWith(String difficultyMode,String name);

    Collection<LegoModel> findAllBy(TextCriteria textCriteria);

    @Query("{'deliveryInfo.deliveryFee':{$lte:?0}}")
    Collection<LegoModel> findAllByDeliveryFee(Double deliveryFee);

    @Query("{'productReviews.rating':{$gte:?0}}")
    Collection<LegoModel> findAllByGreatRating(Double rating);
}