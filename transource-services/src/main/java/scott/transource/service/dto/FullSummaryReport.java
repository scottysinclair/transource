package scott.transource.service.dto;

import java.util.List;

import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;

public class FullSummaryReport {

	private List<ContractDto> overdueContracts;

	private List<BillableWorkDto> overdueWork;
	
	private int activeContracts;

	public List<ContractDto> getOverdueContracts() {
		return overdueContracts;
	}

	public void setOverdueContracts(List<ContractDto> overdueContracts) {
		this.overdueContracts = overdueContracts;
	}

	public List<BillableWorkDto> getOverdueWork() {
		return overdueWork;
	}

	public void setOverdueWork(List<BillableWorkDto> overdueWork) {
		this.overdueWork = overdueWork;
	}

	public int getActiveContracts() {
		return activeContracts;
	}

	public void setActiveContracts(int activeContracts) {
		this.activeContracts = activeContracts;
	}

}
