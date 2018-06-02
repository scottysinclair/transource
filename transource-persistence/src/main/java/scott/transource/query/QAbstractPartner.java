package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Partner;
import scott.transource.model.PartnerType;
import scott.transource.query.QContactPerson;
import scott.transource.query.QContract;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
class QAbstractPartner<T extends Partner, CHILD extends QAbstractPartner<T, CHILD>> extends QueryObject<T>{
  private static final long serialVersionUID = 1L;
  protected QAbstractPartner(Class<T> modelClass) {
    super(modelClass);  }

  protected QAbstractPartner(Class<T> modelClass, QueryObject<?> parent) {
    super(modelClass, parent);  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<String> name() {
    return new QProperty<String>(this, "name");
  }

  public QProperty<scott.transource.model.PartnerType> partnerType() {
    return new QProperty<scott.transource.model.PartnerType>(this, "partnerType");
  }

  public QContactPerson joinToContacts() {
    QContactPerson contacts = new QContactPerson();
    addLeftOuterJoin(contacts, "contacts");
    return contacts;
  }

  public QContactPerson joinToContacts(JoinType joinType) {
    QContactPerson contacts = new QContactPerson();
    addJoin(contacts, "contacts", joinType);
    return contacts;
  }

  public QContactPerson existsContacts() {
    QContactPerson contacts = new QContactPerson(this);
    addExists(contacts, "contacts");
    return contacts;
  }

  public QContract joinToContracts() {
    QContract contracts = new QContract();
    addLeftOuterJoin(contracts, "contracts");
    return contracts;
  }

  public QContract joinToContracts(JoinType joinType) {
    QContract contracts = new QContract();
    addJoin(contracts, "contracts", joinType);
    return contracts;
  }

  public QContract existsContracts() {
    QContract contracts = new QContract(this);
    addExists(contracts, "contracts");
    return contracts;
  }
}