package com.liuwjg;

import javax.ejb.Stateless;

@Stateless(name = "HelloWorldEJB")
public class HelloWorldBean implements IHelloWorld{
    public HelloWorldBean() {
    }

    @Override
    public String sayHello(String name) {
        return "你好！"+name;
    }
}
