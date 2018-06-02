package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.BillableWorkComment;
import java.util.Date;
import scott.transource.query.QBillableWork;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QBillableWorkComment extends QueryObject<BillableWorkComment> {
  private static final long serialVersionUID = 1L;
  public QBillableWorkComment() {
    super(BillableWorkComment.class);
  }

  public QBillableWorkComment(QueryObject<?> parent) {
    super(BillableWorkComment.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<Date> commentDate() {
    return new QProperty<Date>(this, "commentDate");
  }

  public QProperty<String> content() {
    return new QProperty<String>(this, "content");
  }

  public QProperty<Long> billableWorkId() {
    return new QProperty<Long>(this, "billableWork");
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
}