package scott.transource;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;
import scott.barleydb.api.core.Environment;
import scott.transource.customercontract.CustomerContractDetailsController;
import scott.transource.dao.TransourceDao;
import scott.transource.service.TransourceReportingService;
import scott.transource.service.impl.TransourceReportingServiceImpl;
import scott.transource.welcome.WelcomePageController;

public class ClientEnvironment {

  private final Environment barleyEnv;
  private final Stage stage;
  private final WelcomePageController weclomePage;
  private final CustomerContractDetailsController customerContractDetails;
  private final TransourceReportingService reportingService;
  private final Map<Class<?>, Object> objectsByType = new HashMap<>();

  public ClientEnvironment(Stage stage, Environment barleyEnv) {
    this.stage = stage;
    this.barleyEnv = barleyEnv;
    reportingService = newReportingService();
    fillLookupMap();
    weclomePage = new WelcomePageController(this, stage);
    customerContractDetails = new CustomerContractDetailsController(this);
    fillLookupMap();
  }

  public void addObject(Object anyObject) {
    objectsByType.put(anyObject.getClass(), anyObject);
  }

  private void fillLookupMap() {
    for (Field field: getClass().getDeclaredFields()) {
      try {
        objectsByType.put(field.getType(), field.get(this));
      } catch (IllegalArgumentException | IllegalAccessException e) {
        throw new IllegalStateException("Could not fill map", e);
      }
    }
  }

  protected TransourceReportingService newReportingService() {
    return new TransourceReportingServiceImpl(new TransourceDao(barleyEnv));
  }

  @SuppressWarnings("unchecked")
  public <T> T getObject(Class<T> objectType) {
    return (T)objectsByType.get(objectType);
  }
}
