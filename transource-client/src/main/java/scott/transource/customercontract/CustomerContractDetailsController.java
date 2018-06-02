package scott.transource.customercontract;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.transource.ClientEnvironment;
import scott.transource.SceneManager;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.dto.PartnerDto;
import scott.transource.model.Partner;
import scott.transource.service.TransourceReportingService;
import scott.transource.welcome.WelcomePageController;

import static scott.transource.TransourceUiHelper.*;


public class CustomerContractDetailsController implements Initializable {

  @FXML
  Button back;

  @FXML
  TextField ccName;

  @FXML
  TextArea ccDetails;

  @FXML
  Label ccCustomerName;

  @FXML
  Label ccCreatedOn;

  @FXML
  DatePicker ccDueOn;

  @FXML
  Label ccBilledOn;

  @FXML
  Label ccPayedOn;

  @FXML
  TextArea ccFeedbackText;

  @FXML
  TreeTableView<BillableWorkRow> billableWork;
  @FXML
  TreeTableColumn<BillableWorkRow, String> ttcName;
  @FXML
  TreeTableColumn<BillableWorkRow, String> ttcOwner;
  @FXML
  TreeTableColumn<BillableWorkRow, String> ttcCharge;
  @FXML
  TreeTableColumn<BillableWorkRow, String> ttcInfo;


  @FXML
  TextField bwDetailsName;
  @FXML
  TextArea bwDetailsDescription;

  private TreeItem<BillableWorkRow> root =
      new TreeItem<>(new BillableWorkRow(null));

  private final ClientEnvironment env;

  private final TransourceReportingService reportingService;

  private ContractDto customerContract;

  public CustomerContractDetailsController(ClientEnvironment env) {
    this.env = env;
    this.reportingService = env.getObject(TransourceReportingService.class);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    back.setOnAction(ev -> env.getObject(SceneManager.class).showScene(WelcomePageController.class) );

    billableWork.setRoot(root);
    billableWork.setShowRoot(false);

    ttcName.setCellValueFactory(
        (TreeTableColumn.CellDataFeatures<BillableWorkRow, String> param) ->
        new ReadOnlyStringWrapper(param.getValue().getValue().getName())
    );

    ttcOwner.setCellValueFactory(
        (TreeTableColumn.CellDataFeatures<BillableWorkRow, String> param) ->
        new ReadOnlyStringWrapper(param.getValue().getValue().getOwner())
    );

    ttcCharge.setCellValueFactory(
        (TreeTableColumn.CellDataFeatures<BillableWorkRow, String> param) ->
        new ReadOnlyStringWrapper(param.getValue().getValue().getCharge())
    );

    ttcInfo.setCellValueFactory(
        (TreeTableColumn.CellDataFeatures<BillableWorkRow, String> param) ->
        new ReadOnlyStringWrapper(param.getValue().getValue().getInfo())
    );

    billableWork.setRowFactory(tv -> {
      TreeTableRow<BillableWorkRow> row = new TreeTableRow<>();
      row.setOnMouseClicked(event -> showBillableWorkDetails( row.getItem().billableWork ));
      return row;
    });

  }

  private void showBillableWorkDetails(BillableWorkDto billableWorkDto) {
    if (billableWorkDto != null) {
      bwDetailsName.setText(billableWorkDto.getWorkItem().getName());
      bwDetailsDescription.setText(billableWorkDto.getWorkItem().getDescription());
    }
    else {
      bwDetailsName.setText(null);
      bwDetailsDescription.setText(null);
    }
  }

  public void loadCustomerContract(Long customerContractId) throws SortServiceProviderException, BarleyDBQueryException {
    customerContract = reportingService.loadFullContract(customerContractId);

    ccName.setText( customerContract.getName() );
    ccDetails.setText( customerContract.getDescription() );
    ccCustomerName.setText( customerContract.getName() );
    ccCreatedOn.setText(formatDate(customerContract.getCreatedDate(), ""));

    Date dueDate = customerContract.getDueDate();
    ccDueOn.setChronology(IsoChronology.INSTANCE);
    LocalDate localDueDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    ccDueOn.setValue(LocalDate.from(localDueDate));
    ccBilledOn.setText(formatDate(customerContract.getBilledDate(), "not yet billed"));
    ccPayedOn.setText(formatDate(customerContract.getPayedDate(), "not yet payed"));
    if (customerContract.getFeedback() != null) {
      ccFeedbackText.setText( customerContract.getFeedback().getInfo());
    }

    root.getChildren().clear();
    customerContract.getBillableWork().stream().forEach(bw -> {
      root.getChildren().add(new TreeItem<>(new BillableWorkRow(bw)));
    });
    showBillableWorkDetails(null);
  }

  private String formatDate(Date createdDate, String defaultValue) {
    return createdDate != null ? String.valueOf(createdDate) : defaultValue;
  }

  public static class BillableWorkRow {
    private final BillableWorkDto billableWork;

    public BillableWorkRow(BillableWorkDto billableWork) {
      this.billableWork = billableWork;
    }

    public String getName() {
      return billableWork.getWorkItem().getName();
    }

    public String getOwner() {
      return billableWork.getContact().getFirstName() + " " + billableWork.getContact().getLastName();
    }

    public String getCharge() {
      return billableWork.getChargeAmount() + " - " + billableWork.getChargeType();
    }

    public BillableWorkDto getBillableWork() {
      return billableWork;
    }

    public String getInfo() {
      if (billableWork.getStartedDate() == null) {
        return "not started";
      }
      else if (billableWork.getCompletedDate() != null) {
        return "completed on " + billableWork.getDueDate();
      }
      return "due " + formatNumberOfDays(billableWork.getDueDate());
    }

  }

  public void selectBillableWork(BillableWorkDto billableWorkDto) {
    TreeItem<BillableWorkRow> node = findTreeItemFor(billableWork.getRoot(), billableWorkDto);
    if (node != null) {
      showBillableWorkDetails(node.getValue().billableWork);
      int row = billableWork.getRow( node );
      billableWork.getSelectionModel().select(row);
      billableWork.requestFocus();
    }
  }

  private TreeItem<BillableWorkRow> findTreeItemFor(TreeItem<BillableWorkRow> node, BillableWorkDto billableWorkDto) {
    if (node.getValue().billableWork != null && Objects.equals(node.getValue().billableWork.getId(), billableWorkDto.getId())) {
      return node;
    }
    for (TreeItem<BillableWorkRow> child: node.getChildren()) {
      TreeItem<BillableWorkRow> found = findTreeItemFor(child, billableWorkDto);
      if (found != null) {
        return found;
      }
    }
    return null;
  }


}
