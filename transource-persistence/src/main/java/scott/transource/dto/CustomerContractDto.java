package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;

import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class CustomerContractDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private Date createdDate;
  private Date etimatedCompletionDate;
  private Date actualCompletionDate;
  private FeedbackDto feedback;
  private CustomerDto customer;
  private DtoList<WorkItemDto> workItems = new DtoList<>();
  private Date billSentDate;
  private Date paymentReceivedDate;

  public CustomerContractDto() {
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

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getEtimatedCompletionDate() {
    return etimatedCompletionDate;
  }

  public void setEtimatedCompletionDate(Date etimatedCompletionDate) {
    this.etimatedCompletionDate = etimatedCompletionDate;
  }

  public Date getActualCompletionDate() {
    return actualCompletionDate;
  }

  public void setActualCompletionDate(Date actualCompletionDate) {
    this.actualCompletionDate = actualCompletionDate;
  }

  public FeedbackDto getFeedback() {
    return feedback;
  }

  public void setFeedback(FeedbackDto feedback) {
    this.feedback = feedback;
  }

  public CustomerDto getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDto customer) {
    this.customer = customer;
  }

  public DtoList<WorkItemDto> getWorkItems() {
    return workItems;
  }

  public Date getBillSentDate() {
    return billSentDate;
  }

  public void setBillSentDate(Date billSentDate) {
    this.billSentDate = billSentDate;
  }

  public Date getPaymentReceivedDate() {
    return paymentReceivedDate;
  }

  public void setPaymentReceivedDate(Date paymentReceivedDate) {
    this.paymentReceivedDate = paymentReceivedDate;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
