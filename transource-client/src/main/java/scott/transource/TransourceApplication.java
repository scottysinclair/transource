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
import scott.transource.welcome.WelcomePageController;

public class TransourceApplication extends Application {

  private static final boolean real =  false;
  private static final boolean dropAndCreate =  false;
  private static Environment env;

  @Override
  public void start(Stage stage) throws Exception {
	 ClientEnvironment env = new  ClientEnvironment(stage);
	 
	 SceneManager sceneManager = new SceneManager(stage, env);
	 
	 stage.setTitle("FXML Welcome");
	 sceneManager.showScene(WelcomePageController.class);
  }
  
  public static void main(String args[]) throws Exception {

	String host = "localhost"; 
	String user = "postgres";
	String pass = "postgres";
	
	//String host = "172.18.0.3"; 
//	String user = "test_user";
//	String pass = "password";
	
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
	        EntityContext ctx = new TransourceEntityContext(env);

	        Language en = ctx.newModel(Language.class);
	        en.setName("English");
	        Language de = ctx.newModel(Language.class);
	        de.setName("German");
	        Language cz = ctx.newModel(Language.class);
	        cz.setName("Czech");

	        ctx.persist(new PersistRequest().insert(en, de, cz));

	      }
	}


    TransourceApplication app = new TransourceApplication();
    app.launch(args);
 }

}
