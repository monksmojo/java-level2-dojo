package com.practice.javawebservice.controller;

import com.practice.javawebservice.entity.Posts;
import com.practice.javawebservice.entity.User;
import com.practice.javawebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserPostController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/get-all-user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList=userService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/get-user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        User user=userService.getSpecificUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path="/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        Long insertedUserId=userService.createUser(user);
        if(insertedUserId>0){
            return new ResponseEntity<>("user created",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("user not created",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(path = "/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        if(userService.updateUser(user)){
            return new ResponseEntity<>("user updated",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("user not created",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //delete a user
    @DeleteMapping(path = "/delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>("user deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("user not deleted",HttpStatus.BAD_REQUEST);
        }
    }

    ///////////////////////////////// POST URI //////////////////////////////////

    // all posts
    @GetMapping(path = "/see-posts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        return new ResponseEntity<>(userService.getAllPosts(),HttpStatus.OK);
    }

    // all post of the user
    @GetMapping(path = "/{userId}/my-posts")
    ResponseEntity<List<Posts>> postsListOfAUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.postsListOfAUser(userId),HttpStatus.OK);
    }

    // specific post
    @GetMapping(path = "/a-post/{postId}")
    ResponseEntity<Posts> specificPost(@PathVariable Long postId){
        return new ResponseEntity<>(userService.specificPost(postId),HttpStatus.OK);
    }

    // add a post
    @PostMapping(path = "/{userId}/add-post")
    ResponseEntity<String> addPost(@RequestBody Posts posts,@PathVariable Long userId){
        if(userService.addPost(posts,userId)){
            return new ResponseEntity<>("post have been added",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("post can't be created",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // update a post
    @PutMapping(path = "/update-post")
    ResponseEntity<String> updatePost(@RequestBody Posts posts){
        if(userService.updatePost(posts)){
            return new ResponseEntity<>("post have been updated",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("post can't be updated",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //delete a post
    @DeleteMapping(path = "/delete-post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
        if(userService.deletePost(postId)){
            return new ResponseEntity<>("post deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("post not deleted",HttpStatus.BAD_REQUEST);
        }
    }
}
