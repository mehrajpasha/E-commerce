package com.niit.shoppingcart.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Cart;

@Repository
public interface CartDAO {

	public boolean saveOrUpdate(Cart cart);
	public boolean delete(Cart cart);
	public  Cart get(int cartid);
	public List<Cart>list();
	public Cart checkproduct(int id);
    public long getsize(int id);
    public  Cart get(int prodid, int userid);
	public long CartPrice(int userid);
}