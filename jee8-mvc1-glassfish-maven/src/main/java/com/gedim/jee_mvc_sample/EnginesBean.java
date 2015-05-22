package com.gedim.jee_mvc_sample;

import com.oracle.ozark.engine.FaceletsViewEngine;
import com.oracle.ozark.engine.JspViewEngine;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("engines")
public class EnginesBean {

    @Inject
    Models models;

    @GET
    @Controller
    public Viewable hello(@QueryParam("name") String message,
            @QueryParam("engine") String engine) {
        models.put("name", message);
        if (null != engine) switch (engine) {
            // there is no point in specifying the view engines below since the api 
            // would be able to find one automatically. it only serves demonstration purposes.
            case "jsf":
                return new Viewable("/engine.xhtml", models, FaceletsViewEngine.class);
            case "jsp":
                return new Viewable("/engine.jsp", models, JspViewEngine.class);
        }
        return new Viewable("/engine.jsp");
    }
}
