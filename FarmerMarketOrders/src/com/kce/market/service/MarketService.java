package com.kce.market.service;
import com.kce.market.model.*;
import com.kce.market.exception.MarketValidationException;

public class MarketService {
	
public void validate(Product p , int qty) throws MarketValidationException{
	if(p==null || qty < 0)
	throw new MarketValidationException();
}

public void placeOrder(Order order, OrderItem item) {
    order.addItem(item);
    item.getProduct().reduceStock(item.getQuantity());
    System.out.println("Order Placed");
}

public void returnProcess(Product p,int qty)
{
	p.increaseStock(qty);
	System.out.println("Order returned");
}
}
	

