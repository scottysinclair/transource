package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


import scott.transource.model.PartnerType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class PartnerDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private PartnerType partnerType;
  private ContactPersonDto contact;
  private DtoList<ContractDto> contracts = new DtoList<>();

  public PartnerDto() {
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

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }

  public ContactPersonDto getContact() {
    return contact;
  }

  public void setContact(ContactPersonDto contact) {
    this.contact = contact;
  }

  public DtoList<ContractDto> getContracts() {
    return contracts;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
