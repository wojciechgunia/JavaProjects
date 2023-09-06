package com.example.gateway.filter;

import org.coffeecode.entity.Endpoint;
import org.coffeecode.entity.HttpMethod;
import org.coffeecode.entity.Role;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Component
public class RouteValidator
{
    public Set<Endpoint> openApiEndpoints = new HashSet<>(List.of(
            new Endpoint("/auth/logout", HttpMethod.GET, Role.GUEST),
            new Endpoint("/auth/register", HttpMethod.POST, Role.GUEST),
            new Endpoint("/auth/login", HttpMethod.POST, Role.GUEST),
            new Endpoint("/auth/validate", HttpMethod.GET, Role.GUEST),
            new Endpoint("/auth/activate", HttpMethod.GET, Role.GUEST),
            new Endpoint("/auth/authorize", HttpMethod.GET, Role.GUEST),
            new Endpoint("/auth/reset-password", HttpMethod.PATCH, Role.GUEST),
            new Endpoint("/auth/reset-password", HttpMethod.POST, Role.GUEST),
            new Endpoint("/api/v1/gateway", HttpMethod.POST, Role.GUEST),
            new Endpoint("/auth/auto-login", HttpMethod.GET, Role.GUEST),
            new Endpoint("/auth/logged-in", HttpMethod.GET, Role.GUEST)
        )
    );

    private Set<Endpoint> adminEndpoints = new HashSet<>();

    public void addEndpoints(List<Endpoint> endpoints)
    {
        for (Endpoint endpoint: endpoints)
        {
            if (endpoint.getRole().name().equals(Role.ADMIN.name()))
            {
                adminEndpoints.add(endpoint);
            }
            if (endpoint.getRole().name().equals(Role.GUEST.name()))
            {
                openApiEndpoints.add(endpoint);
            }
        }
        adminEndpoints.forEach(value->{
            System.out.println(value.getUrl());
            System.out.println(value.getHttpMethod());
        });
    }

    public Predicate<ServerHttpRequest> isAdmin =
            request-> adminEndpoints
                    .stream().anyMatch(value->request.getURI().getPath()
                            .contains(value.getUrl()) && request.getMethod().name().equals(value.getHttpMethod().name()));
    public Predicate<ServerHttpRequest> isSecure =
            request-> openApiEndpoints
                    .stream().noneMatch(value->request.getURI().getPath()
                            .contains(value.getUrl()) && request.getMethod().name().equals(value.getHttpMethod().name()));
}
