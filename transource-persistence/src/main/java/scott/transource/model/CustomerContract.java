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
public class CustomerContract extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode createdDate;
  private final ValueNode etimatedCompletionDate;
  private final ValueNode actualCompletionDate;
  private final RefNodeProxyHelper feedback;
  private final RefNodeProxyHelper customer;
  private final ToManyNodeProxyHelper workItems;
  private final ValueNode billSentDate;
  private final ValueNode paymentReceivedDate;

  public CustomerContract(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    createdDate = entity.getChild("createdDate", ValueNode.class, true);
    etimatedCompletionDate = entity.getChild("etimatedCompletionDate", ValueNode.class, true);
    actualCompletionDate = entity.getChild("actualCompletionDate", ValueNode.class, true);
    feedback = new RefNodeProxyHelper(entity.getChild("feedback", RefNode.class, true));
    customer = new RefNodeProxyHelper(entity.getChild("customer", RefNode.class, true));
    workItems = new ToManyNodeProxyHelper(entity.getChild("workItems", ToManyNode.class, true));
    billSentDate = entity.getChild("billSentDate", ValueNode.class, true);
    paymentReceivedDate = entity.getChild("paymentReceivedDate", ValueNode.class, true);
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

  public Date getCreatedDate() {
    return createdDate.getValue();
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate.setValue(createdDate);
  }

  public Date getEtimatedCompletionDate() {
    return etimatedCompletionDate.getValue();
  }

  public void setEtimatedCompletionDate(Date etimatedCompletionDate) {
    this.etimatedCompletionDate.setValue(etimatedCompletionDate);
  }

  public Date getActualCompletionDate() {
    return actualCompletionDate.getValue();
  }

  public void setActualCompletionDate(Date actualCompletionDate) {
    this.actualCompletionDate.setValue(actualCompletionDate);
  }

  public Feedback getFeedback() {
    return super.getFromRefNode(feedback.refNode);
  }

  public void setFeedback(Feedback feedback) {
    setToRefNode(this.feedback.refNode, feedback);
  }

  public Customer getCustomer() {
    return super.getFromRefNode(customer.refNode);
  }

  public void setCustomer(Customer customer) {
    setToRefNode(this.customer.refNode, customer);
  }

  public List<WorkItem> getWorkItems() {
    return super.getListProxy(workItems.toManyNode);
  }

  public Date getBillSentDate() {
    return billSentDate.getValue();
  }

  public void setBillSentDate(Date billSentDate) {
    this.billSentDate.setValue(billSentDate);
  }

  public Date getPaymentReceivedDate() {
    return paymentReceivedDate.getValue();
  }

  public void setPaymentReceivedDate(Date paymentReceivedDate) {
    this.paymentReceivedDate.setValue(paymentReceivedDate);
  }
  public ObjectInputStream<WorkItem> streamWorkItems() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = workItems.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<WorkItem> streamWorkItems(QueryObject<WorkItem> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = workItems.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
