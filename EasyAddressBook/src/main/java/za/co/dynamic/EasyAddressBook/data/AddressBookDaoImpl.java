/**
 * 
 */
package za.co.dynamic.EasyAddressBook.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.dynamic.EasyAddressBook.model.AddressBook;

/**
 * @author hlayisanishivambe
 *
 */

@Repository
@Transactional
@Service
public class AddressBookDaoImpl implements AddressBookDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public AddressBook addAddressBook(AddressBook phoneBook) {

		em.persist(phoneBook);

		return phoneBook;

	}

	@Override
	public List<AddressBook> getAll() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AddressBook> queryCriteria = cb.createQuery(AddressBook.class);
		Root<AddressBook> addressBook = queryCriteria.from(AddressBook.class);

		//include when ordering by value 
		// criteria.select(addressBook).orderBy(cb.asc(addressBook.get("name")));
		return em.createQuery(queryCriteria).getResultList();

	}

	@Override
	public AddressBook getAddressbyId(long id) {

		return em.find(AddressBook.class, id);

	}

	@Override
	public AddressBook editAddressBook(AddressBook phoneBook) {
		em.merge(phoneBook);

		return phoneBook;
	}

	@Override
	public void deleteAddresBookRecord(AddressBook addressBook) {
		em.remove(em.contains(addressBook) ? addressBook : em.merge(addressBook));

	}

}
