package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class WorkSize extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode units;
  private final ValueNode size;

  public WorkSize(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    units = entity.getChild("units", ValueNode.class, true);
    size = entity.getChild("size", ValueNode.class, true);
  }

  public Long getId() {
    return id.getValue();
  }

  public Long getModifiedAt() {
    return modifiedAt.getValue();
  }

  public void setModifiedAt(Long modifiedAt) {
    this.modifiedAt.setValue(modifiedAt);
  }

  public String getUnits() {
    return units.getValue();
  }

  public void setUnits(String units) {
    this.units.setValue(units);
  }

  public String getSize() {
    return size.getValue();
  }

  public void setSize(String size) {
    this.size.setValue(size);
  }
}
