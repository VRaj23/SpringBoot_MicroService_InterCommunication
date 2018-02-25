package varadraj.springdata.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public List<Customer> getAllCustomer(){
		List<Customer> customers = new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}
	
	public void deleteCustomer(long id) {
		customerRepo.delete(id);
	}
	
	public double getBalance(long id) {
		return customerRepo.findOne(id).getBalance();
	}
	
	public void updateBalance(long id, double balance) {
		Customer temp = customerRepo.findOne(id);
		temp.setBalance(balance);
		customerRepo.save(temp);
	}
	
	public boolean customerExists(long id) {
		if (customerRepo.findOne(id)==null)
			return false;
		return true;
	}
}
