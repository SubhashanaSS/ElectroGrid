package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
