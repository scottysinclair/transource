package scott.transource.model;

import scott.barleydb.api.core.entity.Entity;
import scott.barleydb.api.core.entity.ValueNode;
import scott.barleydb.api.core.proxy.AbstractCustomEntityProxy;

/**
 * Generated from Entity Specification
 *
 * @author scott
 */
public class Feedback extends AbstractCustomEntityProxy {
  private static final long serialVersionUID = 1L;

  private final ValueNode id;
  private final ValueNode modifiedAt;
  private final ValueNode rating;
  private final ValueNode info;

  public Feedback(Entity entity) {
    super(entity);
    id = entity.getChild("id", ValueNode.class, true);
    modifiedAt = entity.getChild("modifiedAt", ValueNode.class, true);
    rating = entity.getChild("rating", ValueNode.class, true);
    info = entity.getChild("info", ValueNode.class, true);
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

  public scott.transource.model.FeedbackRating getRating() {
    return rating.getValue();
  }

  public void setRating(scott.transource.model.FeedbackRating rating) {
    this.rating.setValue(rating);
  }

  public String getInfo() {
    return info.getValue();
  }

  public void setInfo(String info) {
    this.info.setValue(info);
  }
}
