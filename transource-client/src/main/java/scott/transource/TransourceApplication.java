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
import scott.transource.spec.TransourceSpec;
import scott.transource.testdata.TestDataHelper;
import scott.transource.welcome.WelcomePageController;

public class TransourceApplication extends Application {

  private static final boolean real =  true;
  private static final boolean dropAndCreate =  true;
  private static Environment env;

  @Override
  public void start(Stage stage) throws Exception {
   ClientEnvironment env = new  ClientEnvironment(stage, TransourceApplication.env);

   SceneManager sceneManager = new SceneManager(stage, env);

   env.addObject(sceneManager);

   stage.setTitle("Transource V1.0");
   sceneManager.showScene(WelcomePageController.class);
   stage.setMaximized(true);
   stage.show();

  }

  public static void main(String args[]) throws Exception {
//
//  String host = "localhost";
//  String user = "postgres";
//  String pass = "postgres";

  String host = "172.18.0.2";
  String user = "test_user";
  String pass = "password";

  if (real) {
      env  = EnvironmentDef.build()
          .withDataSource()
              .withDriver("org.postgresql.xa.PGXADataSource")
              .withUser( user )
              .withPassword( pass )
              .withUrl("jdbc:postgresql://" + host + ":5432/test_db")
              .end()
           .withSpecs(TransourceSpec.class)
           .withDroppingSchema(dropAndCreate)
           .withSchemaCreation(dropAndCreate)
           .create();

      if (dropAndCreate) {
        TestDataHelper tdh = new TestDataHelper(env);
        tdh.execute();
      }
  }


    TransourceApplication app = new TransourceApplication();
    app.launch(args);
 }

}
