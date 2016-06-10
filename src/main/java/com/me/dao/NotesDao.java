package com.me.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;




import org.springframework.util.NumberUtils;

import com.me.model.User;
import com.me.model.Notes;

public class NotesDao extends DAO {
	public boolean insertNotes(User user, String name, String subject, int no_of_pages, String description, int amount) {
		Session session = getSession();
		session.beginTransaction();
		Notes n = new Notes();
		System.out.println(user);
		n.setName(name);
		n.setUser(user);
		n.setSubject(subject);
		n.setNo_of_pages(no_of_pages);
		n.setDescription(description);
		n.setAmount(amount);
		System.out.println("1");
		session.save(n);
		System.out.println("2");	
		session.getTransaction().commit();
		return true;
	}
	
	public List<Notes> listAllNotes(User u){
		Query query;
		Session session = getSession();
		session.beginTransaction();
		
		if(u==null){
		 query = getSession().createQuery("from Notes");
		}
		else{
			int i = u.getUserid();
			query = getSession().createQuery("from Notes where userid!=:i");
			query.setInteger("i", i);
			
		}
		List list = (List) query.list();
		return list;
		
	}
	
	public List<Notes> listAllNotesByQuery(User u, String a){
		Query query;
		a="%"+a+"%";
		if(u==null){
		 query = getSession().createQuery("from Notes where name like :qs");
		 query.setString("qs", a);
		}
		else{
			int i = u.getUserid();
			query = getSession().createQuery("from Notes where name like :qs and userid!=:i");
			query.setString("qs", a);
			query.setInteger("i", i);
			
		}
		List list = (List) query.list();
		
		Query query2;
		if(u==null){
		 query2 = getSession().createQuery("from Notes where description like :qs");
		 query2.setString("qs", a);
		}
		else{
			int i = u.getUserid();
			query2 = getSession().createQuery("from Notes where description like :qs and userid!=:i");
			query2.setString("qs", a);
			query2.setInteger("i", i);
			
		}
		List list2 = (List) query2.list();
		
		list.addAll(list2);
		
		
		return list;
		
	}
	public Notes getNotesById(int id){
		Query query = getSession().createQuery("from Notes where notesid=:lit");
		query.setInteger("lit", id);
		Notes n = (Notes) query.uniqueResult();
		return n;
	}
	
	public List<Notes> listCart(ArrayList<String> id){
		List<Notes> cart = new ArrayList<Notes>();
		for(String a: id){
			a=a.trim();
			System.out.println("asize::"+a.length());
			int lit=Integer.parseInt(a);
		
		System.out.println("dewdedd::"+lit);
		Query query = getSession().createQuery("from Notes where notesid=:lit");
		query.setInteger("lit", lit);
		Notes n = (Notes) query.uniqueResult();
		cart.add(n);
		}
		return cart;
	}
}
