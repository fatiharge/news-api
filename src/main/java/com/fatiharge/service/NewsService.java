package com.fatiharge.service;

import com.fatiharge.client.rest.newsApiClient.NewsApiClient;
import com.fatiharge.client.rest.newsApiClient.dto.response.ArticleResponse;
import com.fatiharge.entity.News;
import com.fatiharge.mapper.NewsMapper;
import com.fatiharge.repository.NewsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class NewsService {
    @RestClient
    @Inject
    NewsApiClient newsApiClient;

    @Inject
    NewsRepository newsRepository;
    @Inject
    NewsMapper newsMapper;

    @Transactional
    public void fetchDailyNews(String country) {
        ArticleResponse response = newsApiClient.fetchDailyNews(country);
        List<News> newsList = response.articles.stream()
                .map(article -> newsMapper.newsFromApiResponse(article))
                .toList();

        newsRepository.persist(newsList);
    }

}




