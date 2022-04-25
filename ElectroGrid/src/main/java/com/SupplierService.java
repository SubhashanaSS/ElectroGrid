package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}

