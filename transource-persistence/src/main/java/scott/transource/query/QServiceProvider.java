package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.ServiceProvider;
import scott.transource.model.PartnerType;
import scott.transource.query.QLanguageConversionSkill;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QServiceProvider extends QAbstractPartner<ServiceProvider, QServiceProvider> {
  private static final long serialVersionUID = 1L;
  public QServiceProvider() {
    super(ServiceProvider.class);
  }

  public QServiceProvider(QueryObject<?> parent) {
    super(ServiceProvider.class, parent);
  }


  public QProperty<scott.transource.model.PartnerType> partnerType() {
    return new QProperty<scott.transource.model.PartnerType>(this, "partnerType");
  }

  public QLanguageConversionSkill joinToLanguageSkills() {
    QLanguageConversionSkill languageSkills = new QLanguageConversionSkill();
    addLeftOuterJoin(languageSkills, "languageSkills");
    return languageSkills;
  }

  public QLanguageConversionSkill joinToLanguageSkills(JoinType joinType) {
    QLanguageConversionSkill languageSkills = new QLanguageConversionSkill();
    addJoin(languageSkills, "languageSkills", joinType);
    return languageSkills;
  }

  public QLanguageConversionSkill existsLanguageSkills() {
    QLanguageConversionSkill languageSkills = new QLanguageConversionSkill(this);
    addExists(languageSkills, "languageSkills");
    return languageSkills;
  }
}