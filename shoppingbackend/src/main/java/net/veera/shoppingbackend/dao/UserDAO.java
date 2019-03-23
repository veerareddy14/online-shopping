package net.veera.shoppingbackend.dao;

import java.util.List;

import net.veera.shoppingbackend.dto.Address;
import net.veera.shoppingbackend.dto.Cart;
import net.veera.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	

}
