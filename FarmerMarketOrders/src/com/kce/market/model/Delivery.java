package com.kce.market.model;

public class Delivery {
    private Order order;
    private boolean delivered;

    public Delivery(Order order) {
        this.order = order;
        this.delivered = false;
    }
    public void scheduleDelivery() {
        if (order.isPaid()) {
            delivered = true;
            System.out.println( "Order has been delivered.");
        } else {
            System.out.println( "Payment not completed.");
        }
    }

    public boolean isDelivered() {
        return delivered;
    }

    public Order getOrder() {
        return order;
    }
}
