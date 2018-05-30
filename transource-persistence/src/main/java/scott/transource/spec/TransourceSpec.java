package scott.transource.spec;

import static scott.barleydb.api.specification.CoreSpec.mandatoryEnum;
import static scott.barleydb.api.specification.CoreSpec.mandatoryFixedEnum;
import static scott.barleydb.api.specification.CoreSpec.mandatoryRefersTo;
import static scott.barleydb.api.specification.CoreSpec.optionallyRefersTo;
import static scott.barleydb.api.specification.CoreSpec.ownsMany;
import static scott.barleydb.api.specification.CoreSpec.refersToMany;

import scott.barleydb.api.core.types.JdbcType;
import scott.barleydb.api.core.types.Nullable;
import scott.barleydb.api.specification.NodeSpec;
import scott.barleydb.bootstrap.GenerateModels;
import scott.barleydb.build.specification.staticspec.AbstractEntity;
import scott.barleydb.build.specification.staticspec.CommonDefaultsPlatformSpec;
import scott.barleydb.build.specification.staticspec.Entity;
import scott.barleydb.build.specification.staticspec.Enumeration;
import scott.barleydb.build.specification.staticspec.ExtendsEntity;


/*-
 * #%L
 * Transource Persistence
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2014 - 2018 Scott Sinclair
 *       <scottysinclair@gmail.com>
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
public class TransourceSpec extends CommonDefaultsPlatformSpec {

  /**
   * generate the query and model classes for the spec.
   * @param args
   */
  public static void main(String args[]) {
      GenerateModels.execute(TransourceSpec.class);
  }

  public TransourceSpec() {
    super("scott.transource");
    renameForeignKeyConstraint(new StaticRelation(LanguageConversionSkill.from), "FK_LANG_CONV_SKILL_FROM");
    renameForeignKeyConstraint(new StaticRelation(LanguageConversionSkill.to), "FK_LANG_CONV_SKILL_TO");
    renameForeignKeyConstraint(new StaticRelation(WorkItem.fromLanguage), "FK_WORKITEM_LANG_FROM");
    renameForeignKeyConstraint(new StaticRelation(WorkItem.toLanguage), "FK_WORK_ITEM_LANG_TO");
    renameForeignKeyConstraint(new StaticRelation(WorkItem.customerBillable), "FK_WORKITEM_CUST_BILL");
    renameForeignKeyConstraint(new StaticRelation(WorkItem.serviceProviderBillable), "FK_WORK_ITEM_SERVP_BILL");
  }

  public interface StandardEntity {
    public static NodeSpec id = longPrimaryKey();

    public static NodeSpec modifiedAt = optimisticLock();
  }

  @Enumeration(value = JdbcType.VARCHAR, length = 10)
  public class WorkType {
    public static final String TRANSLATION = "TRANS";
    public static final String INTERPRETING = "INTERP";
  }

  @Enumeration(value = JdbcType.VARCHAR, length = 15)
  public class AuditEventType {
    public static final String NEW_WORK_ITEM = "NEW_WORK_ITEM";
  }

  @Enumeration(value = JdbcType.VARCHAR, length = 15)
  public static class ChargeType {
      public static String PER_LINE = "PER_LINE";
      public static String PAUSHALL = "PAUSHALL";
      public static String PER_HOUR = "PER_HOUR";
  }

  @Enumeration(value = JdbcType.VARCHAR, length = 20)
  public static class PartnerType {
      public static String CUSTOMER = "CUST";
      public static String SERVICE_PROVIDER = "SERVP";
  }
	  

  @Enumeration(JdbcType.INT)
  public static class FeedbackRating {
      public static int VERY_BAD = -3;
      public static int BAD = -2;
      public static int BIT_BAD = -1;
      public static int NEUTRAL = 0;
      public static int BIT_GOOD = 1;
      public static int GOOD = 2;
      public static int VERY_GOOD = 3;
  }

  @Entity("TS_LANGUAGE")
  public static class Language implements StandardEntity {
    public static final NodeSpec name = name();
  }

  @Entity("TS_FEEDBACK")
  public static class Feedback implements StandardEntity {
    public static final NodeSpec partnerType  = mandatoryEnum(PartnerType.class);
    public static final NodeSpec rating = mandatoryEnum(FeedbackRating.class);
    public static final NodeSpec info = mandatoryVarchar(1500);
  }

  /**
   * skill in language conversion
   * @author scott
   *
   */
  @Entity("TS_LANG_SKILL")
  public static class LanguageConversionSkill implements StandardEntity {

    /**
     * the service provider who has the skill
     */
    public static final NodeSpec serviceProvider = mandatoryRefersTo(ServiceProvider.class);
    /**
     * from language
     */
    public static final NodeSpec from = mandatoryRefersTo(Language.class, "FROM_LANG");
    /**
     * to language
     */
    public static final NodeSpec to = mandatoryRefersTo(Language.class, "TO_LANG");
    /**
     * work type
     */
    public static final NodeSpec workType  = mandatoryEnum(WorkType.class);
    /**
     * between 0 and 100
     */
    public static final NodeSpec competency = mandatoryIntegerValue();

  }
  
  @Entity("TS_CONTACT_PERSON")
  public static class ContactPerson implements StandardEntity {
	    public static final NodeSpec firstName = name();

	    public static final NodeSpec lastName = name();

	    public static final NodeSpec emailAddress = mandatoryVarchar100();
  }

  @AbstractEntity("TS_PARTNER")
  public static class Partner implements StandardEntity {
	  
		public static final NodeSpec partnerType = mandatoryEnum(PartnerType.class);
	  
		public static final NodeSpec contact = mandatoryRefersTo(ContactPerson.class);

	    public static final NodeSpec contracts = refersToMany(Contract.class, Contract.partner);
  }


  /**
   * A service provider which the user uses to fullfill a client contract.
   * @author scott
   *
   */
  @ExtendsEntity
  public static class ServiceProvider extends Partner {
    public static final NodeSpec partnerType = mandatoryFixedEnum(PartnerType.class, PartnerType.SERVICE_PROVIDER);

    public static final NodeSpec languageSkills = ownsMany(LanguageConversionSkill.class, LanguageConversionSkill.serviceProvider);
  }
  


  /**
   * A customer of the user
   * @author scott
   *
   */
  @ExtendsEntity
  public static class Customer extends Partner {
      public static final NodeSpec partnerType = mandatoryFixedEnum(PartnerType.class, PartnerType.CUSTOMER);
  }

  @Entity("TS_CONTRACT")
  public static class Contract implements StandardEntity {

	/**
	 * The name of the contract
	 */
	public static final NodeSpec name = name();

	
	/**
	 * The name of the contract
	 */
	public static final NodeSpec description = mandatoryVarchar(600);

	
	/**
	 * The partner the contract is with
	 */
    public static final NodeSpec partner = mandatoryRefersTo(Partner.class);
    
    
    /**
     * customer or service provider.
     */
    public static final NodeSpec partnerType = mandatoryEnum(PartnerType.class);
    
    /**
     * The billable work on the contract
     */
    public static final NodeSpec billableWork = ownsMany(BillableWork.class, BillableWork.contact); 
 
    /**
     * Date created.
     */
    public static final NodeSpec createdDate = mandatoryDate();

    /**
     * date estimation completed.
     */
    public static final NodeSpec dueDate = optionalDate();

    /**
     * date actual completion.
     */
    public static final NodeSpec completedDate = optionalDate();
    
    
    /**
     * date the contract was billed.
     */
    public static final NodeSpec billedDate = optionalDate();

    /**
     * date the bill was payed.
     */
    public static final NodeSpec payedDate = optionalDate();
    

    /**
     * Feedback on completion of the contract
     */
    public static final NodeSpec feedback = optionallyRefersTo(Feedback.class);
        
  }



  /**
   * A work item which a service provider performs to meet a client contract
   * @author scott
   *
   */
  @Entity("TS_WORK_ITEM")
  public static class WorkItem implements StandardEntity {

    /**
     * interpreting or translating
     */
    public static final NodeSpec workType  = mandatoryEnum(WorkType.class);

    /**
     * Description of the work item
     */
    public static final NodeSpec description = mandatoryVarchar150();

    /**
     * The cutomer who performs the work
     */
    public static final NodeSpec customerBillable = mandatoryRefersTo(BillableWork.class, "CUSTOMER_BILLABLE_ID");

    /**
     * The service provider who performs the work
     */
    public static final NodeSpec serviceProviderBillable = mandatoryRefersTo(BillableWork.class, "SERVP_BILLABLE_ID");

    
    /**
     * from language
     */
    public static final NodeSpec fromLanguage = mandatoryRefersTo(Language.class, "FROM_LANG");

    /**
     * to language
     */
    public static final NodeSpec toLanguage = mandatoryRefersTo(Language.class, "TO_LANG");


 }
  
  @Entity("TS_BILLABLE_WORK")
 public static class BillableWork implements StandardEntity {
	  
	   public static final NodeSpec workItem = mandatoryRefersTo(WorkItem.class);
	   
	    /**
	     * The contract which this work is billed to
	     */
	    public static final NodeSpec contract = mandatoryRefersTo(Contract.class);


	    /**
	     * started date.
	     */
	    public static final NodeSpec startedDate = optionalDate();

	    /**
	     * The billable work from service provider or to the customer
	     */
	    public static final NodeSpec partnerType = mandatoryEnum(PartnerType.class);
	   
	  
	   public static final NodeSpec contact = mandatoryRefersTo(ContactPerson.class);
	  
	    /**
	     * The type of charge 
	     */
	    public static final NodeSpec chargeType = mandatoryEnum(ChargeType.class);


	    /**
	     * Amount in cents billed 
	     */
	    public static final NodeSpec chargeAmount = mandatoryIntegerValue();

	    /**
	     *  due date
	     */
	    public static final NodeSpec dueDate = mandatoryDate();

	    
	    /**
	     * completion date.
	     */
	    public static final NodeSpec completedDate = optionalDate();

 }
  
  
 public static NodeSpec mandatoryVarchar100() {
	return varchar(null, 100, Nullable.NOT_NULL);
 }

}