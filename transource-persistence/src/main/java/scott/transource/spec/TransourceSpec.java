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

  @Enumeration(JdbcType.INT)
  public static class Language {
      public static int ENGLISH = 1;
      public static int GERMAN = 2;
      public static int CZECH = 3;
      public static int CROATIAN = 4;
  }


  public interface StandardEntity {
    public static NodeSpec id = longPrimaryKey();

    public static NodeSpec modifiedAt = optimisticLock();
  }

  /**
   * skill in language translation
   * @author scott
   *
   */
  public static class LanguageTranslationSkill {

    /**
     * the service provider who has the skill
     */
    public static final NodeSpec serviceProvider = mandatoryRefersTo(ServiceProvider.class);
    /**
     * from language
     */
    public static final NodeSpec from = mandatoryEnum(Language.class);
    /**
     * to language
     */
    public static final NodeSpec to = mandatoryEnum(Language.class);
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

    public static final NodeSpec languageSkills = ownsMany(LanguageTranslationSkill.class, LanguageTranslationSkill.serviceProvider);

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

  /**
   * a contract between the customer and the user
   * @author scott
   *
   */
  @Entity("TS_CUSTOMER_CONTRACT")
  public static class CustomerContract implements StandardEntity {

    public static final NodeSpec customer = mandatoryRefersTo(Customer.class);

    public static final NodeSpec workItems = refersToMany(WorkItem.class, WorkItem.customerContract);

    public static final NodeSpec fromLanguage = mandatoryEnum(Language.class);

    public static final NodeSpec toLanguage = mandatoryEnum(Language.class);

  }

  /**
   * A work item which a service provider performs to meet a client contract
   * @author scott
   *
   */
  @Entity("TS_WORK_ITEM")
  public static class WorkItem implements StandardEntity {

    public static final NodeSpec customerContract = mandatoryRefersTo(CustomerContract.class);

    public static final NodeSpec serviceProviderContract = mandatoryRefersTo(ServiceProviderContract.class);

  }

  /**
   * A contract between the service provider and the user
   * @author scott
   *
   */
  @Entity("TS_SERVICE_PROVIDER_CONTRACT")
  public static class ServiceProviderContract {

    /**
     * The service provider which the contract is for.
     */
    public static final NodeSpec serviceProvider = mandatoryRefersTo(ServiceProvider.class);

    /**
     * a single service provider contract can contain many work items for a given customer
     */
    public static final NodeSpec workItems = refersToMany(WorkItem.class, WorkItem.serviceProviderContract);


  }

  public static NodeSpec mandatoryVarchar100() {
    return varchar(null, 100, Nullable.NOT_NULL);
}

}