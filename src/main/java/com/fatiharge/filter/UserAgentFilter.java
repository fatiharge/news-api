package com.fatiharge.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
public class UserAgentFilter implements ContainerRequestFilter {


    private static final String USER_AGENT = "User-Agent";

    @ConfigProperty(name = "news.api.user.agent")
    String validUserAgent;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String userAgent = requestContext.getHeaderString(USER_AGENT);
        if (userAgent == null || !userAgent.contains(validUserAgent)) {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity("Access forbidden: Invalid User-Agent")
                    .build());
        }
    }
}

