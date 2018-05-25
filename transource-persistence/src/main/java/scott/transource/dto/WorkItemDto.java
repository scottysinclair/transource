package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;


import scott.transource.model.ChargeType;
import scott.transource.model.WorkType;
import scott.transource.model.ChargeType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class WorkItemDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private CustomerContractDto customerContract;
  private ChargeType custChargeType;
  private Integer custChargeAmount;
  private LanguageDto fromLanguage;
  private LanguageDto toLanguage;
  private WorkType workType;
  private ServiceProviderContractDto serviceProviderContract;
  private ChargeType spChargeType;
  private Integer spChargeAmount;
  private String description;
  private Boolean completed;

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

  public CustomerContractDto getCustomerContract() {
    return customerContract;
  }

  public void setCustomerContract(CustomerContractDto customerContract) {
    this.customerContract = customerContract;
  }

  public scott.transource.model.ChargeType getCustChargeType() {
    return custChargeType;
  }

  public void setCustChargeType(scott.transource.model.ChargeType custChargeType) {
    this.custChargeType = custChargeType;
  }

  public Integer getCustChargeAmount() {
    return custChargeAmount;
  }

  public void setCustChargeAmount(Integer custChargeAmount) {
    this.custChargeAmount = custChargeAmount;
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

  public scott.transource.model.WorkType getWorkType() {
    return workType;
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType = workType;
  }

  public ServiceProviderContractDto getServiceProviderContract() {
    return serviceProviderContract;
  }

  public void setServiceProviderContract(ServiceProviderContractDto serviceProviderContract) {
    this.serviceProviderContract = serviceProviderContract;
  }

  public scott.transource.model.ChargeType getSpChargeType() {
    return spChargeType;
  }

  public void setSpChargeType(scott.transource.model.ChargeType spChargeType) {
    this.spChargeType = spChargeType;
  }

  public Integer getSpChargeAmount() {
    return spChargeAmount;
  }

  public void setSpChargeAmount(Integer spChargeAmount) {
    this.spChargeAmount = spChargeAmount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
