package com.algo.c3g2.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by Miracle Luna on 2019/11/18
 */
public class MD5 {


    public static String md5(String data) {
        try {
            byte[] md5 = md5(data.getBytes("utf-8"));
            return toHexString(md5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static byte[] md5(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }


    private static String toHexString(byte[] md5) {
        StringBuilder sb = new StringBuilder();
        System.out.println("md5.length: " + md5.length);
        for (byte b : md5) {
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String password = "password";
        String md5HexStr = md5(password);
        System.out.println("==> MD5 加密前: " + password);
        System.out.println("==> MD5 加密后: " + md5HexStr);
    }
}