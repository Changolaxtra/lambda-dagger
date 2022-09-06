package com.dan.rojas.service;

import com.dan.rojas.exception.GeneratorException;
import com.dan.rojas.model.Request;
import com.dan.rojas.model.Response;
import com.dan.rojas.service.api.EncoderService;
import com.dan.rojas.service.api.ImageGeneratorService;
import com.dan.rojas.service.api.LambdaService;
import com.dan.rojas.service.api.NameGeneratorService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.awt.image.BufferedImage;

@Slf4j
public class AvatarLambdaService implements LambdaService<Request, Response> {

    private final EncoderService encoderService;
    private final NameGeneratorService nameGeneratorService;
    private final ImageGeneratorService imageGeneratorService;

    @Inject
    public AvatarLambdaService(final EncoderService encoderService,
                               final NameGeneratorService nameGeneratorService,
                               final ImageGeneratorService imageGeneratorService) {
        this.encoderService = encoderService;
        this.nameGeneratorService = nameGeneratorService;
        this.imageGeneratorService = imageGeneratorService;
    }

    @Override
    public Response handleRequest(Request request) {
        final Response.ResponseBuilder builder = Response.builder();
        try {
            final String generatedName = nameGeneratorService.generate(request.getName(), request.getCategory());
            final BufferedImage image = imageGeneratorService.generate(generatedName);
            final String encodedImage = encoderService.encode(image);
            builder.avatarName(generatedName).encodedImage(encodedImage);
        } catch (GeneratorException e) {
            log.error("Error generating avatar name.", e);
            builder.error(e.getMessage());
        }

        return builder.build();
    }

}
