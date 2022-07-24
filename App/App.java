package App;
import App.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Student s = getValue();
        generateTxt(s);
    }

    public static Student getValue() {
        // Student student = new Student();
        Scanner s = new Scanner(System.in);
        System.out.println("--------学生管理--------");
        System.out.println("请输入学号");
        int id = s.nextInt();
        // student.id = id;
        System.out.println("请输入姓名");
        String name = s.next();
        // student.name = name;
        System.out.println("请输入性别");
        String sex = s.next();
        // student.sex = sex;
        System.out.println("请输入数学成绩");
        float math = s.nextFloat();
        // student.math = math;
        System.out.println("请输入英语成绩");
        float english = s.nextFloat();
        // student.english = english;
        System.out.println("请输入物理成绩");
        float physics = s.nextFloat();
        // student.physics = physics;
        Student student = new Student(id,name,sex,math,english,physics);
        return student;
    }

    public static void generateTxt(Student student) {
        File f = new File("./student_info.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("学号\t姓名\t性别\t数学\t英语\t物理");
            bw.newLine();
            bw.write(student.id+"\t\t"+student.name+"\t\t"+student.sex+"\t"+student.math+"\t"+student.english+"\t"+student.physics);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
