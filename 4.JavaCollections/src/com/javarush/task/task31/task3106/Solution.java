package com.javarush.task.task31.task3106;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
E:/JavaRush.mp3
E:/JavaRush/test.zip.003
E:/JavaRush/test.zip.001
E:/JavaRush/test.zip.004
E:/JavaRush/test.zip.002

Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String[] ziparhiv = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(ziparhiv);
        List<InputStream> listInputStream = new ArrayList<>(ziparhiv.length);
        for (String partzip : ziparhiv) {
            listInputStream.add(new FileInputStream(partzip));
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(listInputStream));

        try (ZipInputStream zis = new ZipInputStream(sequenceInputStream);
             FileOutputStream fos = new FileOutputStream(filename)) {
            ZipEntry zipEntry = zis.getNextEntry();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
            zis.closeEntry();
        }
    }
}
