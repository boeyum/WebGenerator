package no.jib.lagpagegenerator.helpers;
/************************************************************************
 ** Copyright (c) JIB 2024 -                                           **
 **                                                                    **
 ** This source is licensed under :                                    **
 **                                                                    **
 **                   GNU GENERAL PUBLIC LICENSE                       **
 **                    Version 3, 29 June 2007                         **
 **                                                                    **
 **            Copyright (C) 2007 Free Software Foundation,            **
 **                    Inc. <https://fsf.org/>                         **
 **                                                                    **
 ** Complete license descriptiom at:                                   **
 **             <https://www.gnu.org/licenses/gpl-3.0.txt>             **
 **                                                                    **
 ************************************************************************/

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;import java.awt.image.BufferedImage;

public class ImageHandler {

    BufferedImage resizeImageByHeight(BufferedImage originalImage, int targetHeight) throws Exception {
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();
        float exp = (height / targetHeight);
        int targetWidth = Math.round(width / exp);
        return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
    }

    BufferedImage resizeImageByWidth(BufferedImage originalImage, int targetWidth) throws Exception {
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();
        float exp = (width / targetWidth);
        int targetHeight = Math.round(height / exp);
        return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
    }

    public boolean isPng(String path) {
        if(path.contains(".png")) {
            return true;
        }
        return false;
    }
    public boolean moveImage(String source, String destination) {
        try {
            Path temp = Files.copy(Paths.get(source), Paths.get(destination));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public BufferedImage readImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    public void writeImage(BufferedImage bi, String path) throws IOException {
        if (path.contains(".jpg") || path.contains(".jpeg")) {
            ImageIO.write(bi, "jpeg", new File(path));
        } else if (path.contains(".JPG") || path.contains(".JPEG")) {
            ImageIO.write(bi, "jpeg", new File(path));
        } else {
            ImageIO.write(bi, "png", new File(path));
        }
    }
}
