package com.me.dao;


import com.me.model.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

 

public class UserDao extends DAO {

	   /*
	    * Since its a query, it is not necessary to wrap code
	    * inside the begin transaction and commit part, unlike
	    * update, create, and delete. Since there is no object
	    * in the session yet, nothing will be committed.  After
	    * Adding these, "transaction is not successfully started'
	    * Exception will be thrown.
	    */
		public User queryUserByNameAndPassword(String name, String password)
	            throws Exception {
	        try {
	      
	            Query q = getSession().createQuery("from User where name = :username and password = :password");
	            q.setString("username", name);
	            q.setString("password", password);
	            User user = (User) q.uniqueResult();
	    
	            return user;
	        } catch (HibernateException e) {
	    
	            throw new Exception("Could not get user " + name, e);
	        } 
		}
	        
	        
	         
	    
		
		
		
		
	
	
	
}
