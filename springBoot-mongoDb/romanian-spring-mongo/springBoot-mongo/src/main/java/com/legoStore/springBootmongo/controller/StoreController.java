package com.legoStore.springBootmongo.controller;


import com.legoStore.springBootmongo.entity.AvgRatingModel;
import com.legoStore.springBootmongo.entity.LegoModel;
import com.legoStore.springBootmongo.repository.LegoModelRepository;
import com.legoStore.springBootmongo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/ls")
public class StoreController {

    @Autowired
    ReportService reportService;

    // creating a dataMember of mongoTemplateDeleteModel
    private final MongoTemplate mongoTemplate;

    // constructor injection of the mongoTemplate
    public StoreController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    // autoInjection of mongoRepository
    @Autowired
    LegoModelRepository legoModelRepository;

    @PostMapping(path = "/insert-model")
    public ResponseEntity<String> insertModel(@RequestBody LegoModel legoModel){
        this.mongoTemplate.insert(legoModel);
        return new ResponseEntity<>("the model has been inserted",HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-all-model")
    public ResponseEntity<Collection<LegoModel>> getAllModel(){
        Collection<LegoModel> legoModels=this.mongoTemplate.findAll(LegoModel.class);
        return new ResponseEntity<>(legoModels,HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-model-sorted")
    public ResponseEntity<Collection<LegoModel>> getAllModelSorted(){
        Sort sortByNameAsc=Sort.by("name").ascending();
        // sort is a factory method
        Collection<LegoModel> legoModels=legoModelRepository.findAll(sortByNameAsc);
        return new ResponseEntity<>(legoModels,HttpStatus.OK);
    }


    @PutMapping(path = "/update-model-name/{modelId}")
    public ResponseEntity<LegoModel>updateModel(@PathVariable Object modelId,@RequestParam String legoSetName){
        LegoModel legoModel1=this.mongoTemplate.findById(modelId,LegoModel.class);
        assert legoModel1 != null;
        legoModel1.setName(legoSetName);
        mongoTemplate.save(legoModel1);
        return new ResponseEntity<>(legoModel1,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-model/{id}")
    public ResponseEntity<String>deleteModel(@PathVariable String id){
        this.mongoTemplate.remove(new Query(Criteria.where("id").is(id)),LegoModel.class);
        return new ResponseEntity<>("the model is removed",HttpStatus.GONE);
    }

    @GetMapping(path = "get-model/{id}")
    public ResponseEntity<Object>getModelById(@PathVariable String id){
        LegoModel legoModel=legoModelRepository.findById(id).orElse(null);
        if(legoModel==null){
            return new ResponseEntity<>("the model not found with id->"+id,HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(legoModel,HttpStatus.OK);
        }
    }

    @GetMapping(path = "/models-by-theme/{theme}")
    public ResponseEntity<Collection<Object>>getModelsByTheme(@PathVariable String theme){
        Sort sortAsc=Sort.by("theme").ascending();
        Collection<LegoModel> legoModels=legoModelRepository.findAllByThemeContains(theme,sortAsc);
        return new ResponseEntity(legoModels,HttpStatus.OK);
    }

    @GetMapping(path = "/models-by-difficulty")
    public ResponseEntity<Collection<LegoModel>>getModelByDifficulty(@RequestParam String difficultyMode,@RequestParam String name){
        Collection<LegoModel> legoModels=legoModelRepository.findAllByDifficultyModeAndNameStartsWith(difficultyMode,name);
        return new ResponseEntity<>(legoModels,HttpStatus.OK);
    }

    @GetMapping(path = "/models-by-deliveryFee")
    public ResponseEntity<Collection<LegoModel>>getModelByDeliveryFee(@RequestParam Double deliveryFee){
        Collection<LegoModel> legoModels=legoModelRepository.findAllByDeliveryFee(deliveryFee);
        return new ResponseEntity<>(legoModels,HttpStatus.OK);
    }

    @GetMapping(path = "/models-by-greatRating")
    public ResponseEntity<Collection<LegoModel>>getModelByGreatRating(@RequestParam Double rating){
        Collection<LegoModel> legoModels=legoModelRepository.findAllByGreatRating(rating);
        return new ResponseEntity<>(legoModels,HttpStatus.OK);
    }

    @DeleteMapping(path = "delete-model-by-id/{id}")
    public ResponseEntity<String>deleteModelById(@PathVariable String id){
        legoModelRepository.deleteById(id);
        return new ResponseEntity<>("model deleted with id->"+id,HttpStatus.GONE);
    }

    // data projection using mongoTemplate from mongoDB document
    @GetMapping("/generate-report")
    public List<AvgRatingModel> generateReport(){
        return reportService.avgRatingModeReport();
    }

    @GetMapping("/model-searching/{name}")
    public Collection<LegoModel> modelsSearch(@PathVariable String name){
        TextCriteria textCriteria=TextCriteria.forDefaultLanguage().matchingPhrase(String.valueOf(name)).matching(String.valueOf(name));
        Collection<LegoModel> legoModels=legoModelRepository.findAllBy(textCriteria);
        System.out.println(legoModels);
        return legoModels;
    }
}
