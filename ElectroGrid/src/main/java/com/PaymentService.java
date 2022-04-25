package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Payment;

@Path("/Payments")


public class PaymentService {
Payment paymentObj = new Payment();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("Amount") String Amount,
			@FormParam("PaymentCardNo") String PaymentCardNo, @FormParam("PaymentType") String PaymentType,
			@FormParam("PaymentDate") String PaymentDate) {
		String output = paymentObj.insertPayment(Amount, PaymentCardNo, PaymentType, PaymentDate);
		return output;
	}
}