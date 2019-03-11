package net.veera.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	//--------------------------------
	//private fields for cart begin
	//--------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="uid")
	private User user;
	@Column(name="grand_total")
	private double grandTotal;
	@Column(name="cart_lines")
	private int cartLines;	
	//------------------------------
	//private fields for address end
	//------------------------------

	//--------------------------------------------
	//setters and getters for private fields begin
	//--------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	
	//--------------------------------------------
	//setters and getters for private fields end
	//--------------------------------------------
	
	//---------------------------------------------------------
	//toString method for logging and debugging activity begin
	//----------------------------------------------------------
	
	
	//---------------------------------------------------------
	//toString method for logging and debugging activity end
	//----------------------------------------------------------
}
