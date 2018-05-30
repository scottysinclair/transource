package scott.transource.model;

import java.util.List;
import scott.barleydb.api.stream.ObjectInputStream;
import scott.barleydb.api.stream.QueryEntityInputStream;
import scott.barleydb.api.query.QueryObject;
import scott.barleydb.api.stream.EntityStreamException;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;
import scott.barleydb.api.core.entity.ToManyNode;
import scott.barleydb.api.core.proxy.ToManyNodeProxyHelper;
import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class Contract extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode name;
  private final ValueNode description;
  private final RefNodeProxyHelper partner;
  private final ValueNode partnerType;
  private final ToManyNodeProxyHelper billableWork;
  private final ValueNode createdDate;
  private final ValueNode dueDate;
  private final ValueNode completedDate;
  private final ValueNode billedDate;
  private final ValueNode payedDate;
  private final RefNodeProxyHelper feedback;

  public Contract(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    name = entity.getChild("name", ValueNode.class, true);
    description = entity.getChild("description", ValueNode.class, true);
    partner = new RefNodeProxyHelper(entity.getChild("partner", RefNode.class, true));
    partnerType = entity.getChild("partnerType", ValueNode.class, true);
    billableWork = new ToManyNodeProxyHelper(entity.getChild("billableWork", ToManyNode.class, true));
    createdDate = entity.getChild("createdDate", ValueNode.class, true);
    dueDate = entity.getChild("dueDate", ValueNode.class, true);
    completedDate = entity.getChild("completedDate", ValueNode.class, true);
    billedDate = entity.getChild("billedDate", ValueNode.class, true);
    payedDate = entity.getChild("payedDate", ValueNode.class, true);
    feedback = new RefNodeProxyHelper(entity.getChild("feedback", RefNode.class, true));
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

  public String getName() {
    return name.getValue();
  }

  public void setName(String name) {
    this.name.setValue(name);
  }

  public String getDescription() {
    return description.getValue();
  }

  public void setDescription(String description) {
    this.description.setValue(description);
  }

  public Partner getPartner() {
    return super.getFromRefNode(partner.refNode);
  }

  public void setPartner(Partner partner) {
    setToRefNode(this.partner.refNode, partner);
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType.getValue();
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType.setValue(partnerType);
  }

  public List<BillableWork> getBillableWork() {
    return super.getListProxy(billableWork.toManyNode);
  }

  public Date getCreatedDate() {
    return createdDate.getValue();
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate.setValue(createdDate);
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

  public Date getBilledDate() {
    return billedDate.getValue();
  }

  public void setBilledDate(Date billedDate) {
    this.billedDate.setValue(billedDate);
  }

  public Date getPayedDate() {
    return payedDate.getValue();
  }

  public void setPayedDate(Date payedDate) {
    this.payedDate.setValue(payedDate);
  }

  public Feedback getFeedback() {
    return super.getFromRefNode(feedback.refNode);
  }

  public void setFeedback(Feedback feedback) {
    setToRefNode(this.feedback.refNode, feedback);
  }
  public ObjectInputStream<BillableWork> streamBillableWork() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = billableWork.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<BillableWork> streamBillableWork(QueryObject<BillableWork> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = billableWork.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
