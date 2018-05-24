package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class WorkItem extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final RefNodeProxyHelper customerContract;
  private final ValueNode custChargeType;
  private final ValueNode custChargeAmount;
  private final RefNodeProxyHelper fromLanguage;
  private final RefNodeProxyHelper toLanguage;
  private final ValueNode workType;
  private final RefNodeProxyHelper serviceProviderContract;
  private final ValueNode spChargeType;
  private final ValueNode spChargeAmount;
  private final ValueNode description;
  private final ValueNode completed;

  public WorkItem(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    customerContract = new RefNodeProxyHelper(entity.getChild("customerContract", RefNode.class, true));
    custChargeType = entity.getChild("custChargeType", ValueNode.class, true);
    custChargeAmount = entity.getChild("custChargeAmount", ValueNode.class, true);
    fromLanguage = new RefNodeProxyHelper(entity.getChild("fromLanguage", RefNode.class, true));
    toLanguage = new RefNodeProxyHelper(entity.getChild("toLanguage", RefNode.class, true));
    workType = entity.getChild("workType", ValueNode.class, true);
    serviceProviderContract = new RefNodeProxyHelper(entity.getChild("serviceProviderContract", RefNode.class, true));
    spChargeType = entity.getChild("spChargeType", ValueNode.class, true);
    spChargeAmount = entity.getChild("spChargeAmount", ValueNode.class, true);
    description = entity.getChild("description", ValueNode.class, true);
    completed = entity.getChild("completed", ValueNode.class, true);
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

  public CustomerContract getCustomerContract() {
    return super.getFromRefNode(customerContract.refNode);
  }

  public void setCustomerContract(CustomerContract customerContract) {
    setToRefNode(this.customerContract.refNode, customerContract);
  }

  public scott.transource.model.ChargeType getCustChargeType() {
    return custChargeType.getValue();
  }

  public void setCustChargeType(scott.transource.model.ChargeType custChargeType) {
    this.custChargeType.setValue(custChargeType);
  }

  public Integer getCustChargeAmount() {
    return custChargeAmount.getValue();
  }

  public void setCustChargeAmount(Integer custChargeAmount) {
    this.custChargeAmount.setValue(custChargeAmount);
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

  public scott.transource.model.WorkType getWorkType() {
    return workType.getValue();
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType.setValue(workType);
  }

  public ServiceProviderContract getServiceProviderContract() {
    return super.getFromRefNode(serviceProviderContract.refNode);
  }

  public void setServiceProviderContract(ServiceProviderContract serviceProviderContract) {
    setToRefNode(this.serviceProviderContract.refNode, serviceProviderContract);
  }

  public scott.transource.model.ChargeType getSpChargeType() {
    return spChargeType.getValue();
  }

  public void setSpChargeType(scott.transource.model.ChargeType spChargeType) {
    this.spChargeType.setValue(spChargeType);
  }

  public Integer getSpChargeAmount() {
    return spChargeAmount.getValue();
  }

  public void setSpChargeAmount(Integer spChargeAmount) {
    this.spChargeAmount.setValue(spChargeAmount);
  }

  public String getDescription() {
    return description.getValue();
  }

  public void setDescription(String description) {
    this.description.setValue(description);
  }

  public Boolean getCompleted() {
    return completed.getValue();
  }

  public void setCompleted(Boolean completed) {
    this.completed.setValue(completed);
  }
}
