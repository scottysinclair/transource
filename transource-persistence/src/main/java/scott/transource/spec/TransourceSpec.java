import scott.barleydb.api.core.types.JdbcType;
import scott.barleydb.api.core.types.Nullable;
import scott.barleydb.api.specification.NodeSpec;
import scott.barleydb.bootstrap.GenerateModels;
import scott.barleydb.build.specification.staticspec.CommonDefaultsPlatformSpec;
import scott.barleydb.build.specification.staticspec.Entity;
import scott.barleydb.build.specification.staticspec.Enumeration;

import static scott.barleydb.api.specification.CoreSpec.*;


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
  }

  public interface StandardEntity {
    public static NodeSpec id = longPrimaryKey();

    public static NodeSpec modifiedAt = optimisticLock();
  }

  @Enumeration(JdbcType.INT)
  public class WorkType {
    public static int TRANSLATION = 1;
    public static int INTERPRETING = 2;
  }

  @Enumeration(JdbcType.INT)
  public static class ChargeType {
      public static int PER_LINE = 1;
      public static int PAUSHALL = 2;
      public static int PER_HOUR = 3;
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
    public static final NodeSpec rating = mandatoryEnum(FeedbackRating.class);
    public static final NodeSpec info = mandatoryVarchar(1500);

  }

  /**
   * skill in language conversion
   * @author scott
   *
   */
  @Entity("TS_LANG_SKILL")
  public static class LanguageConversionSkill {

    /**
     * the service provider who has the skill
     */
    public static final NodeSpec serviceProvider = mandatoryRefersTo(ServiceProvider.class);
    /**
     * from language
     */
    public static final NodeSpec from = mandatoryRefersTo(Language.class);
    /**
     * to language
     */
    public static final NodeSpec to = mandatoryRefersTo(Language.class);
    /**
     * work type
     */
    public static final NodeSpec workType  = mandatoryEnum(WorkType.class);
    /**
     * between 0 and 100
     */
    public static final NodeSpec competency = mandatoryIntegerValue();

  }

  /**
   * A service provider which the user uses to fullfill a client contract.
   * @author scott
   *
   */
  @Entity("TS_SERVICE_PROVIDER")
  public static class ServiceProvider implements StandardEntity {

    public static final NodeSpec firstName = name();

    public static final NodeSpec lastName = name();

    public static final NodeSpec emailAddress = mandatoryVarchar100();

    public static final NodeSpec languageSkills = ownsMany(LanguageConversionSkill.class, LanguageConversionSkill.serviceProvider);

    public static final NodeSpec contracts = refersToMany(ServiceProviderContract.class, ServiceProviderContract.serviceProvider);

  }

  /**
   * A customer of the user
   * @author scott
   *
   */
  @Entity("TS_CUSTOMER")
  public static class Customer implements StandardEntity {

    public static final NodeSpec firstName = name();

    public static final NodeSpec lastName = name();

    public static final NodeSpec emailAddress = mandatoryVarchar100();

    public static final NodeSpec contracts = refersToMany(CustomerContract.class, CustomerContract.customer);

  }

  public interface Contract extends StandardEntity {
    /**
     * Date created.
     */
    public static final NodeSpec createdDate = mandatoryDate();

    /**
     * date estimation completed.
     */
    public static final NodeSpec etimatedCompletionDate = optionalDate();

    /**
     * date actual completion.
     */
    public static final NodeSpec actualCompletionDate = optionalDate();

    /**
     * Feedback on completion of the contract
     */
    public static final NodeSpec feedback = optionallyRefersTo(Feedback.class);

  }


  /**
   * a contract between the customer and the user
   * @author scott
   *
   */
  @Entity("TS_CUSTOMER_CONTRACT")
  public static class CustomerContract implements Contract {

    public static final NodeSpec customer = mandatoryRefersTo(Customer.class);

    public static final NodeSpec workItems = refersToMany(WorkItem.class, WorkItem.customerContract);

    /**
     * date the bill was sent to the client.
     */
    public static final NodeSpec billSentDate = optionalDate();

    /**
     * date the payment from the client was received..
     */
    public static final NodeSpec paymentReceivedDate = optionalDate();
  }

  /**
   * A work item which a service provider performs to meet a client contract
   * @author scott
   *
   */
  @Entity("TS_WORK_ITEM")
  public static class WorkItem implements StandardEntity {

    /**
     * The customer contract which originated this work item
     */
    public static final NodeSpec customerContract = mandatoryRefersTo(CustomerContract.class);

    /**
     * The type of charge the customer uses
     */
    public static final NodeSpec custChargeType = mandatoryEnum(ChargeType.class);


    /**
     * Amount in cents billed to the customer
     */
    public static final NodeSpec custChargeAmount = mandatoryIntegerValue();


    /**
     * from language
     */
    public static final NodeSpec fromLanguage = mandatoryEnum(Language.class);

    /**
     * to language
     */
    public static final NodeSpec toLanguage = mandatoryEnum(Language.class);

    /**
     * interpreting or translating
     */
    public static final NodeSpec workType  = mandatoryEnum(WorkType.class);

    /**
     * The service provider who performs the work
     */
    public static final NodeSpec serviceProviderContract = mandatoryRefersTo(ServiceProviderContract.class);

    /**
     * The type of charge the service provider uses
     */
    public static final NodeSpec spChargeType = mandatoryEnum(ChargeType.class);


    /**
     * Amount in cents payed to the service provider
     */
    public static final NodeSpec spChargeAmount = mandatoryIntegerValue();


    /**
     * Description of the work item
     */
    public static final NodeSpec description = mandatoryVarchar150();

    /**
     * If the work item is completed.
     */
    public static final NodeSpec completed = mandatoryBooleanValue();

  }

  /**
   * A contract between the service provider and the user
   * @author scott
   *
   */
  @Entity("TS_SERVICE_PROVIDER_CONTRACT")
  public static class ServiceProviderContract implements Contract {

    /**
     * The service provider which the contract is for.
     */
    public static final NodeSpec serviceProvider = mandatoryRefersTo(ServiceProvider.class);


    /**
     * a single service provider contract can contain many work items for a given customer
     */
    public static final NodeSpec workItems = refersToMany(WorkItem.class, WorkItem.serviceProviderContract);


    /**
     * date the bill from the service provider was received.
     */
    public static final NodeSpec billReceivedDate = optionalDate();

    /**
     * date the payment to the service provider was sent.
     */
    public static final NodeSpec paymentSentDate = optionalDate();

  }


  public static NodeSpec mandatoryVarchar100() {
    return varchar(null, 100, Nullable.NOT_NULL);
}

}