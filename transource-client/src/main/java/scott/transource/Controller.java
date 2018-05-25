package scott.transource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import scott.barleydb.api.config.EntityType;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.service.MaintenceService;

public class Controller implements Initializable {

  private final MaintenceService service;

  @FXML
  ListView<EntityType> entityTypesList;

  @FXML
  AnchorPane container;

  @FXML
  TextArea  myTextArea;
  @FXML
  TextField myTextField;

  public Controller(MaintenceService service) {
    this.service = service;
  }

  public ListCell<EntityType> toListCell(ListView<EntityType> listView) {
    return new ListCell<EntityType>(){
      @Override
      protected void updateItem(EntityType t, boolean bln) {
          super.updateItem(t, bln);
          if (t != null) {
              setText(t.getInterfaceShortName());
          }
      }};
  }

  @Override
  public void initialize(URL location, ResourceBundle resources){
    List<EntityType> entityTypes = service.getEntityTypes();
    entityTypesList.setCellFactory(this::toListCell);


    entityTypesList.setItems( FXCollections.observableArrayList(entityTypes) );
    entityTypesList.getSelectionModel().selectedItemProperty().addListener((ob, oldV, newValue) -> {
      try {
        service.getAll(newValue).forEach( v -> System.out.println(v.getChild("id", ValueNode.class).getValue() + " " + v.getChild("name", ValueNode.class).getValue()));
      }
      catch (SortServiceProviderException x) {
      }
      catch (BarleyDBQueryException e) {
      }
    });
  }



  public void onTextFieldEnter(){
      myTextArea.setText(myTextArea.getText() + "\n" + myTextField.getText());
      myTextField.clear(); // Clears input field
      myTextArea.end(); //Scrolls to bottom of textArea
  }

}
