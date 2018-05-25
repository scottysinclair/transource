package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.CustomerContract;
import java.util.Date;
import scott.transource.query.QFeedback;
import scott.transource.query.QCustomer;
import scott.transource.query.QWorkItem;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class QCustomerContract extends QueryObject<CustomerContract> {
  private static final long serialVersionUID = 1L;
  public QCustomerContract() {
    super(CustomerContract.class);
  }

  public QCustomerContract(QueryObject<?> parent) {
    super(CustomerContract.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<Date> createdDate() {
    return new QProperty<Date>(this, "createdDate");
  }

  public QProperty<Date> etimatedCompletionDate() {
    return new QProperty<Date>(this, "etimatedCompletionDate");
  }

  public QProperty<Date> actualCompletionDate() {
    return new QProperty<Date>(this, "actualCompletionDate");
  }

  public QProperty<Long> feedbackId() {
    return new QProperty<Long>(this, "feedback");
  }

  public QFeedback joinToFeedback() {
    QFeedback feedback = new QFeedback();
    addLeftOuterJoin(feedback, "feedback");
    return feedback;
  }

  public QFeedback joinToFeedback(JoinType joinType) {
    QFeedback feedback = new QFeedback();
    addJoin(feedback, "feedback", joinType);
    return feedback;
  }

  public QFeedback existsFeedback() {
    QFeedback feedback = new QFeedback(this);
    addExists(feedback, "feedback");
    return feedback;
  }

  public QProperty<Long> customerId() {
    return new QProperty<Long>(this, "customer");
  }

  public QCustomer joinToCustomer() {
    QCustomer customer = new QCustomer();
    addLeftOuterJoin(customer, "customer");
    return customer;
  }

  public QCustomer joinToCustomer(JoinType joinType) {
    QCustomer customer = new QCustomer();
    addJoin(customer, "customer", joinType);
    return customer;
  }

  public QCustomer existsCustomer() {
    QCustomer customer = new QCustomer(this);
    addExists(customer, "customer");
    return customer;
  }

  public QWorkItem joinToWorkItems() {
    QWorkItem workItems = new QWorkItem();
    addLeftOuterJoin(workItems, "workItems");
    return workItems;
  }

  public QWorkItem joinToWorkItems(JoinType joinType) {
    QWorkItem workItems = new QWorkItem();
    addJoin(workItems, "workItems", joinType);
    return workItems;
  }

  public QWorkItem existsWorkItems() {
    QWorkItem workItems = new QWorkItem(this);
    addExists(workItems, "workItems");
    return workItems;
  }

  public QProperty<Date> billSentDate() {
    return new QProperty<Date>(this, "billSentDate");
  }

  public QProperty<Date> paymentReceivedDate() {
    return new QProperty<Date>(this, "paymentReceivedDate");
  }
}