package scott.transource.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContactPersonDto;
import scott.transource.dto.ContractDto;
import scott.transource.dto.WorkItemDto;
import scott.transource.model.PartnerType;
import scott.transource.service.TransourceReportingService;
import scott.transource.service.dto.FullSummaryReport;

public class FakeTransourceReportingServiceImpl implements TransourceReportingService {

  @Override
  public FullSummaryReport getFullSummaryReport() {
    FullSummaryReport report = new FullSummaryReport();
    report.setOverdueContracts(Arrays.asList(
        overdueContract(PartnerType.SERVICE_PROVIDER),
        overdueContract(PartnerType.SERVICE_PROVIDER),
        overdueContract(PartnerType.SERVICE_PROVIDER),
        overdueContract(PartnerType.SERVICE_PROVIDER),
        overdueContract(PartnerType.CUSTOMER),
        overdueContract(PartnerType.CUSTOMER),
        overdueContract(PartnerType.CUSTOMER),
        overdueContract(PartnerType.CUSTOMER)));

    report.setOverdueWork(Arrays.asList(
        new BillableWorkDto(),
        new BillableWorkDto(),
        new BillableWorkDto(),
        new BillableWorkDto(),
        new BillableWorkDto(),
        new BillableWorkDto()));

    report.setActiveContracts(100);
    return report;
  }

  @Override
  public List<BillableWorkDto> getOpenBillableWork(boolean orderByMostRecent) {
    return Arrays.asList(newBillableWorkDto(-6), newBillableWorkDto(2), newBillableWorkDto(3));
  }

    @Override
  public int calculateContractValue(ContractDto contract) {
    return (int)(Math.random() * 10000d);
  }

  @Override
  public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst) {
    return Arrays.asList(
        newOpenContract(1),
        newOpenContract(2),
        newOpenContract(3),
        newOpenContract(4),
        newOpenContract(5),
        newOpenContract(6));

  }

  @Override
  public ContractDto loadFullContract(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  private ContractDto newOpenContract(int i) {
    ContractDto c = new ContractDto();
    c.setName("HDBC Conference " + i);
    c.setDueDate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * i)));
    c.setCreatedDate(new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24)));
    return c;
  }

  private BillableWorkDto newBillableWorkDto(int i) {
    BillableWorkDto b = new BillableWorkDto();
    b.setStartedDate(new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24)));
    b.setDueDate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * i)));
    b.setWorkItem(new WorkItemDto());
    b.getWorkItem().setDescription("Description " + i);
    b.setContact(newPerson(i));
    return b;
  }

  private ContactPersonDto newPerson(int i) {
    ContactPersonDto cp = new ContactPersonDto();
    cp.setFirstName("Scott");
    cp.setLastName("Sinclair " + i);
    return cp;
  }

  private ContractDto overdueContract(PartnerType pt) {
    ContractDto c = new ContractDto();
    c.setPartnerType(pt);
    return c;
  }
  @Override
  public Long getCustomerContractIdForBillableWork(BillableWorkDto billableWork)
      throws SortServiceProviderException, BarleyDBQueryException {
    // TODO Auto-generated method stub
    return null;
  }

}
