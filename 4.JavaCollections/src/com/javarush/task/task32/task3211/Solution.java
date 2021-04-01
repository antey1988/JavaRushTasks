package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
//                                               5a47d12a2e3f9fecf2d9ba1fd98152eb

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] sms = byteArrayOutputStream.toByteArray();
        byte[] code = messageDigest.digest(sms);

        StringBuilder sb = new StringBuilder("");
        for (byte b : code) {
            sb = sb.append(String.format("%02x", b));
//            System.out.println(sb);
            /*System.out.print(b + " ");
            System.out.print(Byte.toUnsignedInt(b) + " ");
            System.out.println(String.format("%02x", b));*/
        }
        //System.out.println(sb.toString());
        return md5.equals(sb.toString());
    }
}
