package com.kce.market.model;

public class ReturnRequest {
    private String reason;
    private boolean approved;

    public ReturnRequest(String reason) {
        this.reason = reason;
        this.approved = false;
    }

    public void approve(Product product, int qty) {
        product.increaseStock(qty);
        approved = true;
        System.out.println("Product Returned Reason: " + reason);
    }

    public boolean isApproved() {
        return approved;
    }

    public String getReason() {
        return reason;
    }
}
