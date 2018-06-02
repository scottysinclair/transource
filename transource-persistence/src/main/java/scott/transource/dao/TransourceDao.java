package scott.transource.dao;

import java.util.Date;
import java.util.List;

import scott.barleydb.api.core.Environment;
import scott.barleydb.api.core.entity.EntityContext;
import scott.barleydb.api.core.entity.ProxyController;
import scott.barleydb.api.dto.BaseDto;
import scott.barleydb.api.dto.DtoConverter;
import scott.barleydb.api.exception.execution.SortServiceProviderException;
import scott.barleydb.api.exception.execution.query.BarleyDBQueryException;
import scott.barleydb.api.query.QueryObject;
import scott.transource.TransourceEntityContext;
import scott.transource.dto.BillableWorkDto;
import scott.transource.dto.ContractDto;
import scott.transource.dto.WorkItemDto;
import scott.transource.model.BillableWork;
import scott.transource.model.PartnerType;
import scott.transource.query.QBillableWork;
import scott.transource.query.QContract;

public class TransourceDao {

  private final Environment env;

  public TransourceDao(Environment env) {
    this.env = env;
  }

  public List<ContractDto> getOverdueContracts() throws SortServiceProviderException, BarleyDBQueryException {
    QContract query = new QContract();
    query.where(query.completedDate().isNull())
         .and(query.dueDate().lessOrEqual( now() ));

    return queryAndConvert(query, ContractDto.class);
  }

  public List<BillableWorkDto> getOverdueWork() throws SortServiceProviderException, BarleyDBQueryException {
    EntityContext ctx = newCtx();

    QBillableWork query = new QBillableWork();
    query.where(query.completedDate().isNull())
         .and(query.dueDate().lessOrEqual( now() ));

    ctx.performQuery( query );

    DtoConverter conv = new DtoConverter(ctx);
    conv.convertToDtos();

    List<BillableWork> billableWork = ctx.performQuery(query).getList();
    return conv.getDtos(billableWork, BillableWorkDto.class);
  }

  public List<ContractDto> getActiveContracts() throws SortServiceProviderException, BarleyDBQueryException {
    QContract query = new QContract();
    query.where( query.completedDate().isNull() );

    return queryAndConvert(query, ContractDto.class);
  }

  public List<BillableWorkDto> getOpenBillableWorkWithAssocContactAndWorkItem() throws SortServiceProviderException, BarleyDBQueryException {
    QBillableWork query = new QBillableWork();
    query.joinToContact();
    query.joinToWorkItem();
    query.where(query.completedDate().isNull() );

    return queryAndConvert(query, BillableWorkDto.class);
  }

  public List<BillableWorkDto> getBillableWorkWithAssocContactAndWorkItemFor(WorkItemDto workItem) throws SortServiceProviderException, BarleyDBQueryException {
    QBillableWork query = new QBillableWork();
    query.joinToContact();
    query.joinToWorkItem();
    query.where(query.workItemId().equal( workItem.getId() ));

    return queryAndConvert(query, BillableWorkDto.class);
  }


  public List<ContractDto> getOpenCustomerContracts(boolean oldestFirst) throws SortServiceProviderException, BarleyDBQueryException {
    QContract query = new QContract();
    query.where( query.completedDate().isNull() )
         .and(query.partnerType().equal( PartnerType.CUSTOMER ))
         .orderBy( query.createdDate(), true);

    return queryAndConvert(query, ContractDto.class);
  }

  public ContractDto loadFullContract(Long id) throws SortServiceProviderException, BarleyDBQueryException {
    QContract query = new QContract();
    query.joinToPartner();
    query.joinToFeedback();
    QBillableWork qbw = query.joinToBillableWork();
    qbw.joinToWorkItem();
    qbw.joinToContact();

    query.where(query.id().equal(id));
    return querySingleAndConvert(query, ContractDto.class);
  }


  private EntityContext newCtx() {
    EntityContext ctx = new TransourceEntityContext(env);
    ctx.setAllowGarbageCollection(false);
    return ctx;
  }

  private <T extends BaseDto, E extends ProxyController> T querySingleAndConvert(QueryObject<E> query, Class<T> type) throws SortServiceProviderException, BarleyDBQueryException {
    EntityContext ctx = newCtx();

    E item = ctx.performQuery( query ).getSingleResult();

    DtoConverter conv = new DtoConverter(ctx);
    conv.convertToDtos();

    return conv.getDto(item);
  }

  private <T extends BaseDto, E extends ProxyController> List<T> queryAndConvert(QueryObject<E> query, Class<T> type) throws SortServiceProviderException, BarleyDBQueryException {
    EntityContext ctx = newCtx();

    List<E> list = ctx.performQuery( query ).getList();

    DtoConverter conv = new DtoConverter(ctx);
    conv.convertToDtos();

    return conv.getDtos(list, type);
  }

  /**
  *
  * @return
  */
 private Date now() {
   return new Date();
 }

}
