package com.gedim.jee_mvc_sample;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public class HelloBean {

    @Inject
    User user;
    
    @GET
    @Controller
    public String hello(@QueryParam("name") String name) {
        if (name != null && !name.isEmpty()) {
            user.setName(name);
            return "/hello.jsp";
        } else {
            return "/error.jsp";
        }
    }
}
