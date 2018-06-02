package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class BillableWorkCommentDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private Date commentDate;
  private String content;
  private BillableWorkDto billableWork;

  public BillableWorkCommentDto() {
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

  public Date getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(Date commentDate) {
    this.commentDate = commentDate;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public BillableWorkDto getBillableWork() {
    return billableWork;
  }

  public void setBillableWork(BillableWorkDto billableWork) {
    this.billableWork = billableWork;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
