package com.javarush.task.task36.task3606;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;
    private Map<String, Class> hiddenClassesMap = new HashMap<>();

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));

    }

    public void scanFileSystem() throws ClassNotFoundException {
        Path path = Paths.get(packageName);
        File[] files = path.toFile().listFiles();
        ClassLoader classLoader = new MyClassLoader(packageName);
        for (File file : files) {
            if (file.getName().endsWith(".class")) {
                String className = file.getName().replace(".class", "");
                Class clazz = classLoader.loadClass(className);
                if (HiddenClass.class.isAssignableFrom(clazz)) {
                    hiddenClasses.add(clazz);
                }
            }
        }
    }

    private static class MyClassLoader extends ClassLoader {
        private final String packageName;

        public MyClassLoader(String packageName) {
            this.packageName = packageName;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Class clazz = null;
            String FileName = packageName + File.separator + name +  ".class";
            File file = new File(FileName);
            byte[] classBytes = new byte[(int)file.length()];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                fis.read(classBytes, 0 , classBytes.length);
                clazz = defineClass(null, classBytes, 0, classBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return clazz;
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for(Class clazz : hiddenClasses) {
            String str = clazz.getSimpleName().toLowerCase();
            if (str.startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
        /*for (Class<?> clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;*/

    }


}

