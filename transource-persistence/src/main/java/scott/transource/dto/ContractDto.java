package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


import scott.transource.model.PartnerType;
import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class ContractDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private String name;
  private String description;
  private PartnerDto partner;
  private PartnerType partnerType;
  private DtoList<BillableWorkDto> billableWork = new DtoList<>();
  private Date createdDate;
  private Date dueDate;
  private Date completedDate;
  private Date billedDate;
  private Date payedDate;
  private FeedbackDto feedback;

  public ContractDto() {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PartnerDto getPartner() {
    return partner;
  }

  public void setPartner(PartnerDto partner) {
    this.partner = partner;
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }

  public DtoList<BillableWorkDto> getBillableWork() {
    return billableWork;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
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

  public Date getBilledDate() {
    return billedDate;
  }

  public void setBilledDate(Date billedDate) {
    this.billedDate = billedDate;
  }

  public Date getPayedDate() {
    return payedDate;
  }

  public void setPayedDate(Date payedDate) {
    this.payedDate = payedDate;
  }

  public FeedbackDto getFeedback() {
    return feedback;
  }

  public void setFeedback(FeedbackDto feedback) {
    this.feedback = feedback;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
