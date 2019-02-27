package net.veera.shoppingbackend.dao;

import java.util.List;

import net.veera.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
