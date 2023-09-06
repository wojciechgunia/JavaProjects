package org.coffeecode.entity;

public class Endpoint
{
    private String url;
    private HttpMethod httpMethod;

    private Role role;

    public Endpoint(String url, HttpMethod httpMethod, Role role)
    {
        this.url = url;
        this.httpMethod = httpMethod;
        this.role = role;
    }

    public Endpoint()
    {
    }

    public String getUrl()
    {
        return url;
    }

    public HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public Role getRole()
    {
        return role;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setHttpMethod(HttpMethod httpMethod)
    {
        this.httpMethod = httpMethod;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
