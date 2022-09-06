package com.dan.rojas.dagger.component;

import com.dan.rojas.dagger.module.UtilsModule;
import com.dan.rojas.dagger.module.BusinessModule;
import com.dan.rojas.model.Request;
import com.dan.rojas.model.Response;
import com.dan.rojas.service.api.LambdaService;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        UtilsModule.class,
        BusinessModule.class})
public interface LambdaComponent {
    LambdaService<Request, Response> lambdaService();
}
