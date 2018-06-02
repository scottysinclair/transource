package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;


import scott.transource.model.PartnerType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class CustomerDto extends PartnerDto {
  private static final long serialVersionUID = 1L;

  private PartnerType partnerType;

  public CustomerDto() {
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
