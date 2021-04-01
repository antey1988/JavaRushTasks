package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes typeReader) {
        if (typeReader == ImageTypes.BMP) return new BmpReader();
        if (typeReader == ImageTypes.JPG) return new JpgReader();
        if (typeReader == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
