package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


import scott.transource.model.PartnerType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class ServiceProviderDto extends PartnerDto {
  private static final long serialVersionUID = 1L;

  private PartnerType partnerType;
  private DtoList<LanguageConversionSkillDto> languageSkills = new DtoList<>();

  public ServiceProviderDto() {
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }

  public DtoList<LanguageConversionSkillDto> getLanguageSkills() {
    return languageSkills;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
