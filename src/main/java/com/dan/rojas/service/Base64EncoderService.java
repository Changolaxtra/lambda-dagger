package com.dan.rojas.service;

import com.dan.rojas.exception.GeneratorException;
import com.dan.rojas.service.api.EncoderService;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
public class Base64EncoderService implements EncoderService {

    private static final String PNG = "png";

    @Override
    public String encode(BufferedImage image) throws GeneratorException {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, PNG, os);
            return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (IOException e) {
            log.error("Error encoding image.", e);
            throw new GeneratorException("Error encoding image.", e);
        }
    }
}
