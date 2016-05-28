package com.basic.io;

import java.io.File;

/**
 * Created by dell-pc on 2016/5/25.
 */
public class FileDemo {
    public static void main(String[] args) {
        File file=new File("data/file.txt");
        System.out.println(file.getAbsolutePath());
    }
}
