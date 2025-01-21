package com.fatiharge.resource;

import com.fatiharge.dto.getNewsResponse.GetNewsResponse;
import com.fatiharge.service.NewsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import java.util.Date;


@Path("news")
public class NewsResource {

    @Inject
    NewsService newsService;

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get Hello Message", description = "Returns a simple hello message")
    public String hello(
            @SuppressWarnings("unused")
            @HeaderParam("X-API-KEY")
            @Parameter(description = "API Key for authentication")
            String apiKey,
            @SuppressWarnings("unused")
            @HeaderParam("User-Agent")
            @Parameter(description = "The User-Agent header of the request")
            String userAgent
    ) {
        Date d = new Date();
        return "Hello from fatiharge api!\nTime: " + d;
    }

    @GET
    @Operation(summary = "Get Paginated News",
            description = "Fetches a paginated list of news articles. The request accepts page and size parameters to control the pagination. By default, the first page with 5 items will be returned. The page parameter starts from 1.")
    @Parameter(name = "page",
            description = "The page number to fetch, starting from 1. Defaults to 1 if not provided.",
            schema = @Schema(type = SchemaType.INTEGER, defaultValue = "1"))
    @Parameter(name = "size",
            description = "The number of news articles per page. Defaults to 5 if not provided.",
            schema = @Schema(type = SchemaType.INTEGER, defaultValue = "5"))
    public GetNewsResponse getNews(
            @QueryParam("page")
            @DefaultValue("1")
            int page,
            @QueryParam("size")
            @DefaultValue("5")
            int size,
            @SuppressWarnings("unused")
            @HeaderParam("X-API-KEY")
            @Parameter(description = "API Key for authentication")
            String apiKey,
            @SuppressWarnings("unused")
            @HeaderParam("User-Agent")
            @Parameter(description = "The User-Agent header of the request")
            String userAgent
    ) {
        return newsService.getNews(page, size);
    }
}
