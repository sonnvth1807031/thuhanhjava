package controller;

import java.io.IOException;
import java.util.Scanner;

public class CreateMenu {
    public void menu() throws IOException {
        AddStudent addStudent = new AddStudent();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Add new student");
            System.out.println("2. Save");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("---Add new student---");
                    addStudent.Add();
                    break;
                case 2:
                    System.out.println("-----Save-----");
                    addStudent.Save();
                    break;
                case 3:
                    System.out.println("---Display all students---");
                    break;
                case 4:
                    System.out.println("-----Exit-----");
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập số trong khoảng từ 1 đến 4.");
            }
        }while (choice !=4);
        System.out.println("Hẹn gặp lại.");
    }
}
