package com.fatiharge.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
public class ApiKeyFilter implements ContainerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-KEY";

    @ConfigProperty(name = "news.api.key")
    String validApiKey;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String apiKey = requestContext.getHeaderString(API_KEY_HEADER);
        if (apiKey == null || !apiKey.equals(validApiKey)) {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity("Access forbidden: Invalid API Key")
                    .build());
        }
    }
}
