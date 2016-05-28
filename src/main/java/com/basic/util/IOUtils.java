package com.basic.util;

import java.io.*;

/**
 * Created by dell-pc on 2016/5/26.
 *  对流进行操作
 */
public class IOUtils {
    /**
     *  读取指定文件，并按照16机制进行输出
     * @param fileName
     */
    public static void printHex(String fileName) throws Exception {
        //把文件作为字节流进行对操作
        FileInputStream in=new FileInputStream(fileName);
        int i=1;
        int b;
        while ((b=in.read())!=-1){
            if(b<0xf){
                System.out.print(0);
            }
            System.out.print(Integer.toHexString(b & 0xff)+" ");
            if(++i % 10==0){
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 读取指定文件，并按照16机制进行输出 通过字节数组缓存
     * @param fileName
     * @throws Exception
     */
    public static void printHexByByteArray(String fileName) throws Exception{
        //把文件作为字节流进行对操作
        FileInputStream in=new FileInputStream(fileName);
        //声明一个字节数组缓存
        byte[] buf=new byte[512];
        int bytes;
        while ((bytes=in.read(buf))!=-1){
            int j=0;
            for(int i=0;i<bytes;i++){
                if(buf[i]<0xf){
                    System.out.print(0);
                }
                System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");
                if(++j % 10==0){
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 读取指定文件，并按照指定的字符集进行文本输出 通过字节数组缓存
     * @param fileName
     * @param charsetName
     * @throws Exception
     */
    public static void printStringByteArray(String fileName,String charsetName) throws Exception {
        FileInputStream in=new FileInputStream(fileName);
        //声明一个字节数组缓存
        byte[] buf=new byte[512];
        int bytes;

        while ((bytes=in.read(buf))!=-1){
            int j=0;
            System.out.print(new String(buf,0,bytes,charsetName));
        }
        in.close();
    }

    /**
     *  文件拷贝字节批量读取
     * @param srcFile
     * @param destFile
     * @throws Exception
     */
    public static void copyFile(File srcFile, File destFile) throws Exception {
        if(!srcFile.exists()){
            throw new IllegalArgumentException("源文件不存在");
        }
        if(!destFile.exists()){
            throw new IllegalArgumentException("目标文件不存在");
        }
        FileInputStream inputStream=new FileInputStream(srcFile);
        FileOutputStream outputStream=new FileOutputStream(destFile);

        byte[] buf=new byte[512];
        int b;
        //b为读取文件的个数
        while ((b=inputStream.read(buf,0,buf.length))!=-1){
            outputStream.write(buf,0,b);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     *  拷贝文件通过字节拷贝
     * @param srcFile
     * @param destFile
     * @throws Exception
     */
    public static void copyFileByByte(File srcFile, File destFile) throws Exception {
        if(!srcFile.exists()){
            throw new IllegalArgumentException("源文件不存在");
        }
        if(!destFile.exists()){
            throw new IllegalArgumentException("目标文件不存在");
        }
        FileInputStream inputStream=new FileInputStream(srcFile);
        FileOutputStream outputStream=new FileOutputStream(destFile);
        int bytes;
        while ((bytes=inputStream.read())!=-1){
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();
    }
    /**
     *  拷贝文件利用带缓存的输入输出流
     * @param srcFile
     * @param destFile
     * @throws Exception
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws Exception {
        if(!srcFile.exists()){
            throw new IllegalArgumentException("源文件不存在");
        }
        if(!destFile.exists()){
            throw new IllegalArgumentException("目标文件不存在");
        }
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(destFile));

        int bytes;
        while ((bytes=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(bytes);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
