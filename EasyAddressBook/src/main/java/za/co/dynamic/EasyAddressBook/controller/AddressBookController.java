package za.co.dynamic.EasyAddressBook.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.dynamic.EasyAddressBook.data.AddressBookDao;
import za.co.dynamic.EasyAddressBook.model.AddressBook;

/**
 * @author hlayisanishivambe
 *
 */
@Controller
@RequestMapping("/")
public class AddressBookController {

	@Autowired
	private AddressBookDao adBookDao;

	int addressId = 0;

	// List All Records
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getAddressBookList(ModelAndView model) {
		List<AddressBook> addressBookList = adBookDao.getAll();

		model.addObject("addressBookLists", addressBookList);
		model.setViewName("addressBookList");
		return model;
	}

	// Create new Record
	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public ModelAndView saveNewAddress(ModelAndView model, HttpServletRequest request) {
		AddressBook addressBook = new AddressBook();

		model.addObject("addressBook", addressBook);
		model.setViewName("addressBookForm");
		return model;
	}

	// Save or Update
	@RequestMapping(value = "/updateAddressBook", method = RequestMethod.POST)
	public ModelAndView updateAddressBook(@Valid @ModelAttribute AddressBook addressBook, BindingResult result)
			throws ServletException, IOException, UnexpectedRollbackException {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println("whats in our Id update: " + addressId);

		if (!result.hasErrors()) {
			try {
				if (addressId == 0) {

					adBookDao.addAddressBook(addressBook);

				} else

				{

					addressBook.setId(Long.valueOf(addressId));
					adBookDao.editAddressBook(addressBook);

				}

				addressId = 0;
				return new ModelAndView("redirect:/");

			} catch (UnexpectedRollbackException unx) {

				modelAndView.getModel();

			}

		}
		return new ModelAndView("addressBookForm", modelAndView.getModel());

	}

	// Delete Record
	@RequestMapping(value = "/deleteAddressBookRecord", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest req) {

		addressId = Integer.parseInt(req.getParameter("id"));
		AddressBook existingAddressBook = adBookDao.getAddressbyId(addressId);

		adBookDao.deleteAddresBookRecord(existingAddressBook);
		return new ModelAndView("redirect:/");
	}

	// Edit Record
	@RequestMapping(value = "/editAddressBookRecord", method = RequestMethod.GET)
	public ModelAndView editAddressBookRecord(HttpServletRequest request) {

		addressId = Integer.parseInt(request.getParameter("id"));

		AddressBook existingAddressBook = adBookDao.getAddressbyId(addressId);
		ModelAndView model = new ModelAndView("addressBookForm");
		model.addObject("addressBook", existingAddressBook);

		return model;

	}

}
