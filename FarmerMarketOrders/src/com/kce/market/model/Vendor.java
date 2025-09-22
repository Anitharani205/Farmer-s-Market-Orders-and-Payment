package com.kce.market.model;
import java.util.ArrayList;
import java.util.List;

public class Vendor {
	public int vendorId;
	public String name;
	public List<Product> products;
	
	public Vendor(int vendorId,String name)
	{
		this.vendorId = vendorId;
		this.name=name;
		this.products = new ArrayList<>();
		
	}
	
	public void addProducts(Product p)
	{
		products.add(p);
	}
	
	public void displayProducts()
	{
		for(Product p : products)
		{
		System.out.println(p);
		}
	}
	public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
   
}
