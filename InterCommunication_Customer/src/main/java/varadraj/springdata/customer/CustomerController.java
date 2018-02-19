package varadraj.springdata.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
	}
}
