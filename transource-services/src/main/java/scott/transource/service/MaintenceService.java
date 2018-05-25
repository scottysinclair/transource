package scott.transource.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import scott.barleydb.api.config.EntityType;
import scott.barleydb.api.core.Environment;
import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.persist.SortPersistException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.barleydb.api.persist.PersistRequest;
import scott.barleydb.api.query.QueryObject;
import scott.transource.TransourceEntityContext;

public class MaintenceService {

  private final Environment env;

  public MaintenceService(Environment env) {
    this.env = env;
  }

  public List<EntityType> getEntityTypes() {
    return StreamSupport.stream(env.getDefinitionsSet().getDefinitions().spliterator(), false)
      .map(d -> d.getEntityTypes())
      .flatMap( l -> l.stream())
      .collect(Collectors.toList());
  }

  public List<Entity> getAll(EntityType entityType) throws SortServiceProviderException, BarleyDBQueryException {
    EntityContext ctx = new TransourceEntityContext(env);
    QueryObject<Object> query = new QueryObject<>(entityType.getInterfaceName());
    return ctx.performQuery(query).getEntityList();
  }

  public void save(Entity entity) throws SortServiceProviderException, SortPersistException {
    entity.getEntityContext().persist(new PersistRequest().save(entity));
  }

  public void delete(Entity entity) throws SortServiceProviderException, SortPersistException {
    entity.getEntityContext().persist(new PersistRequest().delete(entity));
  }

}
