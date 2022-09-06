package com.dan.rojas.service;

import com.dan.rojas.exception.GeneratorException;
import com.dan.rojas.model.Category;
import com.dan.rojas.service.api.NameGeneratorService;
import com.github.javafaker.Faker;

import javax.inject.Inject;

public class FakeNameGeneratorService implements NameGeneratorService {

    private static final String TEMPLATE = "%s-%s";
    private static final String SPACE = " ";
    private static final String JOINER = "-";
    private final Faker faker;

    @Inject
    public FakeNameGeneratorService(Faker faker) {
        this.faker = faker;
    }

    @Override
    public String generate(String name, String genre) throws GeneratorException {
        try {
            final Category category = Category.valueOf(genre.toUpperCase());
            return format(name, getSuffix(category));
        } catch (IllegalArgumentException e) {
            throw new GeneratorException("Invalid category " + genre, e);
        }
    }

    private String getSuffix(Category category){
        String suffix = "";
        switch (category) {
            case ANIMAL:
                suffix = faker.animal().name();
                break;
            case DRAGON:
                suffix = faker.dragonBall().character();
                break;
            case FOOD:
                suffix = faker.food().dish();
                break;
            case FUNNY:
                suffix = faker.funnyName().name();
                break;
        }
        return suffix;
    }

    private String format(final String name, final String suffix){
        return String.format(TEMPLATE, name, suffix.toLowerCase().replace(SPACE, JOINER));
    }

}
