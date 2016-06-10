package com.me.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;





public abstract class DAO {
    
   public Session getSession(){
	   try{ 
	   return HibernateUtil.getSessionFactory().openSession();
   }
	   catch(Exception e)
	    {
		   
	    	System.out.println(e);
	    	return null;
	    }
	   
    }
   
    
   protected DAO() {
   }


   protected void begin() {
       getSession().beginTransaction();
   }

   protected void commit() {
       getSession().getTransaction().commit();
   }

   protected void rollback() {
       try {
           getSession().getTransaction().rollback();
       } catch (HibernateException e) {
          
       }
       try {
           getSession().close();
       } catch (HibernateException e) {
          
       }
      
   }

   public  void close() {
       getSession().close();
   }
	
	
}
