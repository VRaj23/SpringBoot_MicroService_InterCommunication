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
}
