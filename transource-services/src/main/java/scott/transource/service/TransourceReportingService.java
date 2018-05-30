package scott.transource.service;

import java.util.Collection;
import java.util.List;

import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.service.dto.FullSummaryReport;

public interface TransourceReportingService {

	public FullSummaryReport getFullSummaryReport();
	
	public List<BillableWorkDto> getOpenBillableWork(boolean earliestDue);

	public int calculateContractValue(ContractDto contract);

	public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst);
	
}
