package scott.transource;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scott.barleydb.api.core.Environment;
import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.persist.PersistRequest;
import scott.barleydb.bootstrap.EnvironmentDef;
import scott.transource.model.Language;
import scott.transource.service.MaintenceService;
import scott.transource.spec.TransourceSpec;

@SuppressWarnings("restriction")
public class TransourceApplication extends Application {

  private static final boolean dropAndCreate =  true;
  private static Environment env;

  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader( getClass().getResource("TransourceApplication.fxml") );

    Map<Class<?>, Object> controllers = new HashMap<>();

    MaintenceService service = new MaintenceService(env);
    Controller controller = new Controller(service);
    controllers.put(Controller.class, controller);
    loader.setControllerFactory(controllers::get);

    Parent root = loader.load();
    Scene scene = new Scene(root, 300, 275);

    stage.setTitle("FXML Welcome");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String args[]) throws Exception {

    env  = EnvironmentDef.build()
        .withDataSource()
            .withDriver("org.postgresql.xa.PGXADataSource")
            .withUser("test_user")
            .withPassword("password")
            .withUrl("jdbc:postgresql://172.18.0.3:5432/test_db")
            .end()
         .withSpecs(TransourceSpec.class)
         .withDroppingSchema(dropAndCreate)
         .withSchemaCreation(dropAndCreate)
         .create();

    if (dropAndCreate) {
      EntityContext ctx = new TransourceEntityContext(env);

      Language en = ctx.newModel(Language.class);
      en.setName("English");
      Language de = ctx.newModel(Language.class);
      de.setName("German");
      Language cz = ctx.newModel(Language.class);
      cz.setName("Czech");

      ctx.persist(new PersistRequest().insert(en, de, cz));

    }

    TransourceApplication app = new TransourceApplication();
    app.launch(args);
 }

}
