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

  public QProperty<String> name() {
    return new QProperty<String>(this, "name");
  }

  public QProperty<scott.transource.model.WorkType> workType() {
    return new QProperty<scott.transource.model.WorkType>(this, "workType");
  }

  public QProperty<String> description() {
    return new QProperty<String>(this, "description");
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