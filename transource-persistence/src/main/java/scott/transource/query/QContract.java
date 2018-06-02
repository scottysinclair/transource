package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Contract;
import scott.transource.query.QPartner;
import scott.transource.model.PartnerType;
import scott.transource.query.QBillableWork;
import java.util.Date;
import scott.transource.query.QFeedback;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QContract extends QueryObject<Contract> {
  private static final long serialVersionUID = 1L;
  public QContract() {
    super(Contract.class);
  }

  public QContract(QueryObject<?> parent) {
    super(Contract.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<String> name() {
    return new QProperty<String>(this, "name");
  }

  public QProperty<String> description() {
    return new QProperty<String>(this, "description");
  }

  public QProperty<Long> partnerId() {
    return new QProperty<Long>(this, "partner");
  }

  public QPartner joinToPartner() {
    QPartner partner = new QPartner();
    addLeftOuterJoin(partner, "partner");
    return partner;
  }

  public QPartner joinToPartner(JoinType joinType) {
    QPartner partner = new QPartner();
    addJoin(partner, "partner", joinType);
    return partner;
  }

  public QPartner existsPartner() {
    QPartner partner = new QPartner(this);
    addExists(partner, "partner");
    return partner;
  }

  public QProperty<scott.transource.model.PartnerType> partnerType() {
    return new QProperty<scott.transource.model.PartnerType>(this, "partnerType");
  }

  public QBillableWork joinToBillableWork() {
    QBillableWork billableWork = new QBillableWork();
    addLeftOuterJoin(billableWork, "billableWork");
    return billableWork;
  }

  public QBillableWork joinToBillableWork(JoinType joinType) {
    QBillableWork billableWork = new QBillableWork();
    addJoin(billableWork, "billableWork", joinType);
    return billableWork;
  }

  public QBillableWork existsBillableWork() {
    QBillableWork billableWork = new QBillableWork(this);
    addExists(billableWork, "billableWork");
    return billableWork;
  }

  public QProperty<Date> createdDate() {
    return new QProperty<Date>(this, "createdDate");
  }

  public QProperty<Date> dueDate() {
    return new QProperty<Date>(this, "dueDate");
  }

  public QProperty<Date> completedDate() {
    return new QProperty<Date>(this, "completedDate");
  }

  public QProperty<Date> billedDate() {
    return new QProperty<Date>(this, "billedDate");
  }

  public QProperty<Date> payedDate() {
    return new QProperty<Date>(this, "payedDate");
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
}