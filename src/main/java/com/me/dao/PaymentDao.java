package com.me.dao;

import org.hibernate.Session;

import com.me.model.Payment;
import com.me.model.Share;

public class PaymentDao extends DAO {
	public void addPayment(int s, int r, String a, String b, String c, String d, Share share){
		Session session = getSession();
		session.beginTransaction();
		Payment p  = new Payment();
		p.setSender(s);
		p.setReceiver(r);
		p.setCard_number(a);
		p.setExpiry(b);
		p.setCvv(c);
		p.setName_on_card(d);
		p.setShare(share);
		session.save(p);
		session.getTransaction().commit();
	}
}
