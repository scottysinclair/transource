package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class ContactPerson extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode firstName;
  private final ValueNode lastName;
  private final ValueNode emailAddress;

  public ContactPerson(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    firstName = entity.getChild("firstName", ValueNode.class, true);
    lastName = entity.getChild("lastName", ValueNode.class, true);
    emailAddress = entity.getChild("emailAddress", ValueNode.class, true);
  }

  public Long getId() {
    return id.getValue();
  }

  public Long getModifiedAt() {
    return modifiedAt.getValue();
  }

  public void setModifiedAt(Long modifiedAt) {
    this.modifiedAt.setValue(modifiedAt);
  }

  public String getFirstName() {
    return firstName.getValue();
  }

  public void setFirstName(String firstName) {
    this.firstName.setValue(firstName);
  }

  public String getLastName() {
    return lastName.getValue();
  }

  public void setLastName(String lastName) {
    this.lastName.setValue(lastName);
  }

  public String getEmailAddress() {
    return emailAddress.getValue();
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress.setValue(emailAddress);
  }
}
