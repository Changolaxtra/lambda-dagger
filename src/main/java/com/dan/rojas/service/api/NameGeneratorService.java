package com.dan.rojas.service.api;

import com.dan.rojas.exception.GeneratorException;

public interface NameGeneratorService {

    String generate(String name, String genre) throws GeneratorException;
}
