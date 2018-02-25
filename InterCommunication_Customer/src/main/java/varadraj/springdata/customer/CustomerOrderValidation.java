package varadraj.springdata.customer;

public class CustomerOrderValidation {

	private long customerID;
	private double orderValue;
	
	public CustomerOrderValidation() {}
	
	public CustomerOrderValidation(long id,double value) {
		this.customerID = id;
		this.orderValue = value;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}	
	
}