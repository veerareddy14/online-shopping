package net.veera.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.veera.shoppingbackend.dao.UserDAO;
import net.veera.shoppingbackend.dto.Address;
import net.veera.shoppingbackend.dto.Cart;
import net.veera.shoppingbackend.dto.User;



public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart= null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.veera.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*
	 * @Test public void testAdd() { user= new User();
	 * user.setFirstName("Hrithick"); user.setLastName("Roshan");
	 * user.setEmail("hr@gmail.com"); user.setContactNumber("1234512345");
	 * user.setRole("USER"); user.setPassword("123456");
	 * 
	 * //add the user assertEquals("Failed to add user!", true,
	 * userDAO.addUser(user));
	 * 
	 * //
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("101 jadoo society, Krish Nagar");
	 * address.setAddressLineTwo("Near Kabil Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400001"); address.setBilling(true);
	 * 
	 * //link the user with the address using userID
	 * address.setUserId(user.getId());
	 * 
	 * //add the address assertEquals("Failed to add address!", true,
	 * userDAO.addAddress(address));
	 * 
	 * if(user.getRole().equals("USER")) {
	 * 
	 * // create a cart for the user cart = new Cart(); //link the user with the
	 * cart using userID cart.setUser(user); //add the cart
	 * assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
	 * 
	 * //add a shipping address for this user address = new Address();
	 * address.setAddressLineOne("501 jadoo society, Kannayya Nagar");
	 * address.setAddressLineTwo("Near Kudrat Store"); address.setCity("Jaipur");
	 * address.setState("Rajasthan"); address.setCountry("India");
	 * address.setPostalCode("200001"); // set shipping to true
	 * address.setShipping(true); //link the user with the address using userID
	 * address.setUserId(user.getId());
	 * 
	 * //add the shipping address assertEquals("Failed to add shipping address!",
	 * true, userDAO.addAddress(address)); } }
	 */
	/*
	 * @Test public void testAdd() { user= new User();
	 * user.setFirstName("Hrithick"); user.setLastName("Roshan");
	 * user.setEmail("hr@gmail.com"); user.setContactNumber("1234512345");
	 * user.setRole("USER"); user.setPassword("123456");
	 * 
	 * if(user.getRole().equals("USER")) { // create a cart for the user cart = new
	 * Cart();
	 * 
	 * cart.setUser(user); //attach the cart with the user user.setCart(cart); }
	 * //add the user assertEquals("Failed to add user!", true,
	 * userDAO.addUser(user)); }
	 */	
	@Test
	public void testUpdateCart() {
		//fetch the user by email
		user = userDAO.getByEmail("hr@gmail.com");
		
		// get the cart of the user
		
		cart = user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart",true,userDAO.updateCart(cart));
				
	}
	
	
}
