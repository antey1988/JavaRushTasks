package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException {
        Set<Animal> set = new HashSet<>();
        Path path = Paths.get(pathToAnimals);
        File []files = path.toFile().listFiles();
        MyClassLoader myClassLoader = new MyClassLoader();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            try {
                Class clazz = myClassLoader.loadClass(file.getAbsolutePath());
//                Constructor constructor = clazz.getConstructor();
                set.add((Animal)clazz.newInstance());
            } catch (Exception e) {

            }
        }
        return set;
    }

    public static class MyClassLoader extends ClassLoader {
        public MyClassLoader() {
            super();
        }

        @Override
        public Class findClass(String name) throws ClassNotFoundException {
            byte[]b = loadClassFromFile(name);
            return defineClass(name, b, 0, b.length);
        }

        private byte[]loadClassFromFile(String fileName) {
            InputStream inputStream;
            byte[]buffer;
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;
            try {
                inputStream  = new FileInputStream(fileName);
                while ( (nextValue = inputStream.read()) != -1 ) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer = byteStream.toByteArray();
            return buffer;
        }
    }
}
