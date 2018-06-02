package scott.transource.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.dao.TransourceDao;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.model.PartnerType;
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
    return dao.getOpenBillableWorkWithAssocContactAndWorkItem();
  }

  @Override
  public int calculateContractValue(ContractDto contract) {
    return 0;
  }

  @Override
  public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst) throws SortServiceProviderException, BarleyDBQueryException {
    return dao.getOpenCustomerContracts(oldestFirst);
  }

  @Override
  public ContractDto loadFullContract(Long id) throws SortServiceProviderException, BarleyDBQueryException {
    return dao.loadFullContract( id );
  }

  @Override
  public Long getCustomerContractIdForBillableWork(BillableWorkDto billableWork) throws SortServiceProviderException, BarleyDBQueryException {
    List<BillableWorkDto> list = dao.getBillableWorkWithAssocContactAndWorkItemFor(billableWork.getWorkItem())
      .stream()
      .filter(bw -> bw.getPartnerType() == PartnerType.CUSTOMER)
      .collect(Collectors.toList());

    if (list.size() == 1) {
      return list.get(0).getContract().getId();
    }
    else if (list.isEmpty()) {
      return null;
    }
    throw new IllegalStateException("Found more than 1 customer billable for work item " + billableWork.getWorkItem().getId());
  }





}
