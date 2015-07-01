package com.suntossh.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.Address;
import com.suntossh.data.entities.Bank;
import com.suntossh.data.entities.TimeTest;
import com.suntossh.data.entities.User;

public class Application {

	
	public static void main_forBank_Success(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Bank bank = new Bank();
		Address address = new Address();
			bank.setName("BOA");
			bank.setCreatedBy("Santoshkumar");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Santosh");
			bank.setLastUpdatedDate(new Date());
			bank.setInternational(true);
			bank.setAddressType("PRIMARY");

			address.setCity("Jersey City");
			address.setState("NJ");
			address.setAddressLine1("Board walk ");
			address.setAddressLine2("Exchange place");
			address.setZipCode("07310");
			
			bank.setAddress(address);
		
			bank.getContacts().add("Santosh");
			bank.getContacts().add("Pandey");
		session.save(bank);	
		transaction.commit();

		session.close();
	}
	
	public static void main(String[] args) {

		main_forBank_Success(null);
	}
	
}
