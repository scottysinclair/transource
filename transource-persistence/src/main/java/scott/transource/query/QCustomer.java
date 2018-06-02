package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Customer;
import scott.transource.model.PartnerType;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class QCustomer extends QAbstractPartner<Customer, QCustomer> {
  private static final long serialVersionUID = 1L;
  public QCustomer() {
    super(Customer.class);
  }

  public QCustomer(QueryObject<?> parent) {
    super(Customer.class, parent);
  }


  public QProperty<scott.transource.model.PartnerType> partnerType() {
    return new QProperty<scott.transource.model.PartnerType>(this, "partnerType");
  }
}