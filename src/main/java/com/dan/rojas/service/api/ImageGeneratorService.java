package com.dan.rojas.service.api;

import com.dan.rojas.exception.GeneratorException;

import java.awt.image.BufferedImage;

public interface ImageGeneratorService {

    BufferedImage generate(String source) throws GeneratorException;

}
