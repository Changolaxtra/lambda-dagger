package com.dan.rojas.service.api;

public interface LambdaService<I,O> {
    O handleRequest(I request);
}
