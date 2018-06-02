package scott.transource.dto;

import scott.barleydb.api.dto.BaseDto;

import scott.barleydb.api.dto.DtoList;


import scott.transource.model.PartnerType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class PartnerDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long modifiedAt;
  private String name;
  private PartnerType partnerType;
  private DtoList<ContactPersonDto> contacts = new DtoList<>();
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType;
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType = partnerType;
  }

  public DtoList<ContactPersonDto> getContacts() {
    return contacts;
  }

  public DtoList<ContractDto> getContracts() {
    return contracts;
  }
  public String toString() {
    return getClass().getSimpleName() + "[id = " + getId() + "]";
  }
}
