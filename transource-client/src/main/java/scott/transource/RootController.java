package scott.transource;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import scott.transource.service.MaintenceService;

public class RootController implements Initializable {

  private final MaintenceService service;

  private final Stage stage;

  private NoArgNoReturnCall openSettings;

  @FXML
  ToggleButton settingsButton;


  public RootController(MaintenceService service, Stage stage) {
    this.service = service;
    this.stage = stage;
  }


  public void setOpenSettings(NoArgNoReturnCall openSettings) {
    this.openSettings = openSettings;
  }

@Override
  public void initialize(URL location, ResourceBundle resources){
    stage.getIcons().add(new Image(getClass().getResourceAsStream("icon/settings.png")));
    //settingsButton.setOnAction(a -> {System.out.println("pressed");});

    settingsButton.setOnAction(a -> { openSettings.call(); });

  }



}
