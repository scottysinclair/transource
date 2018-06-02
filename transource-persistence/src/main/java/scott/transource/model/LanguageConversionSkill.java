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
public class LanguageConversionSkill extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final RefNodeProxyHelper serviceProvider;
  private final RefNodeProxyHelper from;
  private final RefNodeProxyHelper to;
  private final ValueNode workType;
  private final ValueNode competency;

  public LanguageConversionSkill(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    serviceProvider = new RefNodeProxyHelper(entity.getChild("serviceProvider", RefNode.class, true));
    from = new RefNodeProxyHelper(entity.getChild("from", RefNode.class, true));
    to = new RefNodeProxyHelper(entity.getChild("to", RefNode.class, true));
    workType = entity.getChild("workType", ValueNode.class, true);
    competency = entity.getChild("competency", ValueNode.class, true);
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

  public ServiceProvider getServiceProvider() {
    return super.getFromRefNode(serviceProvider.refNode);
  }

  public void setServiceProvider(ServiceProvider serviceProvider) {
    setToRefNode(this.serviceProvider.refNode, serviceProvider);
  }

  public Language getFrom() {
    return super.getFromRefNode(from.refNode);
  }

  public void setFrom(Language from) {
    setToRefNode(this.from.refNode, from);
  }

  public Language getTo() {
    return super.getFromRefNode(to.refNode);
  }

  public void setTo(Language to) {
    setToRefNode(this.to.refNode, to);
  }

  public scott.transource.model.WorkType getWorkType() {
    return workType.getValue();
  }

  public void setWorkType(scott.transource.model.WorkType workType) {
    this.workType.setValue(workType);
  }

  public Integer getCompetency() {
    return competency.getValue();
  }

  public void setCompetency(Integer competency) {
    this.competency.setValue(competency);
  }
}
