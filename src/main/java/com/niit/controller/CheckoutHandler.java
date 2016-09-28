package com.niit.controller;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.model.Card;

@Service

public class CheckoutHandler {

		public String cardPayment(Card card){
			String name = card.getCardnumber();
			String date=card.getDate();
			String cvv=card.getCvv();
			
			System.out.println(name);
			if(name.equals("1234567890")&&date.equals("01/2018")&&cvv.equals("111")){
				
				return "true";
			}
			else{
				return "false";
			}
		}
		
		public String paymentMethod(Card card){
			
			//cart.setMethod("card");
			String method=card.getMethod();
			System.out.println("method");
			if(method.equals("cod")){
				return "cod";
			}else {
				return "card";
			}
		}
	}


