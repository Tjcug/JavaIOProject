package com.basic.io;

import java.io.UnsupportedEncodingException;

/**
 * Created by dell-pc on 2016/5/25.
 */
public class EncodeDemo {
    private static String str="慕课ABC";

    public static void main(String[] args) throws UnsupportedEncodingException {
        //idea 默认是utf-8 的编码。utf-8编码中文默认占用3个字节，英文占用1一个字节
        byte[] bytes1=str.getBytes();
        for(byte b:bytes1){
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();

        //gbk编码中文默认占用2个字节，英文占用1个字节
        byte[] bytes2=str.getBytes("gbk");
        for(byte b:bytes2){
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();

        //utf-16be编码中文默认占用2个字节，英文占用2个字节
        //java双字节编码
        byte[] bytes3=str.getBytes("     ");
        for(byte b:bytes3){
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();

        String string=new String(bytes1);
        System.out.println(string);
    }
}
