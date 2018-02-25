package varadraj.springdata.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	
	public String addOrder(Orders order) {
		CustomerOrderValidation cov = new CustomerOrderValidation(order.getCustomerId(),order.getPrice());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CustomerOrderValidation> request = new HttpEntity<CustomerOrderValidation>(cov,headers);
		RestTemplate checkCustomerBalance = new RestTemplate();
		if (checkCustomerBalance.postForObject("http://localhost:23081/orderValidation/", request,Boolean.class)) {
			orderRepo.save(order);
			return "Order Placed";
		}
		else
			return "Insufficient Balance";
	}
	
	public List<Orders> getAllOrders(){
		List<Orders> orders = new ArrayList<>();
		orderRepo.findAll().forEach(orders::add);
		return orders;		
	}

}
