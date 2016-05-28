import com.basic.ObjectSerializable.model.Foo2;
import com.basic.ObjectSerializable.model.Student;
import org.junit.Test;

import java.io.*;

/**
 * Created by dell-pc on 2016/5/28.
 */
public class ObjectSerializableTest {

    @Test
    public void outputStream() throws Exception {
        String fileName="serializable/demo.dat";
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(fileName));
        Student student=new Student("01","tanjie","20");
        outputStream.writeObject(student);
        outputStream.close();
    }

    @Test
    public void inputStream() throws Exception {
        String fileName="serializable/demo.dat";
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(fileName));
        Student student= (Student) inputStream.readObject();
        System.out.println(student);
        inputStream.close();
    }

    @Test
    public void FooLeiObjectOutputStream() throws Exception {
        String fileName="serializable/foo.dat";
        Foo2 foo2=new Foo2();
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(fileName));
        outputStream.writeObject(foo2);
        outputStream.close();
    }

    @Test
    public void FooLeiObjectInputStream() throws Exception {
        //反序列化是否会调用父类的构造函数
        String fileName="serializable/foo.dat";
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(fileName));
        Foo2 foo2= (Foo2) inputStream.readObject();
        inputStream.close();
    }
}
