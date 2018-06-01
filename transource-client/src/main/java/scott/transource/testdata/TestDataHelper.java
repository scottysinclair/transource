package scott.transource.testdata;

import java.util.Date;

import scott.barleydb.api.core.Environment;
import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.persist.SortPersistException;
import scott.barleydb.api.persist.PersistRequest;
import scott.transource.TransourceEntityContext;
import scott.transource.model.ContactPerson;
import scott.transource.model.Contract;
import scott.transource.model.Customer;
import scott.transource.model.PartnerType;

public class TestDataHelper {

  private final Environment env;
  private final EntityContext ctx;

  private Customer hsbc;
  private Customer jpmorgan;

  public TestDataHelper(Environment env) {
    this.env = env;
    this.ctx = new TransourceEntityContext(env);
  }

  public void execute() throws SortServiceProviderException, SortPersistException {
    addCustomers();
  }

  public void addCustomers() throws SortServiceProviderException, SortPersistException {
    hsbc = ctx.newModel(Customer.class);
    hsbc.setPartnerType(PartnerType.CUSTOMER);
    hsbc.setContact( newContact("John", "Simpson", "john.simpson@hsbc.com") );

    jpmorgan = ctx.newModel(Customer.class);
    jpmorgan.setPartnerType(PartnerType.CUSTOMER);
    jpmorgan.setContact( newContact("Ian", "Mcgregor", "ian.mcgregor@jpmorgan.com") );

    ctx.persist(new PersistRequest().insert(hsbc, jpmorgan));
}

  public void addServiceProviders() {

  }

  public void addCustomerContracts() throws SortServiceProviderException, SortPersistException {
     Contract hsbcContract = ctx.newModel(Contract.class);
     hsbcContract.setName("HSBC Translation");
     hsbcContract.setCreatedDate( new Date() );
     hsbcContract.setPartner( hsbc );
     hsbcContract.setPartnerType(PartnerType.CUSTOMER);
     hsbcContract.setDueDate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 30)) );
     hsbcContract.setDescription("HSBC require a translation of their load guidelines for 2018");

     ctx.persist(new PersistRequest().insert(hsbcContract));
  }


  public void addServiceProviderContracts() {

  }

  private ContactPerson newContact(String firstName, String lastName, String emailAddress) {
    ContactPerson cp = ctx.newModel(ContactPerson.class);
    cp.setFirstName(firstName);
    cp.setLastName(lastName);
    cp.setEmailAddress(emailAddress);
    return cp;
  }

}
