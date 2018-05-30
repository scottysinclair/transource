package scott.transource.service;

import scott.transource.service.events.AddCustomerEvent;

public interface TransourceEventService {
	
	void addCustomer(AddCustomerEvent event);

}
