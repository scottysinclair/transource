package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.ServiceProviderContract;
import java.util.Date;
import scott.transource.query.QFeedback;
import scott.transource.query.QServiceProvider;
import scott.transource.query.QWorkItem;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QServiceProviderContract extends QueryObject<ServiceProviderContract> {
  private static final long serialVersionUID = 1L;
  public QServiceProviderContract() {
    super(ServiceProviderContract.class);
  }

  public QServiceProviderContract(QueryObject<?> parent) {
    super(ServiceProviderContract.class, parent);
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

  public QProperty<Long> serviceProviderId() {
    return new QProperty<Long>(this, "serviceProvider");
  }

  public QServiceProvider joinToServiceProvider() {
    QServiceProvider serviceProvider = new QServiceProvider();
    addLeftOuterJoin(serviceProvider, "serviceProvider");
    return serviceProvider;
  }

  public QServiceProvider joinToServiceProvider(JoinType joinType) {
    QServiceProvider serviceProvider = new QServiceProvider();
    addJoin(serviceProvider, "serviceProvider", joinType);
    return serviceProvider;
  }

  public QServiceProvider existsServiceProvider() {
    QServiceProvider serviceProvider = new QServiceProvider(this);
    addExists(serviceProvider, "serviceProvider");
    return serviceProvider;
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

  public QProperty<Date> billReceivedDate() {
    return new QProperty<Date>(this, "billReceivedDate");
  }

  public QProperty<Date> paymentSentDate() {
    return new QProperty<Date>(this, "paymentSentDate");
  }
}