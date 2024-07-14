package org.acme.contract.service;

import org.acme.response.HandlerResponse;

public interface HelloWorldServiceInterface {

    HandlerResponse helloWorld();

    HandlerResponse helloWorld(String language);

}
