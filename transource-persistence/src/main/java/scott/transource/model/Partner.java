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
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;
import scott.barleydb.api.core.entity.ToManyNode;
import scott.barleydb.api.core.proxy.ToManyNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class Partner extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode partnerType;
  private final RefNodeProxyHelper contact;
  private final ToManyNodeProxyHelper contracts;

  public Partner(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    partnerType = entity.getChild("partnerType", ValueNode.class, true);
    contact = new RefNodeProxyHelper(entity.getChild("contact", RefNode.class, true));
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

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType.getValue();
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType.setValue(partnerType);
  }

  public ContactPerson getContact() {
    return super.getFromRefNode(contact.refNode);
  }

  public void setContact(ContactPerson contact) {
    setToRefNode(this.contact.refNode, contact);
  }

  public List<Contract> getContracts() {
    return super.getListProxy(contracts.toManyNode);
  }
  public ObjectInputStream<Contract> streamContracts() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = contracts.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<Contract> streamContracts(QueryObject<Contract> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = contracts.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
