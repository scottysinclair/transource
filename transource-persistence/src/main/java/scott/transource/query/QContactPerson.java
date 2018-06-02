package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.ContactPerson;
import scott.transource.query.QPartner;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QContactPerson extends QueryObject<ContactPerson> {
  private static final long serialVersionUID = 1L;
  public QContactPerson() {
    super(ContactPerson.class);
  }

  public QContactPerson(QueryObject<?> parent) {
    super(ContactPerson.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<Long> worksForId() {
    return new QProperty<Long>(this, "worksFor");
  }

  public QPartner joinToWorksFor() {
    QPartner worksFor = new QPartner();
    addLeftOuterJoin(worksFor, "worksFor");
    return worksFor;
  }

  public QPartner joinToWorksFor(JoinType joinType) {
    QPartner worksFor = new QPartner();
    addJoin(worksFor, "worksFor", joinType);
    return worksFor;
  }

  public QPartner existsWorksFor() {
    QPartner worksFor = new QPartner(this);
    addExists(worksFor, "worksFor");
    return worksFor;
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
}