package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
task3105_arhiv
/home/oleg/Документы/task3105/task3105_arhiv.zip
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> zipfiles = new HashMap<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1])))
        {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte [] buffer = new byte[1024];
                int i;
                while ((i = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0 , i);
                }
                zipfiles.put(zipEntry.getName(), baos);
                zis.closeEntry();
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]));)
        {
            Path path = Paths.get(args[0]);
            String FullName = "new/" + path.getFileName();
            zos.putNextEntry(new ZipEntry(FullName));
            Files.copy(path, zos);
            zos.closeEntry();

            for(Map.Entry<String, ByteArrayOutputStream> entry : zipfiles.entrySet()) {
                if (!(entry.getKey().equalsIgnoreCase(FullName))) {
                    zos.putNextEntry(new ZipEntry(entry.getKey()));
                    zos.write(entry.getValue().toByteArray());
                    zos.closeEntry();
                }
            }
        }

    }

}
