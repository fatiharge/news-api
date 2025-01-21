package com.fatiharge.mapper;

import com.fatiharge.client.rest.newsApiClient.dto.Article;
import com.fatiharge.dto.getNewsResponse.GetNewsData;
import com.fatiharge.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface NewsMapper {
    @Mapping(target = "author", source = "article.author")
    @Mapping(target = "title", source = "article.title")
    @Mapping(target = "description", source = "article.description")
    @Mapping(target = "url", source = "article.url")
    @Mapping(target = "urlToImage", source = "article.urlToImage")
    @Mapping(target = "publishedAt", source = "article.publishedAt")
    @Mapping(target = "content", source = "article.content")
    @Mapping(target = "sourceId", source = "article.source.id")
    @Mapping(target = "name", source = "article.source.name")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    News newsFromApiResponse(Article article);

    @Mapping(target = "author", source = "news.author")
    @Mapping(target = "title", source = "news.title")
    @Mapping(target = "description", source = "news.description")
    @Mapping(target = "url", source = "news.url")
    @Mapping(target = "urlToImage", source = "news.urlToImage")
    @Mapping(target = "publishedAt", source = "news.publishedAt")
    @Mapping(target = "content", source = "news.content")
    @Mapping(target = "sourceId", source = "news.sourceId")
    @Mapping(target = "name", source = "news.name")
    GetNewsData getGetNewsDataFromNews(News news);
}
