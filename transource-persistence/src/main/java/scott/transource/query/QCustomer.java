package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Customer;
import scott.transource.query.QCustomerContract;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QCustomer extends QueryObject<Customer> {
  private static final long serialVersionUID = 1L;
  public QCustomer() {
    super(Customer.class);
  }

  public QCustomer(QueryObject<?> parent) {
    super(Customer.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<String> firstName() {
    return new QProperty<String>(this, "firstName");
  }

  public QProperty<String> lastName() {
    return new QProperty<String>(this, "lastName");
  }

  public QProperty<String> emailAddress() {
    return new QProperty<String>(this, "emailAddress");
  }

  public QCustomerContract joinToContracts() {
    QCustomerContract contracts = new QCustomerContract();
    addLeftOuterJoin(contracts, "contracts");
    return contracts;
  }

  public QCustomerContract joinToContracts(JoinType joinType) {
    QCustomerContract contracts = new QCustomerContract();
    addJoin(contracts, "contracts", joinType);
    return contracts;
  }

  public QCustomerContract existsContracts() {
    QCustomerContract contracts = new QCustomerContract(this);
    addExists(contracts, "contracts");
    return contracts;
  }
}