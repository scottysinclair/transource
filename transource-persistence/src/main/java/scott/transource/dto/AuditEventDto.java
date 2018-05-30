package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import java.util.Date;

import scott.transource.model.AuditEventType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class AuditEventDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private Date dateCreated;
  private AuditEventType eventType;
  private CustomerContractDto customerContract;
  private ServiceProviderContractDto serviceProvider;
  private WorkItemDto workItem;
  private String info;

  public AuditEventDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Long modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public scott.transource.model.AuditEventType getEventType() {
    return eventType;
  }

  public void setEventType(scott.transource.model.AuditEventType eventType) {
    this.eventType = eventType;
  }

  public CustomerContractDto getCustomerContract() {
    return customerContract;
  }

  public void setCustomerContract(CustomerContractDto customerContract) {
    this.customerContract = customerContract;
  }

  public ServiceProviderContractDto getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(ServiceProviderContractDto serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public WorkItemDto getWorkItem() {
    return workItem;
  }

  public void setWorkItem(WorkItemDto workItem) {
    this.workItem = workItem;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
