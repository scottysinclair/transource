package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


import scott.transource.model.WorkType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class WorkItemDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private String name;
  private WorkType workType;
  private String description;
  private DtoList<BillableWorkDto> billableWork = new DtoList<>();
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public DtoList<BillableWorkDto> getBillableWork() {
    return billableWork;
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
