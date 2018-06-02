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
import scott.barleydb.api.core.entity.ToManyNode;
import scott.barleydb.api.core.proxy.ToManyNodeProxyHelper;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class ServiceProvider extends Partner {
  private static final long serialVersionUID = 1L;

  private final ValueNode partnerType;
  private final ToManyNodeProxyHelper languageSkills;

  public ServiceProvider(Entity entity) {
    super(entity);
    partnerType = entity.getChild("partnerType", ValueNode.class, true);
    languageSkills = new ToManyNodeProxyHelper(entity.getChild("languageSkills", ToManyNode.class, true));
  }

  public scott.transource.model.PartnerType getPartnerType() {
    return partnerType.getValue();
  }

  public void setPartnerType(scott.transource.model.PartnerType partnerType) {
    this.partnerType.setValue(partnerType);
  }

  public List<LanguageConversionSkill> getLanguageSkills() {
    return super.getListProxy(languageSkills.toManyNode);
  }
  public ObjectInputStream<LanguageConversionSkill> streamLanguageSkills() throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = languageSkills.toManyNode.stream();
    return new ObjectInputStream<>(in);
  }

  public ObjectInputStream<LanguageConversionSkill> streamLanguageSkills(QueryObject<LanguageConversionSkill> query) throws SortServiceProviderException, BarleyDBQueryException, EntityStreamException {
    final QueryEntityInputStream in = languageSkills.toManyNode.stream(query);
    return new ObjectInputStream<>(in);
  }
}
