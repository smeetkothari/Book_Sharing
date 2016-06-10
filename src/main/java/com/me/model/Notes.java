package com.me.model;

public class Notes {
private int notesid;
private String name;
private String subject;
private int no_of_pages;
private String description;
private int amount;
private User user;


public int getNotesid() {
	return notesid;
}
public void setNotesid(int notesid) {
	this.notesid = notesid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getNo_of_pages() {
	return no_of_pages;
}
public void setNo_of_pages(int no_of_pages) {
	this.no_of_pages = no_of_pages;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}


}
