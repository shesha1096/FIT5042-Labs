package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.annotation.ManagedProperty;

import java.util.logging.Level;
import java.util.logging.Logger;

import fit5042.tutex.repository.constants.CommonInstance;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {
	private ArrayList<Property> propertyList;
	@EJB
	private PropertyRepository propertyRepository;
	
	
	public JPAPropertyRepositoryImpl() {
    	propertyList = new ArrayList<Property>();
    	this.initialisePropertyList();
    }
	
	public void initialisePropertyList() {
    	propertyList.clear();
    	
    	propertyList.add(CommonInstance.PROPERTY_FIRST);
    	propertyList.add(CommonInstance.PROPERTY_SECOND);
    	propertyList.add(CommonInstance.PROPERTY_THIRD);
    	propertyList.add(CommonInstance.PROPERTY_FOURTH);
    }

	public ArrayList<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	public void removeProperty(int propertyId) {
    	for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			propertyList.remove(p);
    			break;
    		}
    	}
    	
    }
    
    public void addProperty(Property property) {
    	propertyList.add(property);
    }
    
    public void editProperty(Property property) {
    	for (Property p : propertyList) {
    		int id = property.getPropertyId();
    		if (p.getPropertyId() == id) {
    			propertyList.set(id, property);
    			break;
    		}
    	}
    }

	public int getPropertyId() {
		return propertyList.get(propertyList.size() - 1).getPropertyId();
	}
	
	public Property searchPropertyById(int propertyId) {
		for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			return p;
    		}
    	}
		return null;
	}
	
	public List<ContactPerson> getAllContactPeople() {
		Set<ContactPerson> contactPersonSet = new HashSet<>();
		
		//This method will returns all the contact person in a list without duplication
        //Please write your code here
		List<ContactPerson> contactPersonList = new ArrayList<>();
		contactPersonList = propertyRepository.getAllContactPeople();
		return contactPersonList;
	}
	
	public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) {
		Set<Property> propertySet = new HashSet<>();
		int contactPersonId = contactPerson.getConactPersonId();
        //This method will find all the properties which belong to the particular contact person
		//Please write your code here
		try {
            //retrieve contact person by id
            for (ContactPerson contactPersonObj : propertyRepository.getAllContactPeople()) {
                if (contactPersonObj.getConactPersonId() == contactPersonId) {
                    return propertyRepository.searchPropertyByContactPerson(contactPerson);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JPAPropertyRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
		
	}
	
	public List<Property> searchPropertyByBudget(double budget) {
		try {
            return propertyRepository.searchPropertyByBudget(budget);
        } catch (Exception ex) {
            Logger.getLogger(JPAPropertyRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
