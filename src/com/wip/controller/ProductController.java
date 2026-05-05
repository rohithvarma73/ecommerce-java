package com.wip.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wip.dao.ProductDao;
import com.wip.model.Product;

public class ProductController implements ProductInterface {

    Product pr;
    Scanner sc = new Scanner(System.in);
    List<Product> prList = new ArrayList<>();
    ProductDao dao = new ProductDao();

    public void addProduct() {

        pr = new Product();

        System.out.println("Enter the Prod ID:");
        int prid = sc.nextInt();
        pr.setPid(prid);

        System.out.println("Enter the Prod Name:");
        String prName = sc.next();
        pr.setPname(prName);

        prList.add(pr);
        dao.insertProduct(pr);

        System.out.println("Product Added Successfully !!!");
    }

    public void viewProduct() {

        System.out.println(prList);
        dao.retrieveProducts();
    }

    public void updateProduct() {

        pr = new Product();

        System.out.println("Enter Product ID to update:");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        pr.setPid(id);

        System.out.println("Enter the new product name:");
        String name = sc.nextLine();
        pr.setPname(name);

        dao.updateProduct(pr);
    }

    public void deleteProduct() {

        pr = new Product();

        System.out.println("Enter Product ID to delete:");
        int id = sc.nextInt();

        pr.setPid(id);

        dao.deleteProduct(pr);
    }

    // Procedure based insert
    public void insertProductUsingProcedure() {

        pr = new Product();

        System.out.println("Enter the Prod ID:");
        int prid = sc.nextInt();
        pr.setPid(prid);

        System.out.println("Enter the Prod Name:");
        String prName = sc.next();
        pr.setPname(prName);

        dao.insertProductUsingProcedure(pr);

        System.out.println("Product Added Successfully via Procedure!!!");
    }
    
    public void findProductNameById() {

        System.out.println("Enter Product ID:");
        int id = sc.nextInt();

        dao.findProductNameById(id);
    }
}