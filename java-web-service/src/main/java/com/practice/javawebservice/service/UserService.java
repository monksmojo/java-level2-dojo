package com.practice.javawebservice.service;

import com.practice.javawebservice.Repository.PostsRepository;
import com.practice.javawebservice.Repository.UserRepository;
import com.practice.javawebservice.entity.Posts;
import com.practice.javawebservice.entity.User;
import com.practice.javawebservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostsRepository postsRepository;

    public long createUser(User user){
        userRepository.save(user);
        return user.getUserId();
    }

    public List<User> getAllUser(){
        List<User> userList=userRepository.findAll();
        if(userList==null){
            throw new NotFoundException("user list not exist");
        }
        return userList;
    }

    public User getSpecificUser(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        if (user==null){
            throw new NotFoundException("user not found with id--->"+userId);
        }
        return user;
    }

    public Boolean updateUser(User userToUpdate){
        User fetchedUser=userRepository.findById(userToUpdate.getUserId()).orElse(null);
        if(fetchedUser==null){
            throw new NotFoundException("user not found with id-->"+userToUpdate.getUserId());

        }

        if(userToUpdate.getAge()!=null){
            fetchedUser.setAge(userToUpdate.getAge());
        }

        if(userToUpdate.getName()!=null){
            fetchedUser.setName(userToUpdate.getName());
        }

        if(userToUpdate.getLocation()!=null){
            fetchedUser.setLocation(userToUpdate.getLocation());
        }
        userRepository.save(fetchedUser);
        return true;
    }

    // delete a user
    public Boolean deleteUser(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new NotFoundException("user not found with id->"+userId);
        }
        userRepository.delete(user);
        return true;
    }

    // all posts
    public List<Posts> getAllPosts(){
        List<Posts> postsList=postsRepository.findAll();
        if(postsList.size()<=0){
            throw new NotFoundException("there are no post in the databases");
        }
        return postsList;
    }

    // all post of the user
    public List<Posts> postsListOfAUser(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new NotFoundException("use not exist with id->"+userId);
        }
        List<Posts> postsList=user.getPostsList();
        if(postsList==null){
            throw new NotFoundException("User Not Have Any Posts Create One");
        }
        return postsList;
    }

    // specific post
    public Posts specificPost(Long postId){
        Posts post=postsRepository.findById(postId).orElse(null);
        if(post==null){
            throw new NotFoundException("post not exist with id-->"+postId);
        }
        return post;
    }

    // add a post to user with user id
    public Boolean addPost(Posts posts, Long userId){
        User user=userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new NotFoundException("user not found with id"+userId);
        }
        posts.setUser(user);
        postsRepository.save(posts);
        return true;
    }

    // update a post
    public Boolean updatePost(Posts postToUpdate){
        Posts posts=postsRepository.findById(postToUpdate.getPostId()).orElse(null);
        if(posts==null){
            throw new NotFoundException("posts not exist with that postsId"+postToUpdate.getPostId());
        }
        if(postToUpdate.getPostTitle()!=null){
            posts.setPostTitle(postToUpdate.getPostTitle());
        }
        if(postToUpdate.getPostDescription()!=null){
            posts.setPostDescription(postToUpdate.getPostDescription());
        }
        postsRepository.save(posts);
        return true;
    }

    // delete a post
    public Boolean deletePost(Long postId){
        Posts posts=postsRepository.findById(postId).orElse(null);
        if(posts==null){
            throw new NotFoundException("posts not found with id->"+postId);
        }
        postsRepository.delete(posts);
        return true;
    }
}
