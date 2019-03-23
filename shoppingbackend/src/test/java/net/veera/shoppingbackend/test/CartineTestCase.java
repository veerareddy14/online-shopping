package net.veera.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.veera.shoppingbackend.dao.CartLineDAO;
import net.veera.shoppingbackend.dao.ProductDAO;
import net.veera.shoppingbackend.dao.UserDAO;
import net.veera.shoppingbackend.dto.Cart;
import net.veera.shoppingbackend.dto.CartLine;
import net.veera.shoppingbackend.dto.Product;
import net.veera.shoppingbackend.dto.User;

public class CartineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart= null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.veera.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}
	
	@Test
	public void testAddNewCartline() {
		// 1.get the user
		user=userDAO.getByEmail("yr@gmail.com");
		
		// 2. fetch the cart
		cart= user.getCart();
		
		// 3. get the product
		product=productDAO.get(8);
		
		// 4. create the new cartline
		cartLine= new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		// upgrade the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));

		
	}
	
	
}
