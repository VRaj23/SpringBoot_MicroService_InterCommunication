package varadraj.springdata.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String addOrder(@RequestBody Orders order) {
		return orderService.addOrder(order);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
	}
}
