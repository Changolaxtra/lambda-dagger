package com.dan.rojas.service.api;

import com.dan.rojas.exception.GeneratorException;

import java.awt.image.BufferedImage;

public interface EncoderService {

    String encode(BufferedImage image) throws GeneratorException;
}
