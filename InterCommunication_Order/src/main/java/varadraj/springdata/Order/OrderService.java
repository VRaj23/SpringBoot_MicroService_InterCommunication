package varadraj.springdata.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	
	public String addOrder(Orders order) {
		orderRepo.save(order);
		return "Order Added";
	}
	
	public List<Orders> getAllOrders(){
		List<Orders> orders = new ArrayList<>();
		orderRepo.findAll().forEach(orders::add);
		return orders;		
	}

}
