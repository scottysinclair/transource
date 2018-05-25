package scott.transource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.binding.ObjectConstant;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import scott.barleydb.api.config.EntityType;
import scott.barleydb.api.config.NodeType;
import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.Node;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.service.MaintenceService;

public class SettingsController implements Initializable {

  @FXML
  ListView<EntityType> entityTypesList;

  @FXML
  TableView<Entity> dataTable;

  private final MaintenceService service;

  private ObservableList<Entity> dataList = FXCollections.observableArrayList();

  private Callback<TableColumn<Entity,Object>, TableCell<Entity,Object>> nodeCellFactory;

  private Callback<CellDataFeatures<Entity,Object>, ObservableValue<Object>>  nodeCellValueFactory;

  public SettingsController(MaintenceService service) {
    this.service = service;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    List<EntityType> entityTypes = service.getEntityTypes();
    entityTypesList.setCellFactory(this::toListCell);
    entityTypesList.setItems( FXCollections.observableArrayList(entityTypes) );
    entityTypesList.getSelectionModel().selectedItemProperty().addListener((ob, oldEntityType, newEntityType) -> {
        setTableColumns(newEntityType);
        populateTableWithEntityDataForType(newEntityType);
    });

    dataTable.setEditable(true);
    nodeCellFactory = new Callback<TableColumn<Entity,Object>, TableCell<Entity,Object>>() {
            public TableCell<Entity,Object> call(TableColumn<Entity,Object> col) {
                return new EditingCell();
            }
        };


     dataTable.setItems(dataList);


  }



  private void setTableColumns(EntityType entityType) {
    dataTable.getColumns().clear();
    for (final NodeType nodeType: entityType.getNodeTypes()) {
      if (nodeType.isPrimaryKey()) {
        continue;
      }
      if (nodeType.getColumnName() == null) { //most likely 1:N relation
        continue;
      }
      if (nodeType.isOptimisticLock()) {
        continue;
      }
      TableColumn<Entity,Object> column = new TableColumn<>( nodeType.getName() );
      column.setPrefWidth(150d);
      column.setCellFactory(nodeCellFactory);

      Callback<TableColumn.CellDataFeatures<Entity,Object>, ObservableValue<Object>> nodeCellValueFactory = new Callback<TableColumn.CellDataFeatures<Entity,Object>, ObservableValue<Object>>() {
        @Override
        public ObservableValue<Object> call(CellDataFeatures<Entity, Object> p) {
          Node node = p.getValue().getChild(nodeType.getName());
          if (node instanceof ValueNode) {
             Object value = ((ValueNode)node).getValue();
             return new ReadOnlyObjectWrapper<Object>(value);
          }
          return null;
        }
      };

      column.setCellValueFactory(nodeCellValueFactory);
      dataTable.getColumns().add( column );
    }
  }

  private void populateTableWithEntityDataForType(EntityType entityType) {
    try {
      dataList.clear();
      List<Entity> result = service.getAll(entityType);
      System.out.println("Loaded " + result.size() + " " +entityType.getInterfaceShortName());
      dataList.addAll(  result );
    }
    catch (SortServiceProviderException | BarleyDBQueryException x) {
      x.printStackTrace();
    }
  }

  public ListCell<EntityType> toListCell(ListView<EntityType> listView) {
    return new ListCell<EntityType>() {
      @Override
      protected void updateItem(EntityType t, boolean bln) {
        super.updateItem(t, bln);
        if (t != null) {
          setText(t.getInterfaceShortName());
        }
      }
    };
  }
  class EditingCell extends TableCell<Entity, Object> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        System.out.println("UI " + item + " " + empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
         //     Entity e = (Entity) getTableRow().getItem();
              getTableColumn().getCellData(1);
                setText(String.valueOf(item));
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                  String value = textField.getText();

                    commitEdit(value);
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}


}
