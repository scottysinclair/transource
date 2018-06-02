package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;
import scott.barleydb.api.core.entity.RefNode;
import scott.barleydb.api.core.proxy.RefNodeProxyHelper;
import java.util.Date;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class BillableWorkComment extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode commentDate;
  private final ValueNode content;
  private final RefNodeProxyHelper billableWork;

  public BillableWorkComment(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    commentDate = entity.getChild("commentDate", ValueNode.class, true);
    content = entity.getChild("content", ValueNode.class, true);
    billableWork = new RefNodeProxyHelper(entity.getChild("billableWork", RefNode.class, true));
  }

  public Long getId() {
    return id.getValue();
  }

  public Long getModifiedAt() {
    return modifiedAt.getValue();
  }

  public void setModifiedAt(Long modifiedAt) {
    this.modifiedAt.setValue(modifiedAt);
  }

  public Date getCommentDate() {
    return commentDate.getValue();
  }

  public void setCommentDate(Date commentDate) {
    this.commentDate.setValue(commentDate);
  }

  public String getContent() {
    return content.getValue();
  }

  public void setContent(String content) {
    this.content.setValue(content);
  }

  public BillableWork getBillableWork() {
    return super.getFromRefNode(billableWork.refNode);
  }

  public void setBillableWork(BillableWork billableWork) {
    setToRefNode(this.billableWork.refNode, billableWork);
  }
}
