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
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments() {
		return paymentObj.readPayments();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String PaymentID = paymentObject.get("PaymentID").getAsString();
		String Amount = paymentObject.get("Amount").getAsString();
		String PaymentCardNo = paymentObject.get("PaymentCardNo").getAsString();
		String PaymentType = paymentObject.get("PaymentType").getAsString();
		String PaymentDate = paymentObject.get("PaymentDate").getAsString();
		String output = paymentObj.updatePayment(PaymentID, Amount, PaymentCardNo, PaymentType, PaymentDate);
		return output;
	}
}
