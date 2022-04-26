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

import model.Consumption;

@Path("/Consumptions")

public class ConsumptionService {
	
	Consumption consumptionObj = new Consumption();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertConsumption(@ FormParam("CustomerName") String CustomerName,
			@FormParam("CustomerUsage") String CustomerUsage, @FormParam("Price") String Price,
			@FormParam("CustomerType") String CustomerType) {
		String output = consumptionObj.insertConsumption(CustomerName, CustomerUsage, Price, CustomerType);
		return output;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readConsumption() {
		return consumptionObj.readConsumption();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateConsumption(String consumptionData) {
		// Convert the input string to a JSON object
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();
		// Read the values from the JSON object
		String ConsumptionID = consumptionObject.get("ConsumptionID").getAsString();
		String CustomerName = consumptionObject.get("CustomerName").getAsString();
		String CustomerUsage = consumptionObject.get("CustomerUsage").getAsString();
		String Price = consumptionObject.get("Price").getAsString();
		String CustomerType = consumptionObject.get("CustomerType").getAsString();
		String output = consumptionObj.updateConsumption(ConsumptionID, CustomerName, CustomerUsage, Price , CustomerType);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteConsumption(String consumptionData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(consumptionData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String ConsumptionID = doc.select("ConsumptionID").text();
		String output = consumptionObj.deleteConsumption(ConsumptionID);
		return output;
	}
}
