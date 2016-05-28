package com.basic.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dell-pc on 2016/5/25.
 */
public class RafDemo {

    public static void main(String[] args) throws IOException {
        File file=new File("data");
        if(!file.exists()){
            file.mkdir();
        }

        File demo=new File(file,"raf.dat");
        if(!demo.exists()){
            demo.createNewFile();
        }

        RandomAccessFile raf=new RandomAccessFile(demo,"rw");
        //查看文件指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('A');//只写了一个字节
        //查看文件指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('B');//只写了一个字节

        int i=0x7fffffff;
        //raf.write操作每次只能写1个字节，如果要把i写就去就要写入4次
        raf.write(i>>24);//高八位
        raf.write(i>>16);
        raf.write(i>>8);
        raf.write(i);

        String s="中文";
        byte[] gbk=s.getBytes("gbk");
        raf.write(gbk);

        //读文件必须把指针移到头部
        raf.seek(0);

        byte[] buf=new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(new String(buf,"gbk"));
        for (byte b:buf){
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
    }
}
