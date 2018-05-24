package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Language;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QLanguage extends QueryObject<Language> {
  private static final long serialVersionUID = 1L;
  public QLanguage() {
    super(Language.class);
  }

  public QLanguage(QueryObject<?> parent) {
    super(Language.class, parent);
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
}