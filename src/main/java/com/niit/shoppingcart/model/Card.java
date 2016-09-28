package com.niit.shoppingcart.model;




import java.io.Serializable;

public class Card implements Serializable {

private static final long serialVersionUID = 1L;

private String cardnumber;
private String date;
private String cvv;
private String method;


public String getMethod() {
	return method;
}


public void setMethod(String method) {
	this.method = method;
}


public String getCardnumber() {
	return cardnumber;
}


public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


public String getCvv() {
	return cvv;
}


public void setCvv(String cvv) {
	this.cvv = cvv;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public String toCart(){
	return "Cart [username= " + cardnumber + "]";
}

}