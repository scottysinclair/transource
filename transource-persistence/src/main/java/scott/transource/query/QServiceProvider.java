package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.ServiceProvider;
import scott.transource.query.QLanguageConversionSkill;
import scott.transource.query.QServiceProviderContract;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QServiceProvider extends QueryObject<ServiceProvider> {
  private static final long serialVersionUID = 1L;
  public QServiceProvider() {
    super(ServiceProvider.class);
  }

  public QServiceProvider(QueryObject<?> parent) {
    super(ServiceProvider.class, parent);
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

  public QServiceProviderContract joinToContracts() {
    QServiceProviderContract contracts = new QServiceProviderContract();
    addLeftOuterJoin(contracts, "contracts");
    return contracts;
  }

  public QServiceProviderContract joinToContracts(JoinType joinType) {
    QServiceProviderContract contracts = new QServiceProviderContract();
    addJoin(contracts, "contracts", joinType);
    return contracts;
  }

  public QServiceProviderContract existsContracts() {
    QServiceProviderContract contracts = new QServiceProviderContract(this);
    addExists(contracts, "contracts");
    return contracts;
  }
}