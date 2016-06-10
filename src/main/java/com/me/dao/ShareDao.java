  package com.me.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.me.model.Notes;
import com.me.model.Share;
import com.me.model.User;

public class ShareDao extends DAO{
 public Share addShare(Notes n, User u){
	 Session session = getSession();
		session.beginTransaction();
	 Share s = new Share();
	 s.setNotes(n);
	 s.setUser(u);
	 String sql = "SELECT CURTIME()";
		Query query2 = session.createSQLQuery(sql);
		Time t = (Time) query2.uniqueResult();
		//System.out.println(t);
		String sql3= "SELECT CURDATE()";
		Query query3 = session.createSQLQuery(sql3);
		Date d = (Date) query3.uniqueResult();
		//System.out.println(t);
		s.setStime(t);
		s.setSdate(d);
	 session.save(s);
	
	 session.getTransaction().commit();
	 return s;
 }
 
 public List getMyShare(User u) {
	 Session session = getSession();
		session.beginTransaction();
		 String sql = "SELECT CURTIME()";
			Query query2 = session.createSQLQuery(sql);
			Time t = (Time) query2.uniqueResult();
	 String sql3= "SELECT CURDATE()";
		Query query3 = session.createSQLQuery(sql3);
		Date d = (Date) query3.uniqueResult();
		String today = d.toString()+" "+t.toString();
	 Query query = getSession().createQuery("from Share  where userid=:id");
	 query.setInteger("id", u.getUserid());
	 List<Share> list = query.list();
	 List<Share> list2  = query.list();
	 for(Share s : list){
		 Date d1 = s.getSdate();
		 Time t1 = s.getStime();
		 String bookdate = d1.toString()+" "+t1.toString();
		 String sql2 = "SELECT TIMESTAMPDIFF(SECOND,:today,:bookdate)";
			Query query33 = session.createSQLQuery(sql2);
			query33.setString("today", bookdate);
			query33.setString("bookdate", today);
			 BigInteger i= (BigInteger) query33.uniqueResult();
			if(i.intValue()>86400){
				list2.remove(s);
			}
	 }
	 return list2;
 }
}
