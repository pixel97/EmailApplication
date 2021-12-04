package emailapp;

import java.util.Scanner;

public class Application {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first name");
        String fname = s.next();
        System.out.println("Enter last name");
        String lname = s.next();

        Email em = new Email(fname, lname);
        int choice = -1;
        do {
            System.out.println("Enter your choice ********\n1 Show Info \n2 Change Password \n3 Change mailbox capacity \n4 Set Alternate email \n5 Exit");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    em.getInfo();
                    break;
                case 2:
                    em.set_password();
                    break;
                case 3:
                    em.set_mailcap();
                    break;
                case 4:
                    em.alternate_email();
                    break;
                case 5:
                    System.out.println("Thank you for using application");
                default:
                    System.out.println("Enter valid choice");
            }

        } while (choice != 5);

    }
}
