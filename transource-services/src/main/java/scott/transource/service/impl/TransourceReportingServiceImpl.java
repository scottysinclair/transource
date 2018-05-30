package scott.transource.service.impl;

import java.util.List;

import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.dao.TransourceDao;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.service.TransourceReportingService;
import scott.transource.service.dto.FullSummaryReport;

public class TransourceReportingServiceImpl implements TransourceReportingService {

  private final TransourceDao dao;


  public TransourceReportingServiceImpl(TransourceDao dao) {
    this.dao = dao;
  }

  @Override
  public FullSummaryReport getFullSummaryReport() throws SortServiceProviderException, BarleyDBQueryException {

    FullSummaryReport report = new FullSummaryReport();

    report.setOverdueContracts( dao.getOverdueContracts() );

    report.setOverdueWork( dao.getOverdueWork() );

    report.setActiveContracts( dao.getActiveContracts().size() );

    return report;
  }

  @Override
  public List<BillableWorkDto> getOpenBillableWork(boolean earliestDue) throws SortServiceProviderException, BarleyDBQueryException {
    return dao.getOpenBillableWork();
  }

  @Override
  public int calculateContractValue(ContractDto contract) {
    return 0;
  }

  @Override
  public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst) throws SortServiceProviderException, BarleyDBQueryException {
    return dao.getOpenCustomerContracts(oldestFirst);
  }


}
