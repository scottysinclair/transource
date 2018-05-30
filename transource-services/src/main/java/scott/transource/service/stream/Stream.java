package scott.transource.service.stream;

import java.util.function.Predicate;

import scott.transource.dto.ContractDto;
import scott.transource.model.PartnerType;

public class Stream {

	public static boolean customerContracts(ContractDto c) {
		return c.getPartnerType() == PartnerType.CUSTOMER;
	}

	public static boolean serviceProviderContracts(ContractDto c) {
		return c.getPartnerType() == PartnerType.SERVICE_PROVIDER;
	}

}
