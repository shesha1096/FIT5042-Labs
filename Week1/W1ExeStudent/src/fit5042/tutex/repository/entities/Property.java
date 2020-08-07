/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author Shesha
 * 
 */
//TODO Exercise 1.3 Step 1 Please refer tutorial exercise. 
public class Property {
	private int propertyId;
	private String propertyAddress;
	private int numberOfBedrooms;
	private int propertySize;
	private double propertyPrice;
	
	
	
	
	public Property() {
	}
	public Property(int propertyId, String propertyAddress, int numberOfBedrooms, int propertySize,
			double propertyPrice) {
		this.propertyId = propertyId;
		this.propertyAddress = propertyAddress;
		this.numberOfBedrooms = numberOfBedrooms;
		this.propertySize = propertySize;
		this.propertyPrice = propertyPrice;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}
	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}
	public int getPropertySize() {
		return propertySize;
	}
	public void setPropertySize(int propertySize) {
		this.propertySize = propertySize;
	}
	public double getPropertyPrice() {
		return propertyPrice;
	}
	public void setPropertyPrice(double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}
	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyAddress=" + propertyAddress + ", numberOfBedrooms="
				+ numberOfBedrooms + ", propertySize=" + propertySize + ", propertyPrice=" + propertyPrice + "]";
	}
	
    
}
