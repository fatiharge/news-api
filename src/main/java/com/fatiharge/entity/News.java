package com.fatiharge.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "new")
public class News extends PanacheEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    public Date createdDate;
    public String author;
    public String title;
    @Column(length = 2048)
    public String description;
    @Column(length = 512)
    public String url;
    @Column(length = 512)
    public String urlToImage;
    public String publishedAt;
    @Column(length = 2048)
    public String content;
    public String sourceId;
    public String name;
}

