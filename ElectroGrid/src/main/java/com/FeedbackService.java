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

import model.Feedback;

@Path("/Feedbacks")

public class FeedbackService {
		
	Feedback feedbackObj = new Feedback();
	
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertCustomer(@FormParam("CustomerName") String CustomerName,
				@FormParam("CustomerEmail") String CustomerEmail, @FormParam("Rate") String Rate,
				@FormParam("FeedbackNotes") String FeedbackNotes) {
			String output = feedbackObj.insertFeedback(CustomerName, CustomerEmail, Rate, FeedbackNotes);
			return output;
		}
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readCustomers() {
			return feedbackObj.readFeedbacks();
		}
		
		
}
