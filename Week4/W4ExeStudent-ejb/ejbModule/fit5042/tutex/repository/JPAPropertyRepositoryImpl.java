package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    //insert code (annotation) here to use container managed entity manager to complete these methods 
	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        List<Property> properties = entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
        property.setPropertyId(properties.get(0).getPropertyId() + 1);
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        //complete this method
    	Property property = entityManager.find(Property.class, propertyId);
    	entityManager.getTransaction().begin();
    	entityManager.remove(property);
    	entityManager.getTransaction().commit();
    }

    @Override
    public void editProperty(Property property) throws Exception {
        try {
            entityManager.merge(property);
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        //complete this method using Criteria API
    	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Property> criteriaQuery = criteriaBuilder.createQuery(Property.class);
    	Root<Property> property = criteriaQuery.from(Property.class);
    	criteriaQuery.select(property).where(criteriaBuilder.lessThanOrEqualTo(property.get("price").as(Double.class),budget));
    	return ((EntityManager) criteriaQuery).createQuery(criteriaQuery).getResultList();
    }
}
