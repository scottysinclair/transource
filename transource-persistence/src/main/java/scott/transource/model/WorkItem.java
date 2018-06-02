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
 * @author scott
 */
public class WorkItem extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode name;
  private final ValueNode workType;
  private final ValueNode description;
  private final ToManyNodeProxyHelper billableWork;
  private final RefNodeProxyHelper fromLanguage;
  private final RefNodeProxyHelper toLanguage;

  public WorkItem(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    name = entity.getChild("name", ValueNode.class, true);
    workType = entity.getChild("workType", ValueNode.class, true);
    description = entity.getChild("description", ValueNode.class, true);
    billableWork = new ToManyNodeProxyHelper(entity.getChild("billableWork", ToManyNode.class, true));
    fromLanguage = new RefNodeProxyHelper(entity.getChild("fromLanguage", RefNode.class, true));
    toLanguage = new RefNodeProxyHelper(entity.getChild("toLanguage", RefNode.class, true));
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

  public String getName() {
    return name.getValue();
  }

  public void setName(String name) {
    this.name.setValue(name);
  }

  public scott.transource.model.WorkType getWorkType() {
    return workType.getValue();
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType.setValue(workType);
  }

  public String getDescription() {
    return description.getValue();
  }

  public void setDescription(String description) {
    this.description.setValue(description);
  }

  public List<BillableWork> getBillableWork() {
    return super.getListProxy(billableWork.toManyNode);
  }

  public Language getFromLanguage() {
    return super.getFromRefNode(fromLanguage.refNode);
  }

  public void setFromLanguage(Language fromLanguage) {
    setToRefNode(this.fromLanguage.refNode, fromLanguage);
  }

  public Language getToLanguage() {
    return super.getFromRefNode(toLanguage.refNode);
  }

  public void setToLanguage(Language toLanguage) {
    setToRefNode(this.toLanguage.refNode, toLanguage);
  }
  public ObjectInputStream<BillableWork> streamBillableWork() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = billableWork.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<BillableWork> streamBillableWork(QueryObject<BillableWork> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = billableWork.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
