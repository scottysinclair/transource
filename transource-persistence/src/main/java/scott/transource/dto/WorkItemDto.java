package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;


import scott.transource.model.WorkType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class WorkItemDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private WorkType workType;
  private String description;
  private BillableWorkDto customerBillable;
  private BillableWorkDto serviceProviderBillable;
  private LanguageDto fromLanguage;
  private LanguageDto toLanguage;

  public WorkItemDto() {
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

  public scott.transource.model.WorkType getWorkType() {
    return workType;
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType = workType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BillableWorkDto getCustomerBillable() {
    return customerBillable;
  }

  public void setCustomerBillable(BillableWorkDto customerBillable) {
    this.customerBillable = customerBillable;
  }

  public BillableWorkDto getServiceProviderBillable() {
    return serviceProviderBillable;
  }

  public void setServiceProviderBillable(BillableWorkDto serviceProviderBillable) {
    this.serviceProviderBillable = serviceProviderBillable;
  }

  public LanguageDto getFromLanguage() {
    return fromLanguage;
  }

  public void setFromLanguage(LanguageDto fromLanguage) {
    this.fromLanguage = fromLanguage;
  }

  public LanguageDto getToLanguage() {
    return toLanguage;
  }

  public void setToLanguage(LanguageDto toLanguage) {
    this.toLanguage = toLanguage;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
