package com.kce.market.model;

public class Product {
	public int productId;
	public String productName;
	public int stock;
	public double price;
	
	public Product(int productId,String productName, int stock,double price)
	{
		this.productId=productId;
		this.productName = productName;
		this.stock = stock;
		this.price = price;
	}
	public int getProductId() { 
		return productId; 
		}
	 public String getProductName() { 
		  return productName;
		}
	 
	 public int getStock() {
		return stock;
		}
	 
	public double getPrice() {
		return price; 
		}
	
	public boolean reduceStock(int qty)
	{
		if(stock >= qty)
		{
			stock-=qty;
			return true;
		}
		return false;
	}

	public void increaseStock(int qty)
	{
		stock+=qty;
	}
}
