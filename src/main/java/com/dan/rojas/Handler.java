package com.dan.rojas;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dan.rojas.dagger.component.DaggerLambdaComponent;
import com.dan.rojas.model.Request;
import com.dan.rojas.model.Response;
import com.dan.rojas.service.api.LambdaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler implements RequestHandler<Request, Response> {

    private final LambdaService<Request, Response> lambdaService;

    public Handler() {
        lambdaService = DaggerLambdaComponent.create().lambdaService();
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        log.info("Dispatching Request {}", request);
        return lambdaService.handleRequest(request);
    }
}
