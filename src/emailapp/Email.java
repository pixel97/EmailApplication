package emailapp;

import java.util.*;
import java.io.*;

public class Email {

    public Scanner s = new Scanner(System.in);

    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailcapacity = 500;
    private String alter_email;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee" + this.fname + " " + this.lname);
        this.dept = this.setdept();
        this.password = this.generate_password(10);
        this.email = this.generate_email();

    }

    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + "company.com";
    }

    private String setdept() {
        System.out.println("Department codes \n1 for sales \n2 for Developement \n3 for Accounting");
        boolean flag = false;
        do {
            System.out.println("Enter department code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Developement";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
            }
        } while (!flag);
        return null;
    }

    private String generate_password(int length) {
        Random r = new Random();
        String Capital_Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_Chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_Chars + Small_Chars + numbers + symbols;
        String passsword = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change password: Y/N ?");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password !");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password !");
                    this.password = s.next();
                    System.out.println("Password changed successfully !");
                } else {
                    System.out.println("Enter correct password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password change operation cancelled");
            } else {
                System.out.println("Enter Valid choice");
            }
        } while (!flag);
    }

    public void set_mailcap() {
        System.out.println("Current mail capacity" + this.mailcapacity + "mb");
        System.out.println("Enter new mail capacity");
        this.mailcapacity = s.nextInt();
        System.out.println("New mail capacity is:" + this.mailcapacity);
    }

    public void alternate_email() {
        System.out.println("Enter new Email");
        this.alter_email = s.next();
        System.out.println("New Email is:" + this.alter_email);
    }

    public void getInfo() {
        System.out.println("New" + this.fname + "" + this.lname);
        System.out.println("Department" + this.dept);
        System.out.println("Email" + this.email);
        System.out.println("Password" + this.password);
        System.out.println("Mailbox Capacity" + this.mailcapacity);
        System.out.println("Alternate Email" + this.alter_email);
    }


}