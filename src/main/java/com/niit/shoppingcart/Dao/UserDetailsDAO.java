package com.niit.shoppingcart.Dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.niit.shoppingcart.model.UserDetails;

@Repository
public interface UserDetailsDAO {

	public boolean save(UserDetails userdetails);
	public boolean update(UserDetails userdetails);
	public boolean delete(UserDetails userdetails);
	public UserDetails get1(String userName);
	public boolean isValidUser(String userName,String password);
	public  UserDetails get(String id);
	public List<UserDetails> list();


}
