package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;


import scott.transource.model.WorkType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class LanguageConversionSkillDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private ServiceProviderDto serviceProvider;
  private LanguageDto from;
  private LanguageDto to;
  private WorkType workType;
  private Integer competency;

  public LanguageConversionSkillDto() {
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

  public ServiceProviderDto getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(ServiceProviderDto serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public LanguageDto getFrom() {
    return from;
  }

  public void setFrom(LanguageDto from) {
    this.from = from;
  }

  public LanguageDto getTo() {
    return to;
  }

  public void setTo(LanguageDto to) {
    this.to = to;
  }

  public scott.transource.model.WorkType getWorkType() {
    return workType;
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType = workType;
  }

  public Integer getCompetency() {
    return competency;
  }

  public void setCompetency(Integer competency) {
    this.competency = competency;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
