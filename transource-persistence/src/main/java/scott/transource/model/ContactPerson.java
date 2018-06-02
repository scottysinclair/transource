package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class ContactPerson extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final RefNodeProxyHelper worksFor;
  private final ValueNode firstName;
  private final ValueNode lastName;
  private final ValueNode emailAddress;

  public ContactPerson(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    worksFor = new RefNodeProxyHelper(entity.getChild("worksFor", RefNode.class, true));
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

  public Partner getWorksFor() {
    return super.getFromRefNode(worksFor.refNode);
  }

  public void setWorksFor(Partner worksFor) {
    setToRefNode(this.worksFor.refNode, worksFor);
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
