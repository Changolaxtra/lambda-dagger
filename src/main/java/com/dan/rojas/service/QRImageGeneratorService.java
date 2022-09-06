package com.dan.rojas.service;

import com.dan.rojas.exception.GeneratorException;
import com.dan.rojas.service.api.ImageGeneratorService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class QRImageGeneratorService implements ImageGeneratorService {

    @Override
    public BufferedImage generate(String source) throws GeneratorException {
        try {
            final QRCodeWriter barcodeWriter = new QRCodeWriter();
            final BitMatrix bitMatrix = barcodeWriter.encode(source, BarcodeFormat.QR_CODE, 200, 200);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new GeneratorException("Error generating the QR Code Image", e);
        }
    }

}
