package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.proxy.ProxyFactory;
import scott.barleydb.api.exception.model.ProxyCreationException;


public class TransourceProxyFactory implements ProxyFactory {

  private static final long serialVersionUID = 1L;

  @SuppressWarnings("unchecked")
  public <T> T newProxy(Entity entity) throws ProxyCreationException {
    if (entity.getEntityType().getInterfaceName().equals(Customer.class.getName())) {
      return (T) new Customer(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(CustomerContract.class.getName())) {
      return (T) new CustomerContract(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(Feedback.class.getName())) {
      return (T) new Feedback(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(Language.class.getName())) {
      return (T) new Language(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(LanguageConversionSkill.class.getName())) {
      return (T) new LanguageConversionSkill(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(ServiceProvider.class.getName())) {
      return (T) new ServiceProvider(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(ServiceProviderContract.class.getName())) {
      return (T) new ServiceProviderContract(entity);
    }
    if (entity.getEntityType().getInterfaceName().equals(WorkItem.class.getName())) {
      return (T) new WorkItem(entity);
    }
    return null;
  }
}
