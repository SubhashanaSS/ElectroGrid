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

import model.Supplier;

@Path("/Suppliers")

public class SupplierService {
	
	Supplier supplierObj = new Supplier();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertSupplier(@FormParam("SupplierName") String SupplierName,
			@FormParam("SupplySize") String SupplySize, @FormParam("EnergyType") String EnergyType,
			@FormParam("SupplierStatus") String SupplierStatus) {
		String output = supplierObj.insertSupplier(SupplierName, SupplySize, SupplySize, SupplierStatus);
		return output;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readSupplier() {
		return supplierObj.readSupplier();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateSupplier(String supplierData) {
		// Convert the input string to a JSON object
		JsonObject supplierObject = new JsonParser().parse(supplierData).getAsJsonObject();
		// Read the values from the JSON object
		String SupplierID = supplierObject.get("SupplierID").getAsString();
		String SupplierName = supplierObject.get("SupplierName").getAsString();
		String SupplySize = supplierObject.get("SupplySize").getAsString();
		String EnergyType = supplierObject.get("EnergyType").getAsString();
		String SupplierStatus = supplierObject.get("SupplierStatus").getAsString();
		String output = supplierObj.updateSupplier(SupplierID, SupplierName, SupplySize, EnergyType,
				SupplierStatus);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSupplier(String supplierData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(supplierData, "", Parser.xmlParser());

		// Read the value from the element <CustomerID>
		String SupplierID = doc.select("SupplierID").text();
		String output = supplierObj.deleteSupplier(SupplierID);
		return output;
	}
}

