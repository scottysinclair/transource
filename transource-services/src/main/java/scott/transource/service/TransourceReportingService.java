package scott.transource.service;

import java.util.List;

import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.service.dto.FullSummaryReport;

public interface TransourceReportingService {

  public FullSummaryReport getFullSummaryReport() throws SortServiceProviderException, BarleyDBQueryException;

  public List<BillableWorkDto> getOpenBillableWork(boolean earliestDue) throws SortServiceProviderException, BarleyDBQueryException;

  public int calculateContractValue(ContractDto contract);

  public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst) throws SortServiceProviderException, BarleyDBQueryException;

  public ContractDto loadFullContract(Long id) throws SortServiceProviderException, BarleyDBQueryException;

  public Long getCustomerContractIdForBillableWork(BillableWorkDto billableWork) throws SortServiceProviderException, BarleyDBQueryException;

}
