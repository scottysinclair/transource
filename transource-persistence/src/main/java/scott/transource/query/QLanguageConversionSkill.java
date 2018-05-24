package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.LanguageConversionSkill;
import scott.transource.query.QServiceProvider;
import scott.transource.query.QLanguage;
import scott.transource.model.WorkType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QLanguageConversionSkill extends QueryObject<LanguageConversionSkill> {
  private static final long serialVersionUID = 1L;
  public QLanguageConversionSkill() {
    super(LanguageConversionSkill.class);
  }

  public QLanguageConversionSkill(QueryObject<?> parent) {
    super(LanguageConversionSkill.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<Long> serviceProviderId() {
    return new QProperty<Long>(this, "serviceProvider");
  }

  public QServiceProvider joinToServiceProvider() {
    QServiceProvider serviceProvider = new QServiceProvider();
    addLeftOuterJoin(serviceProvider, "serviceProvider");
    return serviceProvider;
  }

  public QServiceProvider joinToServiceProvider(JoinType joinType) {
    QServiceProvider serviceProvider = new QServiceProvider();
    addJoin(serviceProvider, "serviceProvider", joinType);
    return serviceProvider;
  }

  public QServiceProvider existsServiceProvider() {
    QServiceProvider serviceProvider = new QServiceProvider(this);
    addExists(serviceProvider, "serviceProvider");
    return serviceProvider;
  }

  public QProperty<Long> fromId() {
    return new QProperty<Long>(this, "from");
  }

  public QLanguage joinToFrom() {
    QLanguage from = new QLanguage();
    addLeftOuterJoin(from, "from");
    return from;
  }

  public QLanguage joinToFrom(JoinType joinType) {
    QLanguage from = new QLanguage();
    addJoin(from, "from", joinType);
    return from;
  }

  public QLanguage existsFrom() {
    QLanguage from = new QLanguage(this);
    addExists(from, "from");
    return from;
  }

  public QProperty<Long> toId() {
    return new QProperty<Long>(this, "to");
  }

  public QLanguage joinToTo() {
    QLanguage to = new QLanguage();
    addLeftOuterJoin(to, "to");
    return to;
  }

  public QLanguage joinToTo(JoinType joinType) {
    QLanguage to = new QLanguage();
    addJoin(to, "to", joinType);
    return to;
  }

  public QLanguage existsTo() {
    QLanguage to = new QLanguage(this);
    addExists(to, "to");
    return to;
  }

  public QProperty<scott.transource.model.WorkType> workType() {
    return new QProperty<scott.transource.model.WorkType>(this, "workType");
  }

  public QProperty<Integer> competency() {
    return new QProperty<Integer>(this, "competency");
  }
}