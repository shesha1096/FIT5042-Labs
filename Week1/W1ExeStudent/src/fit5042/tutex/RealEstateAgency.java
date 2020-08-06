package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Junyang
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    // this method is for initializing the property objects
    // complete this method
    public void createProperty() {
    	try {
			this.propertyRepository.addProperty(new Property(1,"5 Maroona Road",2,100,500000));
			this.propertyRepository.addProperty(new Property(2,"6 Maroona Road",2,100,500000));
			this.propertyRepository.addProperty(new Property(3,"7 Maroona Road",2,100,500000));
			this.propertyRepository.addProperty(new Property(4,"8 Maroona Road",2,100,500000));
			this.propertyRepository.addProperty(new Property(5,"9 Maroona Road",2,100,500000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    // this method is for displaying all the properties
    // complete this method
    public void displayProperties() {
    	try {
			List<Property> listOfProperties = this.propertyRepository.getAllProperties();
			for (Property property: listOfProperties)
			{
				System.out.println(property.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
    }
    
    // this method is for searching the property by ID
    // complete this method
    public void searchPropertyById() {
    	System.out.println("Enter the property that you want to search for:");
    	String propertyId = new Scanner(System.in).nextLine();
    	try {
			if (this.propertyRepository.searchPropertyById(Integer.valueOf(propertyId)) != null)
			{
				System.out.println("Property Found");
			}
			else
			{
				System.out.println("Property Not Found");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void run() {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        searchPropertyById();
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
