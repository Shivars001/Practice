package za.co.dynamic.EasyAddressBook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name ="AddressBook",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AddressBook implements Serializable{
	
	
	
	private static final long serialVersionUID = 6571282011445132026L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotNull
    @Size(min = 2, max = 45, message = "name cannot be one character")
    @Pattern(regexp = "[^0-9]*", message = "Name cannot contain numbers")
	 @Column(name = "Full_Names")
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 12,  message = "Phone number cannot be less than 10 digit or more than 12 digits")
    @Digits(fraction = 0, integer = 12)
    @Column(name = "Work_Number")
    private String workNumber;

    
    @NotNull
    @Size(min = 10, max = 12, message = "Phone number cannot be less than 10 digit or more than 12 digits")
    @Digits(fraction = 0, integer = 12)
    @Column(name = "Mobile_Number")
    private String mobileNumber;
    
 
    @Size(min = 10, max = 12, message = "Phone number cannot be less than 10 digit or more than 12 digits")
    @Digits(fraction = 0, integer = 12)
    @Column(name = "Home_Number")
    private String homeNumber;
    
    
    @NotNull
    @Size(min = 5, max = 45)
    @NotEmpty
    @Column(name = "Physical_Address")
    private String address;



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWorkNumber() {
		return workNumber;
	}


	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getHomeNumber() {
		return homeNumber;
	}


	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}


	


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}




}
