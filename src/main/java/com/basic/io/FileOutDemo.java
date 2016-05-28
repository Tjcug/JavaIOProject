package com.basic.io;

import java.io.FileOutputStream;

/**
 * Created by dell-pc on 2016/5/26.
 */
public class FileOutDemo {
    public static void main(String[] args) throws Exception {
        //如果该文件不存在则直接创建。如果存在则删除后创建
        FileOutputStream outputStream = new FileOutputStream("data/file.txt");
        outputStream.write('A'); //写出了A字符的低八位
        outputStream.write('B'); //写出了A字符的低八位
    }
}
