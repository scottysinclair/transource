package scott.transource.welcome;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.IntSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.dto.CustomerDto;
import scott.transource.model.BillableWork;
import scott.transource.service.TransourceReportingService;
import scott.transource.service.dto.FullSummaryReport;
import scott.transource.service.stream.Stream;

public class WelcomePageController implements Initializable {

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

	public WelcomePageController(TransourceReportingService reportingService, Stage stage) {
		this.reportingService = reportingService;
		this.stage = stage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		summaryReport = reportingService.getFullSummaryReport();
		
		update(occ, getOverdueCustomerContracts());
		update(osp, getOverdueServiceProviderContracts());
		update(owi, getOverdueWorkItems());
		updateNextDeadline();
		update(activeContracts, summaryReport.getActiveContracts());
		initializeTables();
	}

	private void update(Label label, int number) {
		label.setText( replaceFirstWord(label.getText(), number) );
	}
	
	private void updateNextDeadline() {
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

	private long getNumberOfDays(Date date) {
		LocalDateTime  now = LocalDateTime.now();
		LocalDateTime  ldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		Duration dur = Duration.between(now, ldate);
		return dur.toDays();
	}
	
	private String formatNumberOfDays(Date date) {
		long n = getNumberOfDays(date);
		if (n < 0) {
			return (n * -1) + " days ago";
		}
		else if (n == 0) {
			return "today";
		}
		else {
			return n + " days";
		}
	}

	private int getPecentageTimeUsed(Date start, Date end) {
		if (end.getTime() <= System.currentTimeMillis()) {
			return 100;
		}
		LocalDateTime  now = LocalDateTime.now();
		LocalDateTime  lstart = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime  lend = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		Duration fullDur = Duration.between(lstart, lend);
		Duration sofarDur = Duration.between(lstart, now);
		return (int)( ((float)sofarDur.toDays() / (float)fullDur.toDays()) * 100f );
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
	
	private void initializeTables() {
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
		 
		 
	}
	
	public class Deadline {
		private final BillableWorkDto billableWork;

		public Deadline(BillableWorkDto billableWork) {
			this.billableWork = billableWork;
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
