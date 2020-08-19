package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;

public interface CompareProperty {
	public void addProperty(Property property);
	public void removeProperty(Property property);
	public int getBestPerRoom();

}
