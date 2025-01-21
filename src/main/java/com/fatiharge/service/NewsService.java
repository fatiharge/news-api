package com.fatiharge.service;

import com.fatiharge.client.rest.newsApiClient.NewsApiClient;
import com.fatiharge.client.rest.newsApiClient.dto.response.ArticleResponse;
import com.fatiharge.dto.getNewsResponse.GetNewsData;
import com.fatiharge.dto.getNewsResponse.GetNewsResponse;
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

    public GetNewsResponse getNews(
            int page,
            int size
    ) {
        List<News> pagedNews = newsRepository.findPagedAndSortedNews(page, size);

        List<GetNewsData> newsDTOList = pagedNews.stream()
                .map(news -> newsMapper.getGetNewsDataFromNews(news))
                .toList();

        return new GetNewsResponse(newsDTOList);
    }
}
