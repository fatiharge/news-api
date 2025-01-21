package com.fatiharge.resource;

import com.fatiharge.service.NewsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;


@Path("news")
public class NewsResource {

    @Inject
    NewsService newsService;

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get Hello Message", description = "Returns a simple hello message")
    public String hello(
    ) {
        return "Hello from fatiharge api!";
    }
}
