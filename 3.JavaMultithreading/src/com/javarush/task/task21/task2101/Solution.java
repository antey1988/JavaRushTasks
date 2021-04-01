package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
//        System.out.println((byte) (127 & 255));
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte [] netAddress = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        StringBuilder stringBuilder1 = new StringBuilder("");

        String [] liderZero = new String[] {"00000000", "0000000", "000000", "00000", "0000", "000", "00", "0", ""};
        for (byte b : bytes) {
            int a = (b < 0 ? 256 + b : b);
//            if (!stringBuilder.equals(""))
            StringBuilder stringBuilder2 = new StringBuilder("");
            stringBuilder2.append(Integer.toBinaryString(a));
            String str = liderZero[stringBuilder2.length()];
            stringBuilder2.insert(0,liderZero[stringBuilder2.length()]);
            stringBuilder1.append(" ");
            stringBuilder1.append(stringBuilder2);
        }
        System.out.println(stringBuilder1.substring(1));
    }
}
