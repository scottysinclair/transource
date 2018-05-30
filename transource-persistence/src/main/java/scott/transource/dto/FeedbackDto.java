package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;


import scott.transource.model.FeedbackRating;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class FeedbackDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private FeedbackRating rating;
  private String info;

  public FeedbackDto() {
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

  public scott.transource.model.FeedbackRating getRating() {
    return rating;
  }

  public void setRating(scott.transource.model.FeedbackRating rating) {
    this.rating = rating;
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
