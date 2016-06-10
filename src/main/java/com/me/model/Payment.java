package com.me.model;

public class Payment {
private int pay_id;
private int sender;
private int receiver;
private int amount;
private String card_number;
private String expiry;
private String cvv;
private String name_on_card;
private Share share;

public Share getShare() {
	return share;
}
public void setShare(Share share) {
	this.share = share;
}
public int getPay_id() {
	return pay_id;
}
public void setPay_id(int pay_id) {
	this.pay_id = pay_id;
}
public int getSender() {
	return sender;
}
public void setSender(int sender) {
	this.sender = sender;
}
public int getReceiver() {
	return receiver;
}
public void setReceiver(int receiver) {
	this.receiver = receiver;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getCard_number() {
	return card_number;
}
public void setCard_number(String card_number) {
	this.card_number = card_number;
}
public String getExpiry() {
	return expiry;
}
public void setExpiry(String expiry) {
	this.expiry = expiry;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getName_on_card() {
	return name_on_card;
}
public void setName_on_card(String name_on_card) {
	this.name_on_card = name_on_card;
}

}
