package com.basic.util;

import java.io.File;

/**
 * Created by dell-pc on 2016/5/25.
 * 列出File的常用操作 列如过滤、遍历目录的操作。
 */
public class FileUtils {

    /**
     *  列出指定目录下包括子目录下的所有文件
     * @param dir 文件名称
     */
    public static void listDircetory(File dir){
        if(!dir.exists()){
            throw new IllegalArgumentException("目录"+dir+"不存在");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException("输入的"+dir+"不是目录");
        }

        File files[]=dir.listFiles();
        if(files!=null && files.length>0){
            for(File file:files){
                if(file.isDirectory())
                    listDircetory(file);
                else {
                    System.out.println(file);
                }
            }
        }
    }

}
