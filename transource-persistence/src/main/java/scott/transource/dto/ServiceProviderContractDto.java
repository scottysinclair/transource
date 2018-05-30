package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;

import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class ServiceProviderContractDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private Date createdDate;
  private Date etimatedCompletionDate;
  private Date actualCompletionDate;
  private FeedbackDto feedback;
  private ServiceProviderDto serviceProvider;
  private DtoList<WorkItemDto> workItems = new DtoList<>();
  private Date billReceivedDate;
  private Date paymentSentDate;

  public ServiceProviderContractDto() {
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

  public ServiceProviderDto getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(ServiceProviderDto serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public DtoList<WorkItemDto> getWorkItems() {
    return workItems;
  }

  public Date getBillReceivedDate() {
    return billReceivedDate;
  }

  public void setBillReceivedDate(Date billReceivedDate) {
    this.billReceivedDate = billReceivedDate;
  }

  public Date getPaymentSentDate() {
    return paymentSentDate;
  }

  public void setPaymentSentDate(Date paymentSentDate) {
    this.paymentSentDate = paymentSentDate;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
