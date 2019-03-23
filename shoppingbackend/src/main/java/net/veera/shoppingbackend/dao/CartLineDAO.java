package net.veera.shoppingbackend.dao;

import java.util.List;

import net.veera.shoppingbackend.dto.Cart;
import net.veera.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	
	//common methods from previously coded one
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//business methods
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	
	//related to the cart
	boolean updateCart(Cart cart);

}
