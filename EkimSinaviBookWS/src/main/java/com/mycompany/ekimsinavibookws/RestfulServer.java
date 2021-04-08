package com.mycompany.ekimsinavibookws;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class RestfulServer {

    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(Books.class);

        factoryBean.setResourceProvider(new SingletonResourceProvider(new Books()));

        factoryBean.setAddress("http://localhost:8080/");

        Server server = factoryBean.create();

        server.start();

        while (true) {
        }
    }
}
