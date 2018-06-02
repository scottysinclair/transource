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
 * @author scott
 */
public class BillableWork extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final RefNodeProxyHelper workItem;
  private final RefNodeProxyHelper contract;
  private final ValueNode commitment;
  private final ValueNode startedDate;
  private final ValueNode partnerType;
  private final RefNodeProxyHelper contact;
  private final RefNodeProxyHelper workSize;
  private final ValueNode chargeType;
  private final ValueNode chargeAmount;
  private final ValueNode dueDate;
  private final ValueNode completedDate;

  public BillableWork(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    workItem = new RefNodeProxyHelper(entity.getChild("workItem", RefNode.class, true));
    contract = new RefNodeProxyHelper(entity.getChild("contract", RefNode.class, true));
    commitment = entity.getChild("commitment", ValueNode.class, true);
    startedDate = entity.getChild("startedDate", ValueNode.class, true);
    partnerType = entity.getChild("partnerType", ValueNode.class, true);
    contact = new RefNodeProxyHelper(entity.getChild("contact", RefNode.class, true));
    workSize = new RefNodeProxyHelper(entity.getChild("workSize", RefNode.class, true));
    chargeType = entity.getChild("chargeType", ValueNode.class, true);
    chargeAmount = entity.getChild("chargeAmount", ValueNode.class, true);
    dueDate = entity.getChild("dueDate", ValueNode.class, true);
    completedDate = entity.getChild("completedDate", ValueNode.class, true);
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

  public WorkItem getWorkItem() {
    return super.getFromRefNode(workItem.refNode);
  }

  public void setWorkItem(WorkItem workItem) {
    setToRefNode(this.workItem.refNode, workItem);
  }

  public Contract getContract() {
    return super.getFromRefNode(contract.refNode);
  }

  public void setContract(Contract contract) {
    setToRefNode(this.contract.refNode, contract);
  }

  public String getCommitment() {
    return commitment.getValue();
  }

  public void setCommitment(String commitment) {
    this.commitment.setValue(commitment);
  }

  public Date getStartedDate() {
    return startedDate.getValue();
  }

  public void setStartedDate(Date startedDate) {
    this.startedDate.setValue(startedDate);
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType.getValue();
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType.setValue(partnerType);
  }

  public ContactPerson getContact() {
    return super.getFromRefNode(contact.refNode);
  }

  public void setContact(ContactPerson contact) {
    setToRefNode(this.contact.refNode, contact);
  }

  public WorkSize getWorkSize() {
    return super.getFromRefNode(workSize.refNode);
  }

  public void setWorkSize(WorkSize workSize) {
    setToRefNode(this.workSize.refNode, workSize);
  }

  public scott.transource.model.ChargeType getChargeType() {
    return chargeType.getValue();
  }

  public void setChargeType(scott.transource.model.ChargeType chargeType) {
    this.chargeType.setValue(chargeType);
  }

  public Integer getChargeAmount() {
    return chargeAmount.getValue();
  }

  public void setChargeAmount(Integer chargeAmount) {
    this.chargeAmount.setValue(chargeAmount);
  }

  public Date getDueDate() {
    return dueDate.getValue();
  }

  public void setDueDate(Date dueDate) {
    this.dueDate.setValue(dueDate);
  }

  public Date getCompletedDate() {
    return completedDate.getValue();
  }

  public void setCompletedDate(Date completedDate) {
    this.completedDate.setValue(completedDate);
  }
}
