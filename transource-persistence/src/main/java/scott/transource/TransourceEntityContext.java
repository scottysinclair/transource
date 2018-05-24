package scott.transource;

import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.core.Environment;

public class TransourceEntityContext extends EntityContext {

  private static final long serialVersionUID = 1L;

  public TransourceEntityContext(Environment env) {
    super(env, "scott.transource");
  }
}