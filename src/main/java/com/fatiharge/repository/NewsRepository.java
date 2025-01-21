package com.fatiharge.repository;

import com.fatiharge.entity.News;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class NewsRepository implements PanacheRepository<News> {
    public List<News> findPagedAndSortedNews(
            int page,
            int size
    ) {
        return find("ORDER BY id DESC").page(page - 1, size).list();
    }
}
