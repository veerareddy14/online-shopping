package net.veera.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.veera.shoppingbackend.dao.CategoryDAO;
import net.veera.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.veera.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { 
	 * category = new Category();
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop !");
	 * category.setImageURL("CAT_2.png");
	 * assertEquals("successfully added a category inside the table ", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(1);
	 * assertEquals("successfully fetched a  single category from  the table "
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(3);
	 * //category.setName("TV"); //category.setImageURL("CAT_3.png");
	 * category.setDescription("This is some description for TV !");
	 * 
	 * assertEquals("successfully updated a  single category in  the table ", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(3);
	 * 
	 * assertEquals("successfully deleted a  single category in  the table ", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * assertEquals("successfully fetched  the list of  categories  from  the table "
	 * , 3, categoryDAO.list().size()); }
	 */
	
	@Test
	public void testCRUDCategory() {
		
		 // adding a new category
		 category = new Category();
		 category.setName("Laptop");
		 category.setDescription("This is some description for laptop !");
		 category.setImageURL("CAT_1.png");
		 assertEquals("Something went wrong while  adding a category inside the table ", true,categoryDAO.add(category));
		 
		 category = new Category();
		 category.setName("Television");
		 category.setDescription("This is some description for Television !");
		 category.setImageURL("CAT_2.png");
		 assertEquals("Something went wrong while  adding a record to the table ", true,categoryDAO.add(category));
		 
		 //fetching and updating a category
		 category = categoryDAO.get(2);
		 category.setName("TV"); 
		 category.setDescription("This is some description for TV !");
		 assertEquals("Something went wrong while  updating a  record in  the table ", true,categoryDAO.update(category)); 
		 
		 //deleting a category
		 
		 assertEquals("Something went wrong while deleting a  record from  the table ", true,categoryDAO.delete(category)); 
		 
		 // fetching the list
		 assertEquals("Something went wrong while fetching  the list of  records  from  the table " , 1, categoryDAO.list().size());
		
	}

}
