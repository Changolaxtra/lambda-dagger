package com.dan.rojas.dagger.module;

import com.dan.rojas.model.Request;
import com.dan.rojas.model.Response;
import com.dan.rojas.service.AvatarLambdaService;
import com.dan.rojas.service.Base64EncoderService;
import com.dan.rojas.service.FakeNameGeneratorService;
import com.dan.rojas.service.QRImageGeneratorService;
import com.dan.rojas.service.api.EncoderService;
import com.dan.rojas.service.api.ImageGeneratorService;
import com.dan.rojas.service.api.LambdaService;
import com.dan.rojas.service.api.NameGeneratorService;
import com.github.javafaker.Faker;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class BusinessModule {

    @Provides
    public ImageGeneratorService imageGeneratorService() {
        return new QRImageGeneratorService();
    }

    @Provides
    @Singleton
    public NameGeneratorService nameGeneratorService(Faker faker) {
        return new FakeNameGeneratorService(faker);
    }

    @Provides
    @Singleton
    public EncoderService publisherService(){
        return new Base64EncoderService();
    }

    @Provides
    @Singleton
    public LambdaService<Request, Response> lambdaService(EncoderService encoderService,
                                                          NameGeneratorService nameGeneratorService,
                                                          ImageGeneratorService imageGeneratorService){
        return new AvatarLambdaService(encoderService, nameGeneratorService, imageGeneratorService);
    }


}
