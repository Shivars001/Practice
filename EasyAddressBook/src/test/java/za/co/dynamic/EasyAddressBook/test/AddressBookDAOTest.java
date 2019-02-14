/**
 * 
 */
package za.co.dynamic.EasyAddressBook.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import za.co.dynamic.EasyAddressBook.data.AddressBookDao;
import za.co.dynamic.EasyAddressBook.model.AddressBook;

/**
 * @author hlayisanishivambe
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AddressBookDAOTest {

	@Autowired
	AddressBookDao addresbook;

	@Test
	public void shouldAddNewAddress() {
		AddressBook addressBook = new AddressBook();
		addressBook.setEmail("jane.doe@doe.com");
		addressBook.setName("Jane Doe");
		addressBook.setHomeNumber("2125552121");
		addressBook.setMobileNumber("2125552121");
		addressBook.setWorkNumber("2125552121");
		addressBook.setAddress("12 mabongo street, johannesburg, 2000");

		addresbook.addAddressBook(addressBook);
		Long id = addressBook.getId();
		System.out.println(id + "Id found");
		assertNotNull(id);

		assertEquals(5, addresbook.getAll().size());
		AddressBook newAddress = addresbook.getAddressbyId(id);

		assertEquals("Jane Doe", newAddress.getName());
		assertEquals("jane.doe@doe.com", newAddress.getEmail());
		assertEquals("2125552121", newAddress.getHomeNumber());
		return;
	}

	@Test
	public void shouldFindAddressById() {
		AddressBook address = addresbook.getAddressbyId(0);

		assertEquals("John Smith", address.getName());
		assertEquals("john.smith@mnator.com", address.getEmail());
		assertEquals("2125551212", address.getMobileNumber());
		return;
	}

}
