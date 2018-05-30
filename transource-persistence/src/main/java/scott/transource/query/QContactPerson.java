package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.ContactPerson;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
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