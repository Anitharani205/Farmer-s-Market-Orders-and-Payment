package com.kce.market.main;

import com.kce.market.model.*;
import com.kce.market.service.MarketService;
import com.kce.market.exception.MarketValidationException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MarketService service = new MarketService();
        Vendor vendor = null;
        Order order = null;
        Delivery delivery = null;

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Vendor");
            System.out.println("2. Add Product");
            System.out.println("3. Place Order");
            System.out.println("4. Record Payment");
            System.out.println("5. Schedule Delivery");
            System.out.println("6. Request Return");
            System.out.println("7. Display Inventory");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vendor ID: ");
                    int vid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Vendor Name: ");
                    String vname = sc.nextLine();
                    vendor = new Vendor(vid, vname);
                    System.out.println("Vendor added successfully");
                    break;

                case 2:
                    if (vendor == null) { 
                    	System.out.println("Add vendor"); 
                    	break; 
                    	}
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Product p = new Product(pid, pname, stock, price);
                    vendor.addProducts(p);
                    System.out.println("Product added sucessfully");
                    break;

                case 3:
                    if (vendor == null) { 
                    	System.out.println("Add vendor and product first!"); 
                    	break; 
                    	}
                    vendor.displayProducts();
                    System.out.print("Enter Product ID to order: ");
                    int opid = sc.nextInt();
                    Product product = vendor.getProductById(opid);
               
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    order = new Order(1);
                    try {
                        service.validate(product, qty);
                        OrderItem item = new OrderItem(product, qty);
                        service.placeOrder(order, item);
                        order.display();
                    } catch (MarketValidationException e) {
                        System.out.println(e);
                    }
                    break;

                case 4: 
                    if (order == null) { 
                    	System.out.println("No order placed!");
                    	break; 
                    	}
                    System.out.print("Enter payment amount: ");
                    double amt = sc.nextDouble();
                    Payment pay = new Payment(order.getTotal());
                    pay.pay(amt);
                    if (pay.status) order.setPaid(true);
                    break;

                case 5:
                    delivery = new Delivery(order);
                    delivery.scheduleDelivery();
                    break;

                case 6: 
                    System.out.print("Enter Product ID to return: ");
                    int rid = sc.nextInt();
                    Product rp = vendor.getProductById(rid);
                    if (rp == null) { 
                    System.out.println("Product not found!"); 
                    break;
                    }
                    System.out.print("Enter return quantity: ");
                    int rqty = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter reason: ");
                    String reason = sc.nextLine();
                    ReturnRequest rr = new ReturnRequest(reason);
                    rr.approve(rp, rqty);
                    break;

                case 7:
                    vendor.displayProducts();
                    break;

                case 8:
                    exit = true; 
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
