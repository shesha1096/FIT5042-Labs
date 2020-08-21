package fit5042.tutex.calculator;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import java.util.logging.Level;
import java.util.logging.Logger;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Property;

@Stateful
public class ComparePropertySessionBean implements CompareProperty {
	
	@EJB
	private PropertyRepository propertyRepository;

	@Override
	public void addProperty(Property property) {
		// TODO Auto-generated method stub
		try {
        	propertyRepository.addProperty(property);
        } catch (Exception ex) {
            Logger.getLogger(ComparePropertySessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public void removeProperty(Property property) {
		// TODO Auto-generated method stub
		int propertyId = property.getPropertyId();
		try {
        	propertyRepository.removeProperty(propertyId);
        } catch (Exception ex) {
            Logger.getLogger(ComparePropertySessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	@Override
	public int getBestPerRoom() {
		// TODO Auto-generated method stub
		return 0;
	}

}
