package za.co.dynamic.EasyAddressBook.data;

import java.util.List;

import za.co.dynamic.EasyAddressBook.model.AddressBook;

public interface AddressBookDao {
	
	
	
	 public AddressBook addAddressBook( AddressBook phoneBook );
	 public AddressBook editAddressBook( AddressBook phoneBook );
	    public void deleteAddresBookRecord( AddressBook addressBook );
	    public List<AddressBook> getAll();
	    public AddressBook getAddressbyId( long addressId );

}
