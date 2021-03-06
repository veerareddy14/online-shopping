package net.veera.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.veera.shoppingbackend.dao.UserDAO;
import net.veera.shoppingbackend.dto.Address;
import net.veera.shoppingbackend.dto.Cart;
import net.veera.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			//ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery  = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("billing", true)
					.getSingleResult();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String selectQuery  = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("shipping", true)
					.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
