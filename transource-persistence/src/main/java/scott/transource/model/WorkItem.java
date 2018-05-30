package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class WorkItem extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode workType;
  private final ValueNode description;
  private final RefNodeProxyHelper customerBillable;
  private final RefNodeProxyHelper serviceProviderBillable;
  private final RefNodeProxyHelper fromLanguage;
  private final RefNodeProxyHelper toLanguage;

  public WorkItem(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    workType = entity.getChild("workType", ValueNode.class, true);
    description = entity.getChild("description", ValueNode.class, true);
    customerBillable = new RefNodeProxyHelper(entity.getChild("customerBillable", RefNode.class, true));
    serviceProviderBillable = new RefNodeProxyHelper(entity.getChild("serviceProviderBillable", RefNode.class, true));
    fromLanguage = new RefNodeProxyHelper(entity.getChild("fromLanguage", RefNode.class, true));
    toLanguage = new RefNodeProxyHelper(entity.getChild("toLanguage", RefNode.class, true));
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

  public scott.transource.model.WorkType getWorkType() {
    return workType.getValue();
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType.setValue(workType);
  }

  public String getDescription() {
    return description.getValue();
  }

  public void setDescription(String description) {
    this.description.setValue(description);
  }

  public BillableWork getCustomerBillable() {
    return super.getFromRefNode(customerBillable.refNode);
  }

  public void setCustomerBillable(BillableWork customerBillable) {
    setToRefNode(this.customerBillable.refNode, customerBillable);
  }

  public BillableWork getServiceProviderBillable() {
    return super.getFromRefNode(serviceProviderBillable.refNode);
  }

  public void setServiceProviderBillable(BillableWork serviceProviderBillable) {
    setToRefNode(this.serviceProviderBillable.refNode, serviceProviderBillable);
  }

  public Language getFromLanguage() {
    return super.getFromRefNode(fromLanguage.refNode);
  }

  public void setFromLanguage(Language fromLanguage) {
    setToRefNode(this.fromLanguage.refNode, fromLanguage);
  }

  public Language getToLanguage() {
    return super.getFromRefNode(toLanguage.refNode);
  }

  public void setToLanguage(Language toLanguage) {
    setToRefNode(this.toLanguage.refNode, toLanguage);
  }
}
