package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import java.util.Date;

import scott.transource.model.PartnerType;
import scott.transource.model.ChargeType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class BillableWorkDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private WorkItemDto workItem;
  private ContractDto contract;
  private Date startedDate;
  private PartnerType partnerType;
  private ContactPersonDto contact;
  private ChargeType chargeType;
  private Integer chargeAmount;
  private Date dueDate;
  private Date completedDate;

  public BillableWorkDto() {
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

  public WorkItemDto getWorkItem() {
    return workItem;
  }

  public void setWorkItem(WorkItemDto workItem) {
    this.workItem = workItem;
  }

  public ContractDto getContract() {
    return contract;
  }

  public void setContract(ContractDto contract) {
    this.contract = contract;
  }

  public Date getStartedDate() {
    return startedDate;
  }

  public void setStartedDate(Date startedDate) {
    this.startedDate = startedDate;
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }

  public ContactPersonDto getContact() {
    return contact;
  }

  public void setContact(ContactPersonDto contact) {
    this.contact = contact;
  }

  public scott.transource.model.ChargeType getChargeType() {
    return chargeType;
  }

  public void setChargeType(scott.transource.model.ChargeType chargeType) {
    this.chargeType = chargeType;
  }

  public Integer getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(Integer chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public Date getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(Date completedDate) {
    this.completedDate = completedDate;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
