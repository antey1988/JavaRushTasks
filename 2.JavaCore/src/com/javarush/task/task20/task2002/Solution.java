package com.javarush.task.task20.task2002;

//import com.javarush.task.task20.task2001.Asset;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("E:\\task2002.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("firstname1");
            user.setLastName("lastname1");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            Thread.sleep(3000);
            user = new User();
            user.setFirstName("firstname2");
            user.setLastName("lastname2");
            user.setBirthDate(new Date());
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
/*private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;*/

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (users.size() > 0) {

                bw.write("yes");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss/SSS");

                for(User u : users) {
                    bw.newLine();
                    bw.write(u.getFirstName());

                    bw.newLine();
                    bw.write(u.getLastName());

                    bw.newLine();
                    Date d = u.getBirthDate();
                    String string = sdf.format(d);
                    /*int year = d.getYear();
                    int month = d.getMonth();
                    int day = d.getDay();
                    int hour = d.getHours();
                    int minuta = d.getMinutes();
                    int second = d.getSeconds();
                    int milisecond = d.;
                    bw.write("" + year + " " + month + " " + day);*/
                    bw.write(sdf.format(d));

                    bw.newLine();
                    bw.write(u.isMale() ? "true" : "false");

                    bw.newLine();
                    bw.write("" + u.getCountry().getDisplayName());
                }

            } else bw.write("no");
            bw.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            if (br.readLine().equals("yes")) {
                List<User> users = new ArrayList<>();
                String string, firstname, lastname;
                Date birthDate;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss/SSS");

                boolean isMale;
                User.Country country;

                while ((string = br.readLine()) != null) {
                    firstname = string;

                    string = br.readLine();
                    lastname = string;

                    string = br.readLine();
                    birthDate = sdf.parse(string);

                    string = br.readLine();
                    isMale = (string.equals("true"));

                    string = br.readLine();
                    country = (string.equals("Ukraine") ? User.Country.UKRAINE : string.equals("Russia") ? User.Country.RUSSIA : User.Country.OTHER);

                    User user = new User();
                    user.setFirstName(firstname);
                    user.setLastName(lastname);
                    user.setBirthDate(birthDate);
                    user.setMale(isMale);
                    user.setCountry(country);
                    users.add(user);
                }
                this.users = users;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
