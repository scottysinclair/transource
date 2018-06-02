package scott.transource.welcome;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import scott.barleydb.api.exception.BarleyDBException;
import scott.transource.ClientEnvironment;
import scott.transource.SceneManager;
import scott.transource.customercontract.CustomerContractDetailsController;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.service.TransourceReportingService;
import scott.transource.service.dto.FullSummaryReport;
import scott.transource.service.stream.Stream;
import static scott.transource.TransourceUiHelper.*;

public class WelcomePageController implements Initializable {


  private final ClientEnvironment env;

  private final TransourceReportingService reportingService;

  private final Stage stage;

  @FXML
  Label occ;

  @FXML
  Label osp;

  @FXML
  Label owi;

  @FXML
  Label activeContracts;

  @FXML
  Label nextDeadline;

  @FXML
  TableView<Deadline> deadlinesTable;
  @FXML
  TableColumn<Deadline, String> tdWhat;
  @FXML
  TableColumn<Deadline, String> tdWho;
  @FXML
  TableColumn<Deadline, String> tdWhen;
  @FXML
  TableColumn<Deadline, String> tdTime;

  @FXML
  TableView<CustomerContractRow> customerContractsTable;
  @FXML
  TableColumn<CustomerContractRow, String> tcCust;
  @FXML
  TableColumn<CustomerContractRow, String> tcValue;
  @FXML
  TableColumn<CustomerContractRow, String> tcDue;
  @FXML
  TableColumn<CustomerContractRow, String> tcTime;



  private FullSummaryReport summaryReport;
  private final ObservableList<Deadline> deadlinesTableData = FXCollections.observableArrayList();
  private final ObservableList<CustomerContractRow> customerContractsTableData = FXCollections.observableArrayList();

  public WelcomePageController(ClientEnvironment env, Stage stage) {
    this.env = env;
    this.reportingService = env.getObject(TransourceReportingService.class);
    this.stage = stage;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      summaryReport = reportingService.getFullSummaryReport();

      update(occ, getOverdueCustomerContracts());
      update(osp, getOverdueServiceProviderContracts());
      update(owi, getOverdueWorkItems());
      updateNextDeadline();
      update(activeContracts, summaryReport.getActiveContracts());
      initializeTables();
    }
    catch(BarleyDBException x) {
      throw new IllegalStateException("Error loading welcome page", x);
    }
  }

  private void update(Label label, int number) {
    label.setText( replaceFirstWord(label.getText(), number) );
  }

  private void updateNextDeadline() throws BarleyDBException {
    List<BillableWorkDto> billableWork = reportingService.getOpenBillableWork(true);
    if (billableWork.isEmpty()) {
      nextDeadline.setText("No pending billable work");
    }
    else {
      BillableWorkDto next = billableWork.get(0);
      long numberOfDays = getNumberOfDays(next.getDueDate());
      if (numberOfDays > 0) {
        nextDeadline.setText("Next deadline in " + numberOfDays + " days.");
      }
      else if (numberOfDays == 0) {
        nextDeadline.setText("Next deadline is today");
      }
      else {
        nextDeadline.setText("Next deadline was " + (numberOfDays * -1) + " ago");
      }
    }

  }

  private int getOverdueCustomerContracts() {
    return (int)summaryReport.getOverdueContracts().stream()
    .filter( Stream::customerContracts )
    .count();
  }

  public int getOverdueWorkItems() {
    return summaryReport.getOverdueWork().size();
  }

  private int getOverdueServiceProviderContracts() {
    return (int)summaryReport.getOverdueContracts().stream()
    .filter( Stream::serviceProviderContracts )
    .count();
  }

  private static final Pattern firstWord = Pattern.compile("\\A(\\S+)\\s");
  private String replaceFirstWord(String text, int number) {
    return text.replaceFirst("\\S+", "" + number);
  }

  private void initializeTables() throws BarleyDBException {
     tdWhat.setCellValueFactory(new PropertyValueFactory<>("what"));
     tdWho.setCellValueFactory(new PropertyValueFactory<>("who"));
     tdWhen.setCellValueFactory(new PropertyValueFactory<>("when"));
     tdTime.setCellValueFactory(new PropertyValueFactory<>("percentageTimeLeft"));
     List<Deadline> deadlines = reportingService.getOpenBillableWork(true).stream()
           .map(Deadline::new)
           .collect(Collectors.toList());

     deadlinesTableData.addAll( deadlines );
     System.out.println(deadlinesTableData);
     deadlinesTable.setItems(deadlinesTableData);
     deadlinesTable.setRowFactory(tv -> {
       TableRow<Deadline> row = new TableRow<>();
       row.setOnMouseClicked(e -> {
         if (e.getClickCount() == 2 && !row.isEmpty()) {
           try {
             env.getObject(SceneManager.class).showScene(CustomerContractDetailsController.class, c -> {
               Long contractId = reportingService.getCustomerContractIdForBillableWork( row.getItem().billableWork);
               c.loadCustomerContract( contractId );
               c.selectBillableWork(row.getItem().billableWork);
             });
           }
           catch(BarleyDBException x) {
             System.out.println("Error loading contract for billable work  " + row.getItem().billableWork.getId());
           }
           System.out.println("click");
         }});
       return row;
     });

     tcCust.setCellValueFactory(new PropertyValueFactory<>("name"));
     tcValue.setCellValueFactory(new PropertyValueFactory<>("value"));
     tcDue.setCellValueFactory(new PropertyValueFactory<>("due"));
     tcTime.setCellValueFactory(new PropertyValueFactory<>("percentageTimeLeft"));
     List<CustomerContractRow> contracts = reportingService.getOpenCustomerContracts(true).stream()
           .map(CustomerContractRow::new)
           .collect(Collectors.toList());

     customerContractsTableData.addAll( contracts );
     System.out.println(contracts);
     customerContractsTable.setItems(customerContractsTableData);

     customerContractsTable.setRowFactory(tv -> {
       TableRow<CustomerContractRow> row = new TableRow<>();
       row.setOnMouseClicked(e -> {
         if (e.getClickCount() == 2 && !row.isEmpty()) {
           try {
             env.getObject(SceneManager.class).showScene(CustomerContractDetailsController.class, c -> {
               c.loadCustomerContract( row.getItem().getId() );
             });
           }
           catch(BarleyDBException x) {
             System.out.println("Error loading contract " + row.getItem().getId());
           }
           System.out.println("click");
         }});
       return row;
     });
  }


  public class Deadline {
    private final BillableWorkDto billableWork;

    public Deadline(BillableWorkDto billableWork) {
      this.billableWork = billableWork;
    }

    public ContractDto getContract() {
      return billableWork.getContract();
    }

    public String getWhat() {
      return billableWork.getWorkItem().getDescription();
    }

    public String getWho() {
      return billableWork.getContact().getFirstName() + " " + billableWork.getContact().getLastName();
    }

    public String getWhen() {
      return formatNumberOfDays(billableWork.getDueDate());
    }

    public String getPercentageTimeLeft() {
      return getPecentageTimeUsed(billableWork.getStartedDate(), billableWork.getDueDate()) + "%";
    }

  }

  public class CustomerContractRow {
    private final ContractDto contract;

    public CustomerContractRow(ContractDto contract) {
      this.contract = contract;
    }

    public Long getId() {
      return contract.getId();
    }

    public String getName() {
      return contract.getName();
    }

    public String getValue() {
      return (reportingService.calculateContractValue(contract) * 100) + " EUR";
    }

    public String getDue() {
      return formatNumberOfDays(contract.getDueDate());
    }

    public String getPercentageTimeLeft() {
      return getPecentageTimeUsed(contract.getCreatedDate(), contract.getDueDate()) + "%";
    }

  }
}
