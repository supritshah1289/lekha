package com.example.springsocial.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "price")
    private Float price;
    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "expired_at")
    private Date expiredAt;

    @Column(name = "status")
    private boolean status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "item_id")
    private List<images> uploads = new ArrayList<>();
}
