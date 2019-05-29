package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import entity.Student;

public class AddStudent {
    ArrayList<Student> anhson = new ArrayList<Student>();
    HashMap<String,Student> sondz = new HashMap<String, Student>();
    public void Add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("EnrolId :");
        String id = scanner.nextLine();
        System.out.println("First name:");
        String firstname = scanner.nextLine();
        System.out.println("Last name :");
        String lastname = scanner.nextLine();
        System.out.println("Age :");
        int age = scanner.nextInt();
        Student student = new Student(id, firstname, lastname, age);
        anhson.add(student);
        for (Student a: anhson ) {
            Student student1 = new Student(a.getEnrolID(),a.getFirstName(),a.getLastName(),a.getAge());
            sondz.put(a.getEnrolID(),student1);

        }
    }

    public void Save() throws IOException {
        FileWriter fw = new FileWriter("src\\main\\resources\\students.dat");
        fw.write("EnrolID\t\t");
        fw.write("FullName\t\t");
        fw.write("Age\n");
        for (String m: sondz.keySet()) {
            System.out.println("ID :" + m);
            System.out.println("FullName :" + sondz.get(m).getFirstName()+" " +sondz.get(m).getLastName());
            System.out.println("Age :" + sondz.get(m).getAge());
            fw.write(m);
            fw.write("\t\t");
            fw.write(sondz.get(m).getFirstName()+ " " +sondz.get(m).getLastName());
            fw.write("\t\t");
            fw.write(sondz.get(m).getAge());
            fw.write("\n");
        }
        fw.close();
    }
    public void Display() throws IOException {
        FileReader fr = new FileReader("src\\main\\resources\\students.dat");
        BufferedReader br = new BufferedReader(fr);
        String file;
        int xoa = 0;
        while ((file = br.readLine()) != null) {
            if (xoa == 0){
                xoa ++;
                continue;
            }
            System.out.println("EnrollID |    Full Name    |  Age ");
            System.out.println("---------  ---------------- ------");
            for (String l: sondz.keySet()) {
                System.out.printf("%8s | %15s | %8s\n ",sondz.get(l).getEnrolID(),sondz.get(l).getFirstName()+ " " +
                        sondz.get(l).getLastName(),sondz.get(l).getAge());
            }
        }
    }
}
