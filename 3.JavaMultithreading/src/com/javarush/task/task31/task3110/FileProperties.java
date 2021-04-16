package com.javarush.task.task31.task3110;

import java.io.File;

public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(name);
        /*if (size > 0) {
            double sizeKb = size;
            String sizeUnit = "b";
            double compressedSizeKb = compressedSize;
            String compressedSizeUnit = "b";
            if (size > 1023) {
                sizeKb = sizeKb / 1024;
                sizeUnit = "Kb";
                if (compressedSize > 1023) {
                    compressedSizeKb = compressedSizeKb / 1024;
                    compressedSizeUnit = "Kb";
                }
            }
            builder.append(String.format("\t%.2f %s (%.2f %s) сжатие: %d%%",
                    sizeKb, sizeUnit, compressedSizeKb, compressedSizeUnit, getCompressionRatio()));
        }*/
        if (size > 0) {
            builder.append("\t");
            builder.append(size / 1024);
            builder.append(" Kb (");
            builder.append(compressedSize / 1024);
            builder.append(" Kb) сжатие: ");
            builder.append(getCompressionRatio());
            builder.append("%");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FileProperties("Name", 8192, 2048, 2).toString());
    }
}
