package com.wip.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wip.model.Product;
import com.wip.util.MyDBConnection;

public class ProductDao {

    Connection con;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    CallableStatement cs;

    // INSERT using PreparedStatement
    public void insertProduct(Product pr) {

        try {

            con = MyDBConnection.getMyDBConnection();

            ps = con.prepareStatement("insert into product values(?,?)");

            ps.setInt(1, pr.getPid());
            ps.setString(2, pr.getPname());

            int rows = ps.executeUpdate();

            System.out.println(rows + " inserted successfully !!!!");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // SELECT all products
    public void retrieveProducts() {

        try {

            con = MyDBConnection.getMyDBConnection();

            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from product");

            while (rs.next()) {

                System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // UPDATE product
    public void updateProduct(Product pr) {

        try {

            con = MyDBConnection.getMyDBConnection();

            ps = con.prepareStatement("update product set pname=? where pid=?");

            ps.setString(1, pr.getPname());
            ps.setInt(2, pr.getPid());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Product updated successfully");

            } else {

                System.out.println("Product ID not found");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // DELETE product
    public void deleteProduct(Product pr) {

        try {

            con = MyDBConnection.getMyDBConnection();

            ps = con.prepareStatement("delete from product where pid=?");

            ps.setInt(1, pr.getPid());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Product deleted successfully");

            } else {

                System.out.println("Product ID not found");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    // INSERT using Stored Procedure
    public void insertProductUsingProcedure(Product pr) {

        try {

            con = MyDBConnection.getMyDBConnection();

            cs = con.prepareCall("{call createProduct(?,?)}");

            cs.setInt(1, pr.getPid());
            cs.setString(2, pr.getPname());

            int rows = cs.executeUpdate();

            System.out.println(rows + " inserted via stored procedure...");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    public void findProductNameById(int id) {

        try {

            con = MyDBConnection.getMyDBConnection();

            cs = con.prepareCall("{call getProductNameById(?)}");

            cs.setInt(1, id);

            rs = cs.executeQuery();

            while (rs.next()) {
                System.out.println("Product Name: " + rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}