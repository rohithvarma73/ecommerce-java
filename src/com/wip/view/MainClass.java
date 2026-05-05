package com.wip.view;

import java.util.Scanner;
import java.util.function.BiPredicate;

import com.wip.controller.ProductController;
import com.wip.controller.ProductInterface;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Ecommerce - App !!!");

        // BiPredicate for un and pass
        BiPredicate<String, String> pr = (un, pwd) -> {
            return un.equals("rohithvarma73") && pwd.equals("pass123");
        };

        int attempts = 0;
        boolean isLogin = false;

        while (attempts < 2) {

            try {

                System.out.print("Enter Username: ");
                String username = sc.next();

                System.out.print("Enter Password: ");
                String password = sc.next();

                if (!pr.test(username, password)) {
                    throw new Exception("Invalid Username or Password");
                }

                System.out.println("Login Successful!");
                isLogin = true;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Attempt failed, Try again! ");
            }

            attempts++;
        }

        if (!isLogin) {
            System.out.println("You have exceeded the maximum login attempts.");
            System.exit(0);
        }

        ProductInterface pc = new ProductController();
        String continueChoice = null;

        do {

            System.out.println("\nEnter your choice:");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Add Elec. Product");
            System.out.println("4. View Elec. Product");
            System.out.println("5. Update Product");
            System.out.println("6. Delete Product");
            System.out.println("7. Add Product using Procedure");
            System.out.println("8. Find Product Name by ID");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    pc.addProduct();
                    break;

                case 2:
                    pc.viewProduct();
                    break;

                case 3:
                    pc.viewProduct();
                    break;

                case 4:
                    pc.viewProduct();
                    break;

                case 5:
                    pc.updateProduct();
                    break;

                case 6:
                    pc.deleteProduct();
                    break;

                case 7:
                    pc.insertProductUsingProcedure();
                    break;

                case 8:
                    pc.findProductNameById();
                    break;

                default:
                    System.out.println("Choose the right choice ....");
            }

            System.out.println("Do you want to continue? Y or y");
            continueChoice = sc.next();

        } while (continueChoice.equals("Y") || continueChoice.equals("y"));

        System.out.println("Thanks for using the system...");
        System.exit(0);
    }
}
