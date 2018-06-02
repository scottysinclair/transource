package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class Customer extends Partner {
  private static final long serialVersionUID = 1L;

  private final ValueNode partnerType;

  public Customer(Entity entity) {
    super(entity);
    partnerType = entity.getChild("partnerType", ValueNode.class, true);
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType.getValue();
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType.setValue(partnerType);
  }
}
