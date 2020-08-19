package com.synergix.controller;

import com.synergix.service.HelloService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean {

    @ManagedProperty(value = "#{helloService}")
    HelloService helloService;

    private String name;

    public String sayHello() {
        this.name = helloService.convert(this.name);
        System.out.println("say hello name: " + this.name);
        return "hello";
    }

    public String getName() {
        System.out.println("get name: " + this.name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set name: " + this.name);
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }


}