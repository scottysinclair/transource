package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class ServiceProviderDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private DtoList<LanguageConversionSkillDto> languageSkills = new DtoList<>();
  private DtoList<ServiceProviderContractDto> contracts = new DtoList<>();

  public ServiceProviderDto() {
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public DtoList<LanguageConversionSkillDto> getLanguageSkills() {
    return languageSkills;
  }

  public DtoList<ServiceProviderContractDto> getContracts() {
    return contracts;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + id + "]";
  }
}
