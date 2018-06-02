package scott.transource.query;

import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Partner;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QPartner extends QAbstractPartner<Partner, QPartner> {
  private static final long serialVersionUID = 1L;
  public QPartner() {
    super(Partner.class);
  }

  public QPartner(QueryObject<?> parent) {
    super(Partner.class, parent);
  }

}