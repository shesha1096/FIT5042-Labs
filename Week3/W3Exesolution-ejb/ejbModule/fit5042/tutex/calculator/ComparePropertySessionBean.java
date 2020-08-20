package fit5042.tutex.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Property;

@Stateful
public class ComparePropertySessionBean implements CompareProperty{

	
	private Set<Property> list;
	
	public ComparePropertySessionBean()
	{
		list = new HashSet<>();
	}
	@Override
	public void addProperty(Property property) {
		// TODO Auto-generated method stub
		list.add(property);
		
	}

	@Override
	public void removeProperty(Property property) {
		// TODO Auto-generated method stub
		for (Property p : list)
		{
			if (property.getPropertyId() == p.getPropertyId())
			{
				list.remove(p);
				break;
			}
		}
		
	}

	@Override
	public int getBestPerRoom() {
		// TODO Auto-generated method stub
		int bestId = 0;
		int numberOfRooms = 0;
		double price = 0.0;
		double bestPerRoom = 1000000.0;
		for (Property p : list)
		{
		numberOfRooms = p.getNumberOfBedrooms();
		price = p.getPrice();
		if (price / numberOfRooms < bestPerRoom)
		{
		bestPerRoom = price / numberOfRooms;
		bestId = p.getPropertyId();
		}

		}
		return bestId;
	}


}
