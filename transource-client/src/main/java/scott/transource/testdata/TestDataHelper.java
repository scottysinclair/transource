package scott.transource.testdata;

import java.util.Date;

import scott.barleydb.api.core.Environment;
import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.persist.SortPersistException;
import scott.barleydb.api.persist.PersistRequest;
import scott.transource.TransourceEntityContext;
import scott.transource.model.BillableWork;
import scott.transource.model.ChargeType;
import scott.transource.model.ContactPerson;
import scott.transource.model.Contract;
import scott.transource.model.Customer;
import scott.transource.model.Language;
import scott.transource.model.Partner;
import scott.transource.model.PartnerType;
import scott.transource.model.ServiceProvider;
import scott.transource.model.WorkItem;
import scott.transource.model.WorkType;

public class TestDataHelper {

  private final Environment env;
  private final EntityContext ctx;

  private Customer hsbc;
  private Customer jpmorgan;
  private ContactPerson johnSimpsonHsbc;
  private ContactPerson ianMcgregorJpmorgan;
  private ServiceProvider johnConsulting;
  private Language en, de, cz;

  public TestDataHelper(Environment env) {
    this.env = env;
    this.ctx = new TransourceEntityContext(env);
  }

  public void execute() throws SortServiceProviderException, SortPersistException {
    addLanguages();
    addCustomers();
    addServiceProviders();
    addCustomerContracts();
  }

  public void addLanguages() throws SortServiceProviderException, SortPersistException {
    en = ctx.newModel(Language.class);
    en.setName("English");

    de = ctx.newModel(Language.class);
    de.setName("German");

    cz = ctx.newModel(Language.class);
    cz.setName("Czech");

    ctx.persist(new PersistRequest().insert(en, de, cz));
  }

  public void addCustomers() throws SortServiceProviderException, SortPersistException {
    hsbc = ctx.newModel(Customer.class);
    hsbc.setName("HSBC");
    hsbc.setPartnerType(PartnerType.CUSTOMER);
    johnSimpsonHsbc = newContact("John", "Simpson", "john.simpson@hsbc.com", hsbc);
    hsbc.getContacts().add( johnSimpsonHsbc );

    jpmorgan = ctx.newModel(Customer.class);
    jpmorgan.setName("JPMorgan");
    jpmorgan.setPartnerType(PartnerType.CUSTOMER);
    ianMcgregorJpmorgan = newContact("Ian", "Mcgregor", "ian.mcgregor@jpmorgan.com", jpmorgan);
    jpmorgan.getContacts().add( ianMcgregorJpmorgan );

    ctx.persist(new PersistRequest().insert(hsbc, jpmorgan));
}

  public void addServiceProviders() {
    johnConsulting = ctx.newModel(ServiceProvider.class );
    johnConsulting.setName("John Consulting");
    johnConsulting.setPartnerType(PartnerType.SERVICE_PROVIDER);

     ContactPerson john = ctx.newModel(ContactPerson.class);
     john.setFirstName("John");
     john.setLastName("Andeson");
     john.setEmailAddress("john.anderson@jaconsulting.com");
     johnConsulting.getContacts().add( newContact("John", "Anderson", "john.anderson@jaconsulting.com", johnConsulting));

  }

  public void addCustomerContracts() throws SortServiceProviderException, SortPersistException {
     Contract hsbcContract = ctx.newModel(Contract.class);
     hsbcContract.setName("2 HSBC Translations");
     hsbcContract.setCreatedDate( new Date() );
     hsbcContract.setPartner( hsbc );
     hsbcContract.setPartnerType(PartnerType.CUSTOMER);
     hsbcContract.setDueDate(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30)) );
     hsbcContract.setDescription("HSBC require translations of their loan guidelines for 2018");

     WorkItem firstHsbcTranslation = ctx.newModel(WorkItem.class);
     firstHsbcTranslation.setName("Loan Guidelines 2018 CZ -> EN");
     firstHsbcTranslation.setDescription("Guidlines for loans for the year 2018 CZ -> EN");
     firstHsbcTranslation.setFromLanguage(cz);
     firstHsbcTranslation.setToLanguage(en);
     firstHsbcTranslation.setWorkType(WorkType.TRANSLATION);

     BillableWork firstHsbcBw = ctx.newModel(BillableWork.class);
     firstHsbcBw.setWorkItem(firstHsbcTranslation);
     firstHsbcBw.setContract( hsbcContract );
     firstHsbcBw.setPartnerType(PartnerType.CUSTOMER);
     firstHsbcBw.setChargeType(ChargeType.PER_LINE);
     firstHsbcBw.setChargeAmount(100);
     firstHsbcBw.setContact( johnSimpsonHsbc );
     firstHsbcBw.setDueDate(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 29)) );
     hsbcContract.getBillableWork().add(firstHsbcBw);

     WorkItem secondHsbcTranslation = ctx.newModel(WorkItem.class);
     secondHsbcTranslation.setName("Loan Guidelines 2018 DE -> EN");
     secondHsbcTranslation.setDescription("Guidlines for loans for the year 2018  DE -> EN");
     secondHsbcTranslation.setFromLanguage(de);
     secondHsbcTranslation.setToLanguage(en);
     secondHsbcTranslation.setWorkType(WorkType.TRANSLATION);

     BillableWork secondHsbcBw = ctx.newModel(BillableWork.class);
     secondHsbcBw.setWorkItem(secondHsbcTranslation);
     secondHsbcBw.setContract( hsbcContract );
     secondHsbcBw.setPartnerType(PartnerType.CUSTOMER);
     secondHsbcBw.setChargeType(ChargeType.PER_LINE);
     secondHsbcBw.setChargeAmount(100);
     secondHsbcBw.setContact( johnSimpsonHsbc );
     secondHsbcBw.setDueDate(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 29)) );
     hsbcContract.getBillableWork().add(secondHsbcBw);


     Contract jpContract = ctx.newModel(Contract.class);
     jpContract.setName("JPMorgan Translation");
     jpContract.setCreatedDate( new Date() );
     jpContract.setPartner( jpmorgan );
     jpContract.setPartnerType(PartnerType.CUSTOMER);
     jpContract.setDueDate(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30 * 2)) );
     jpContract.setDescription("JPMorgan require a translation of their loan guidelines for 2019");

     WorkItem theJpMorganTranslation = ctx.newModel(WorkItem.class);
     theJpMorganTranslation.setName("Loan Guidelines 2019");
     theJpMorganTranslation.setDescription("Guidlines for loans for the year 2019");
     theJpMorganTranslation.setFromLanguage(cz);
     theJpMorganTranslation.setToLanguage(en);
     theJpMorganTranslation.setWorkType(WorkType.TRANSLATION);

     BillableWork jpMorganBw = ctx.newModel(BillableWork.class);
     jpMorganBw.setContract( jpContract );
     jpMorganBw.setPartnerType(PartnerType.CUSTOMER);
     jpMorganBw.setWorkItem(theJpMorganTranslation);
     jpMorganBw.setChargeType(ChargeType.PER_LINE);
     jpMorganBw.setChargeAmount(200);
     jpMorganBw.setContact( ianMcgregorJpmorgan );
     jpMorganBw.setDueDate(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30 * 1)) );
     jpContract.getBillableWork().add(jpMorganBw);

     ctx.persist(new PersistRequest().insert(hsbcContract, jpContract));
  }


  public void addServiceProviderContracts() {

  }

  private ContactPerson newContact(String firstName, String lastName, String emailAddress, Partner partner) {
    ContactPerson cp = ctx.newModel(ContactPerson.class);
    cp.setFirstName(firstName);
    cp.setLastName(lastName);
    cp.setEmailAddress(emailAddress);
    cp.setWorksFor(partner);
    return cp;
  }

}
