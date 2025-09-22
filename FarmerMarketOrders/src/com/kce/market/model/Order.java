package com.kce.market.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private boolean paid;
    private List<OrderItem> items;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.paid = false;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem i : items) {
            total += i.getEachProductTotal();
        }
        return total;
    }

    public void display() {
        System.out.println("OrderId" + orderId);
        for (OrderItem i : items) {
         System.out.println(i.getProduct().getProductName() + " x " + i.getQuantity() +   " = " + i.getEachProductTotal());
        }
        System.out.println("Total cost: " + this.getTotal());
    }

    public boolean isPaid() {
        return paid;
    }
    
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public int getOrderId() {
        return orderId;
    }
}
