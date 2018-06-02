package scott.transource;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class TransourceUiHelper {


  public static long getNumberOfDays(Date date) {
    LocalDateTime  now = LocalDateTime.now();
    LocalDateTime  ldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    Duration dur = Duration.between(now, ldate);
    return dur.toDays();
  }

  public static String formatNumberOfDays(Date date) {
    long n = getNumberOfDays(date);
    if (n < 0) {
      return (n * -1) + " days ago";
    }
    else if (n == 0) {
      return "today";
    }
    else {
      return "in " + n + " days";
    }
  }

  public static int getPecentageTimeUsed(Date start, Date end) {
    if (start == null) {
      return 0;
    }
    Objects.requireNonNull(end);
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

}
