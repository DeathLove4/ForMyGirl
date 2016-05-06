package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Death丶Love on 2016/5/6.
 */
public class AllUtils {
    /**
     * @param nowDate 当前系统时间
     * @return 相遇时间
     */
    public static String getTwoDay(Date nowDate) {
        SimpleDateFormat myFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        long day = 0;
        try {
            Date metDate = myFormatter.parse("2016-03-26 18:34:00");

            day = (nowDate.getTime() - metDate.getTime())
                    / (24 * 60 * 60 * 1000);

            // 这里精确到了秒，我们可以在做差的时候将时间精确到天
        } catch (Exception e) {
            return "";
        }

        return day + "";
    }
}
