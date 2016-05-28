import com.basic.util.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by dell-pc on 2016/5/26.
 */
public class IOUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPrintHex() throws Exception {
        IOUtils.printHex("data/raf.dat");
    }

    @Test
    public void testPrintHexByByteArray() throws Exception {
        long startTime=System.currentTimeMillis();
        IOUtils.printHexByByteArray("");
        System.out.println();
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000);
    }

    @Test
    public void testPrintStringByteArray() throws Exception {
        IOUtils.printStringByteArray("data/file.txt","utf-8");
    }

    @Test
    public void test() throws Exception {
        //true表示该输入输出流是以追加模式进行的
        FileOutputStream outputStream = new FileOutputStream("data/file.txt",true);
        FileInputStream inputStream=new FileInputStream("data/file.txt");
        outputStream.write('A'); //写出了A字符的低八位
        outputStream.write('B'); //写出了A字符的低八位
        outputStream.write(0xffff);
        int a=100;
        String str="中国人民共和国";
        outputStream.write(str.getBytes("utf-8"));

        byte[] bytes=new byte[512];
        int num=inputStream.read(bytes);
        System.out.print(new String(bytes,0,num,"utf-8"));
        System.out.print(":");
    }

    @Test
    public void testcopyFile() throws Exception {
        IOUtils.copyFile(new File("data/file.txt"),new File("data/file2.txt"));
    }

    @Test
    public void testcopyFileByBuffer() throws Exception {
        IOUtils.copyFileByBuffer(new File("data/file.txt"),new File("data/file2.txt"));
    }

    @Test
    public void testcopyFileByByte() throws Exception {
        IOUtils.copyFileByByte(new File("data/file.txt"),new File("data/file2.txt"));
    }

    @Test
    public void DataOutputStreamTest() throws Exception {
        String fileName="data/doc.txt";
        DataOutputStream outputStream=new DataOutputStream(new FileOutputStream(fileName));
        outputStream.writeInt(10);
        outputStream.writeInt(-10);
        outputStream.writeLong(10L);
        outputStream.writeDouble(10.26);
        outputStream.writeUTF("中国地质大学");//以UTF-8的形式编码字符串写入
        outputStream.writeChars("中国");//以UTF-16be的形式编码字符串写入
        outputStream.close();
        IOUtils.printStringByteArray(fileName,"UTF-8");
        IOUtils.printHexByByteArray(fileName);
    }

    @Test
    public void DataInputStreamTest() throws Exception {
        String fileName="data/doc.txt";
        DataInputStream inputStream=new DataInputStream(new FileInputStream(fileName));
        int a=inputStream.readInt();
        System.out.println(a);
        int b=inputStream.readInt();
        System.out.println(b);
        long c=inputStream.readLong();
        System.out.println(c);
        double d=inputStream.readDouble();
        System.out.println(d);
        String s=inputStream.readUTF();
        System.out.println(s);
        System.out.println(inputStream.readChar());
    }

    @Test
    public void InputStreamReader() throws Exception {
        String fileName="data/InputReader.txt";
        InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(fileName),"utf-8");
//        int ch;
//        while ((ch=inputStreamReader.read())!=-1){
//            System.out.print((char)ch);
//        }
        //批量读取字符流
        char ch[]=new char[512];
        int b;
        while ((b=inputStreamReader.read(ch,0,ch.length))!=-1){
            System.out.print(new String(ch,0,b));
        }
        inputStreamReader.close();
    }

    @Test
    public void OutpuStreamReader() throws Exception {
        String fileName="data/OutputWriter.txt";
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(fileName),"utf-8");
        outputStreamWriter.write("中国地质大学");
        outputStreamWriter.close();
    }

    @Test
    public void FileReader() throws Exception {
        String fileName1="data/InputReader.txt";
        String fileName2="data/OutputWriter.txt";
        FileReader fileReader=new FileReader(fileName1);
        //若参数为true，则表示写入流为追加模式
        //FileWriter fileWriter=new FileWriter(fileName2);
        FileWriter fileWriter=new FileWriter(fileName2,true);
        char buffer[]=new char[512];
        int b;
        while ((b=fileReader.read(buffer))!=-1){
            fileWriter.write(buffer,0,b);
            fileWriter.flush();
        }
        fileReader.close();
        fileWriter.close();
    }

    @Test
    public void FileWriter() throws Exception {
        String fileName="data/OutputWriter.txt";

    }

    @Test
    public void BufferWriterAndReader() throws Exception {
        String fileName1="data/InputReader.txt";
        String fileName2="data/OutputWriter.txt";
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(fileName1),"utf-8"));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2,true),"utf-8"));

        String line="";
        //不识别换行
        while ((line=reader.readLine())!=null){
            System.out.println(line);
            writer.write(line);
            //单独写出换行操作
            writer.newLine();
        }
        reader.close();
        writer.close();

    }
}
