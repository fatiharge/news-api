package com.fatiharge.client.rest.newsApiClient;


import com.fatiharge.client.rest.newsApiClient.dto.response.ArticleResponse;
import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "news-api-client")
public interface NewsApiClient {


    @GET
    @Path("/v2/top-headlines")
    @ClientHeaderParam(name = "Authorization", value = "${news.api.apikey}")
    @ClientQueryParam(name = "pageSize", value = "5")
    @ClientQueryParam(name = "page", value = "1")
    ArticleResponse fetchDailyNews(
            @QueryParam("country")
            String country
    );
}
