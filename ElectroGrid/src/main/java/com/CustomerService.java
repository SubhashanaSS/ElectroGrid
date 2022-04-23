package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Customer;

@Path("/Customers")

public class CustomerService {
	
	Customer customerObj = new Customer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readCustomers() {
		return customerObj.readCustomers();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(@FormParam("CustomerName") String CustomerName,
			@FormParam("CustomerAddress") String CustomerAddress, @FormParam("CustomerEmail") String CustomerEmail,
			@FormParam("CustomerContact") String CustomerContact) {
		String output = customerObj.insertCustomer(CustomerName, CustomerAddress, CustomerEmail, CustomerContact);
		return output;
	}
}
