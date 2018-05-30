package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.WorkItem;
import scott.transource.model.WorkType;
import scott.transource.query.QBillableWork;
import scott.transource.query.QLanguage;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class QWorkItem extends QueryObject<WorkItem> {
  private static final long serialVersionUID = 1L;
  public QWorkItem() {
    super(WorkItem.class);
  }

  public QWorkItem(QueryObject<?> parent) {
    super(WorkItem.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<scott.transource.model.WorkType> workType() {
    return new QProperty<scott.transource.model.WorkType>(this, "workType");
  }

  public QProperty<String> description() {
    return new QProperty<String>(this, "description");
  }

  public QProperty<Long> customerBillableId() {
    return new QProperty<Long>(this, "customerBillable");
  }

  public QBillableWork joinToCustomerBillable() {
    QBillableWork customerBillable = new QBillableWork();
    addLeftOuterJoin(customerBillable, "customerBillable");
    return customerBillable;
  }

  public QBillableWork joinToCustomerBillable(JoinType joinType) {
    QBillableWork customerBillable = new QBillableWork();
    addJoin(customerBillable, "customerBillable", joinType);
    return customerBillable;
  }

  public QBillableWork existsCustomerBillable() {
    QBillableWork customerBillable = new QBillableWork(this);
    addExists(customerBillable, "customerBillable");
    return customerBillable;
  }

  public QProperty<Long> serviceProviderBillableId() {
    return new QProperty<Long>(this, "serviceProviderBillable");
  }

  public QBillableWork joinToServiceProviderBillable() {
    QBillableWork serviceProviderBillable = new QBillableWork();
    addLeftOuterJoin(serviceProviderBillable, "serviceProviderBillable");
    return serviceProviderBillable;
  }

  public QBillableWork joinToServiceProviderBillable(JoinType joinType) {
    QBillableWork serviceProviderBillable = new QBillableWork();
    addJoin(serviceProviderBillable, "serviceProviderBillable", joinType);
    return serviceProviderBillable;
  }

  public QBillableWork existsServiceProviderBillable() {
    QBillableWork serviceProviderBillable = new QBillableWork(this);
    addExists(serviceProviderBillable, "serviceProviderBillable");
    return serviceProviderBillable;
  }

  public QProperty<Long> fromLanguageId() {
    return new QProperty<Long>(this, "fromLanguage");
  }

  public QLanguage joinToFromLanguage() {
    QLanguage fromLanguage = new QLanguage();
    addLeftOuterJoin(fromLanguage, "fromLanguage");
    return fromLanguage;
  }

  public QLanguage joinToFromLanguage(JoinType joinType) {
    QLanguage fromLanguage = new QLanguage();
    addJoin(fromLanguage, "fromLanguage", joinType);
    return fromLanguage;
  }

  public QLanguage existsFromLanguage() {
    QLanguage fromLanguage = new QLanguage(this);
    addExists(fromLanguage, "fromLanguage");
    return fromLanguage;
  }

  public QProperty<Long> toLanguageId() {
    return new QProperty<Long>(this, "toLanguage");
  }

  public QLanguage joinToToLanguage() {
    QLanguage toLanguage = new QLanguage();
    addLeftOuterJoin(toLanguage, "toLanguage");
    return toLanguage;
  }

  public QLanguage joinToToLanguage(JoinType joinType) {
    QLanguage toLanguage = new QLanguage();
    addJoin(toLanguage, "toLanguage", joinType);
    return toLanguage;
  }

  public QLanguage existsToLanguage() {
    QLanguage toLanguage = new QLanguage(this);
    addExists(toLanguage, "toLanguage");
    return toLanguage;
  }
}