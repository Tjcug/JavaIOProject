package com.basic.ObjectSerializable.model;

import java.io.Serializable;

/**
 * Created by dell-pc on 2016/5/28.
 */
public class Student implements Serializable{
    //该元素不会被JVM进行序列化，但是可以自己构造进行序列化
    private transient String stuno;
    private String stuname;
    private String stuage;

    public Student() {
    }

    public Student(String stuno, String stuname, String stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage='" + stuage + '\'' +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
         s.defaultWriteObject();//把JVM默认序列化的元素进行序列化操作
         s.writeObject(stuno); //自己完成stuno的序列化
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();//把JVM默认反序列化的元素进行反序列化操作
        this.stuno= (String) s.readObject();//自己完成stuno的反序列化
    }
}
