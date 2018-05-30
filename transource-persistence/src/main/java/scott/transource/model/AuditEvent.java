package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;
import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class AuditEvent extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode dateCreated;
  private final ValueNode eventType;
  private final RefNodeProxyHelper customerContract;
  private final RefNodeProxyHelper serviceProvider;
  private final RefNodeProxyHelper workItem;
  private final ValueNode info;

  public AuditEvent(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    dateCreated = entity.getChild("dateCreated", ValueNode.class, true);
    eventType = entity.getChild("eventType", ValueNode.class, true);
    customerContract = new RefNodeProxyHelper(entity.getChild("customerContract", RefNode.class, true));
    serviceProvider = new RefNodeProxyHelper(entity.getChild("serviceProvider", RefNode.class, true));
    workItem = new RefNodeProxyHelper(entity.getChild("workItem", RefNode.class, true));
    info = entity.getChild("info", ValueNode.class, true);
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

  public Date getDateCreated() {
    return dateCreated.getValue();
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated.setValue(dateCreated);
  }

  public scott.transource.model.AuditEventType getEventType() {
    return eventType.getValue();
  }

  public void setEventType(scott.transource.model.AuditEventType eventType) {
    this.eventType.setValue(eventType);
  }

  public CustomerContract getCustomerContract() {
    return super.getFromRefNode(customerContract.refNode);
  }

  public void setCustomerContract(CustomerContract customerContract) {
    setToRefNode(this.customerContract.refNode, customerContract);
  }

  public ServiceProviderContract getServiceProvider() {
    return super.getFromRefNode(serviceProvider.refNode);
  }

  public void setServiceProvider(ServiceProviderContract serviceProvider) {
    setToRefNode(this.serviceProvider.refNode, serviceProvider);
  }

  public WorkItem getWorkItem() {
    return super.getFromRefNode(workItem.refNode);
  }

  public void setWorkItem(WorkItem workItem) {
    setToRefNode(this.workItem.refNode, workItem);
  }

  public String getInfo() {
    return info.getValue();
  }

  public void setInfo(String info) {
    this.info.setValue(info);
  }
}
