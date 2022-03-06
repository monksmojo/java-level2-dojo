package com.practice.javawebservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
@Getter @Setter
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_description")
    private String postDescription;

    @ManyToOne(fetch =FetchType.LAZY )
    @JsonIgnore
    private User user;

    public Posts() {
    }

    public Posts(String postTitle, String postDescription, User user) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", user=" + user +
                '}';
    }
}
