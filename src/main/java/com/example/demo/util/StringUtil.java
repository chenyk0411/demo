package com.example.demo.util;

import java.security.MessageDigest;

public class StringUtil {
    public static char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };

    /**
     * MD5加密字符串
     * @param source
     * @return
     */
    public static String getND5(String source){
        try{
            MessageDigest messageDigest =MessageDigest.getInstance("MD5");

            byte[] sourceByte = source.getBytes();
            messageDigest.update(sourceByte);
            byte[] resultByte = messageDigest.digest();

            return byteArrayToHex(resultByte);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static String byteArrayToHex(byte[] byteArray) {
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去

        int index = 0;
        for(int i=0;i<byteArray.length;i++){
            byte b = byteArray[i];

            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }

        // 字符数组组合成字符串返回

        return new String(resultCharArray);
    }

    public static boolean isBlank(String str){
        return str == null || "".equals(str);
    }
    public static boolean isNotBlank(String str){
        return !isNotBlank(str);
    }
}
