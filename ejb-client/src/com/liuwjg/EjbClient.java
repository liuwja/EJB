package com.liuwjg;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbClient {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
        pro.setProperty("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
        pro.setProperty("java.naming.provider.url","127.0.0.1");

        try {
            InitialContext ctx = new InitialContext(pro);
            System.out.println(ctx.getClass().getName());
             IHelloWorld helloWorld = (IHelloWorld) ctx.lookup("HelloWorldEJB/remote");
            System.out.println(helloWorld.getClass().getName());
            System.out.println(helloWorld.sayHello("liuwjg"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
