package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.WorkSize;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QWorkSize extends QueryObject<WorkSize> {
  private static final long serialVersionUID = 1L;
  public QWorkSize() {
    super(WorkSize.class);
  }

  public QWorkSize(QueryObject<?> parent) {
    super(WorkSize.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<String> units() {
    return new QProperty<String>(this, "units");
  }

  public QProperty<String> size() {
    return new QProperty<String>(this, "size");
  }
}