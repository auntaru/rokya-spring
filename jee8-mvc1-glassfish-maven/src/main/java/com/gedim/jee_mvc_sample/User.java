package com.gedim.jee_mvc_sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class User {
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
