package com.me.model;

import java.io.Serializable;
import java.util.Set;

import com.me.model.Notes;

public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String name;
	private String password;
	
	private String gender;
	private Integer age;
	private String university;
	Set<Notes> notesList;
	Set<Share> shareList;
	
	
	
	public Set<Share> getShareList() {
		return shareList;
	}


	public void setShareList(Set<Share> shareList) {
		this.shareList = shareList;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public Set<Notes> getNotesList() {
		return notesList;
	}


	public void setNotesList(Set<Notes> notesList) {
		this.notesList = notesList;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
