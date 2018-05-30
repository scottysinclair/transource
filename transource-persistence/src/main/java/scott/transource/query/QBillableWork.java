package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.BillableWork;
import scott.transource.query.QWorkItem;
import scott.transource.query.QContract;
import java.util.Date;
import scott.transource.model.PartnerType;
import scott.transource.query.QContactPerson;
import scott.transource.model.ChargeType;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class QBillableWork extends QueryObject<BillableWork> {
  private static final long serialVersionUID = 1L;
  public QBillableWork() {
    super(BillableWork.class);
  }

  public QBillableWork(QueryObject<?> parent) {
    super(BillableWork.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
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

  public QProperty<Long> contractId() {
    return new QProperty<Long>(this, "contract");
  }

  public QContract joinToContract() {
    QContract contract = new QContract();
    addLeftOuterJoin(contract, "contract");
    return contract;
  }

  public QContract joinToContract(JoinType joinType) {
    QContract contract = new QContract();
    addJoin(contract, "contract", joinType);
    return contract;
  }

  public QContract existsContract() {
    QContract contract = new QContract(this);
    addExists(contract, "contract");
    return contract;
  }

  public QProperty<Date> startedDate() {
    return new QProperty<Date>(this, "startedDate");
  }

  public QProperty<scott.transource.model.PartnerType> partnerType() {
    return new QProperty<scott.transource.model.PartnerType>(this, "partnerType");
  }

  public QProperty<Long> contactId() {
    return new QProperty<Long>(this, "contact");
  }

  public QContactPerson joinToContact() {
    QContactPerson contact = new QContactPerson();
    addLeftOuterJoin(contact, "contact");
    return contact;
  }

  public QContactPerson joinToContact(JoinType joinType) {
    QContactPerson contact = new QContactPerson();
    addJoin(contact, "contact", joinType);
    return contact;
  }

  public QContactPerson existsContact() {
    QContactPerson contact = new QContactPerson(this);
    addExists(contact, "contact");
    return contact;
  }

  public QProperty<scott.transource.model.ChargeType> chargeType() {
    return new QProperty<scott.transource.model.ChargeType>(this, "chargeType");
  }

  public QProperty<Integer> chargeAmount() {
    return new QProperty<Integer>(this, "chargeAmount");
  }

  public QProperty<Date> dueDate() {
    return new QProperty<Date>(this, "dueDate");
  }

  public QProperty<Date> completedDate() {
    return new QProperty<Date>(this, "completedDate");
  }
}