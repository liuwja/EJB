package com.liuwjg;

import javax.ejb.Remote;

@Remote
public interface IHelloWorld {
    String sayHello(String name);
}
