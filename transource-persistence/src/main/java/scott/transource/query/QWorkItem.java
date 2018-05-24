package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.WorkItem;
import scott.transource.query.QCustomerContract;
import scott.transource.model.ChargeType;
import scott.transource.query.QLanguage;
import scott.transource.model.WorkType;
import scott.transource.query.QServiceProviderContract;

/**
 * Generated from Entity Specification
 *
 * @author scott
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

  public QProperty<scott.transource.model.ChargeType> custChargeType() {
    return new QProperty<scott.transource.model.ChargeType>(this, "custChargeType");
  }

  public QProperty<Integer> custChargeAmount() {
    return new QProperty<Integer>(this, "custChargeAmount");
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

  public QProperty<scott.transource.model.WorkType> workType() {
    return new QProperty<scott.transource.model.WorkType>(this, "workType");
  }

  public QProperty<Long> serviceProviderContractId() {
    return new QProperty<Long>(this, "serviceProviderContract");
  }

  public QServiceProviderContract joinToServiceProviderContract() {
    QServiceProviderContract serviceProviderContract = new QServiceProviderContract();
    addLeftOuterJoin(serviceProviderContract, "serviceProviderContract");
    return serviceProviderContract;
  }

  public QServiceProviderContract joinToServiceProviderContract(JoinType joinType) {
    QServiceProviderContract serviceProviderContract = new QServiceProviderContract();
    addJoin(serviceProviderContract, "serviceProviderContract", joinType);
    return serviceProviderContract;
  }

  public QServiceProviderContract existsServiceProviderContract() {
    QServiceProviderContract serviceProviderContract = new QServiceProviderContract(this);
    addExists(serviceProviderContract, "serviceProviderContract");
    return serviceProviderContract;
  }

  public QProperty<scott.transource.model.ChargeType> spChargeType() {
    return new QProperty<scott.transource.model.ChargeType>(this, "spChargeType");
  }

  public QProperty<Integer> spChargeAmount() {
    return new QProperty<Integer>(this, "spChargeAmount");
  }

  public QProperty<String> description() {
    return new QProperty<String>(this, "description");
  }

  public QProperty<Boolean> completed() {
    return new QProperty<Boolean>(this, "completed");
  }
}