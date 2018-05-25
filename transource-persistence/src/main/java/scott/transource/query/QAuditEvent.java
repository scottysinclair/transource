package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.AuditEvent;
import java.util.Date;
import scott.transource.model.AuditEventType;
import scott.transource.query.QCustomerContract;
import scott.transource.query.QServiceProviderContract;
import scott.transource.query.QWorkItem;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class QAuditEvent extends QueryObject<AuditEvent> {
  private static final long serialVersionUID = 1L;
  public QAuditEvent() {
    super(AuditEvent.class);
  }

  public QAuditEvent(QueryObject<?> parent) {
    super(AuditEvent.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<Date> dateCreated() {
    return new QProperty<Date>(this, "dateCreated");
  }

  public QProperty<scott.transource.model.AuditEventType> eventType() {
    return new QProperty<scott.transource.model.AuditEventType>(this, "eventType");
  }

  public QProperty<Long> customerContractId() {
    return new QProperty<Long>(this, "customerContract");
  }

  public QCustomerContract joinToCustomerContract() {
    QCustomerContract customerContract = new QCustomerContract();
    addLeftOuterJoin(customerContract, "customerContract");
    return customerContract;
  }

  public QCustomerContract joinToCustomerContract(JoinType joinType) {
    QCustomerContract customerContract = new QCustomerContract();
    addJoin(customerContract, "customerContract", joinType);
    return customerContract;
  }

  public QCustomerContract existsCustomerContract() {
    QCustomerContract customerContract = new QCustomerContract(this);
    addExists(customerContract, "customerContract");
    return customerContract;
  }

  public QProperty<Long> serviceProviderId() {
    return new QProperty<Long>(this, "serviceProvider");
  }

  public QServiceProviderContract joinToServiceProvider() {
    QServiceProviderContract serviceProvider = new QServiceProviderContract();
    addLeftOuterJoin(serviceProvider, "serviceProvider");
    return serviceProvider;
  }

  public QServiceProviderContract joinToServiceProvider(JoinType joinType) {
    QServiceProviderContract serviceProvider = new QServiceProviderContract();
    addJoin(serviceProvider, "serviceProvider", joinType);
    return serviceProvider;
  }

  public QServiceProviderContract existsServiceProvider() {
    QServiceProviderContract serviceProvider = new QServiceProviderContract(this);
    addExists(serviceProvider, "serviceProvider");
    return serviceProvider;
  }

  public QProperty<Long> workItemId() {
    return new QProperty<Long>(this, "workItem");
  }

  public QWorkItem joinToWorkItem() {
    QWorkItem workItem = new QWorkItem();
    addLeftOuterJoin(workItem, "workItem");
    return workItem;
  }

  public QWorkItem joinToWorkItem(JoinType joinType) {
    QWorkItem workItem = new QWorkItem();
    addJoin(workItem, "workItem", joinType);
    return workItem;
  }

  public QWorkItem existsWorkItem() {
    QWorkItem workItem = new QWorkItem(this);
    addExists(workItem, "workItem");
    return workItem;
  }

  public QProperty<String> info() {
    return new QProperty<String>(this, "info");
  }
}