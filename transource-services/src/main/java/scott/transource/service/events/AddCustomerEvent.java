package scott.transource.service.events;

import scott.transource.dto.CustomerDto;

public class AddCustomerEvent {

	private final CustomerDto customer;

	public AddCustomerEvent(CustomerDto customer) {
		this.customer = customer;
	}

	public CustomerDto getCustomer() {
		return customer;
	}
	
}
