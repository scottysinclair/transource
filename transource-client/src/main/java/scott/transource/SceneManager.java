package scott.transource;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scott.transource.welcome.WelcomePageController;

public class SceneManager {
	
	private Map<Class<?>,String> fxmls = new HashMap<>();

	private final Stage stage;
	private final ClientEnvironment env;
	private final Map<Class<?>, LoadedScene<?>> loadedScenes = new HashMap<>();

	public SceneManager(Stage stage, ClientEnvironment env) {
		this.stage = stage;
		this.env = env;
		fxmls.put(WelcomePageController.class, "scott/transource/welcome/welcome.fxml");
	}
	
	public void showScene(Class<?> controller) {
		LoadedScene<?> loadedScene = getOrLoadScene(controller);
		stage.setScene(loadedScene.getScene());
		stage.show();
	}
	
	
	private <T> LoadedScene<T> getOrLoadScene(Class<T> controllerClass) {
		LoadedScene<T> ls = (LoadedScene<T>)loadedScenes.get(controllerClass);
		if (ls == null) {
			ls = new LoadedScene<>(controllerClass, fxmls.get(controllerClass));
			loadedScenes.put(controllerClass, ls);
		}
		return ls;
	}


	private class LoadedScene<T> {
		private final FXMLLoader loader;
		private final Scene scene;
		private final T controller;
		
		public LoadedScene(Class<T> controllerClass, String resource) {
			Objects.requireNonNull(resource, "resource must be specified for controller " + controllerClass);
			URL url = getClass().getClassLoader().getResource(resource);
			Objects.requireNonNull(url, "cannot find resource " + resource);
		    loader = new FXMLLoader( url );
		    loader.setControllerFactory(env::getObject);
		    try {
				loader.load();
			} catch (IOException e) {
				throw new IllegalStateException("Error loading scene " + resource, e);
			}
		    scene = new Scene(loader.getRoot()); 
		    scene.getStylesheets().add("scott/transource/stylesheet.css");
		    controller = env.getObject(controllerClass);
		}

		public FXMLLoader getLoader() {
			return loader;
		}

		public Scene getScene() {
			return scene;
		}

		public T getController() {
			return controller;
		}
		
	}
}
