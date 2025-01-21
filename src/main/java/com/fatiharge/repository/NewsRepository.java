package com.fatiharge.repository;

import com.fatiharge.entity.News;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class NewsRepository implements PanacheRepository<News> {


}
