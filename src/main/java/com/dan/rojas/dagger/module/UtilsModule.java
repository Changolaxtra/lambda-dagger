package com.dan.rojas.dagger.module;

import com.github.javafaker.Faker;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    public Faker faker() {
        return Faker.instance();
    }
}
