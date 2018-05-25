package scott.transource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import scott.barleydb.api.config.EntityType;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.service.MaintenceService;

public class SettingsController implements Initializable {
	
	@FXML
    ListView<EntityType> entityTypesList;
	
	private final MaintenceService service;
	
	public SettingsController(MaintenceService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
}
