package scott.transource.model;

import java.util.List;
import scott.barleydb.api.stream.ObjectInputStream;
import scott.barleydb.api.stream.QueryEntityInputStream;
import scott.barleydb.api.query.QueryObject;
import scott.barleydb.api.stream.EntityStreamException;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.ToManyNode;
import scott.barleydb.api.core.proxy.ToManyNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class ServiceProvider extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode firstName;
  private final ValueNode lastName;
  private final ValueNode emailAddress;
  private final ToManyNodeProxyHelper languageSkills;
  private final ToManyNodeProxyHelper contracts;

  public ServiceProvider(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    firstName = entity.getChild("firstName", ValueNode.class, true);
    lastName = entity.getChild("lastName", ValueNode.class, true);
    emailAddress = entity.getChild("emailAddress", ValueNode.class, true);
    languageSkills = new ToManyNodeProxyHelper(entity.getChild("languageSkills", ToManyNode.class, true));
    contracts = new ToManyNodeProxyHelper(entity.getChild("contracts", ToManyNode.class, true));
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

  public List<LanguageConversionSkill> getLanguageSkills() {
    return super.getListProxy(languageSkills.toManyNode);
  }

  public List<ServiceProviderContract> getContracts() {
    return super.getListProxy(contracts.toManyNode);
  }
  public ObjectInputStream<LanguageConversionSkill> streamLanguageSkills() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = languageSkills.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<LanguageConversionSkill> streamLanguageSkills(QueryObject<LanguageConversionSkill> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = languageSkills.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
  public ObjectInputStream<ServiceProviderContract> streamContracts() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = contracts.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<ServiceProviderContract> streamContracts(QueryObject<ServiceProviderContract> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = contracts.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
