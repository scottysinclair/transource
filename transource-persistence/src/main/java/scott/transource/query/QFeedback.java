package scott.transource.query;

import scott.barleydb.api.query.JoinType;
import scott.barleydb.api.query.QProperty;
import scott.barleydb.api.query.QueryObject;
import scott.transource.model.Feedback;
import scott.transource.model.FeedbackRating;

/**
 * Generated from Entity Specification
 *
 * @author scott.sinclair
 */
public class QFeedback extends QueryObject<Feedback> {
  private static final long serialVersionUID = 1L;
  public QFeedback() {
    super(Feedback.class);
  }

  public QFeedback(QueryObject<?> parent) {
    super(Feedback.class, parent);
  }


  public QProperty<Long> id() {
    return new QProperty<Long>(this, "id");
  }

  public QProperty<Long> modifiedAt() {
    return new QProperty<Long>(this, "modifiedAt");
  }

  public QProperty<scott.transource.model.FeedbackRating> rating() {
    return new QProperty<scott.transource.model.FeedbackRating>(this, "rating");
  }

  public QProperty<String> info() {
    return new QProperty<String>(this, "info");
  }
}