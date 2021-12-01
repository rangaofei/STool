package cn.rangaofei.urltool.time;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeTool {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String timeStampToTime(String ts, TimeUnit timeUnit) {
        if (StringUtils.isEmpty(ts)) {
            return "";
        }
        try {
            long timeStamp = Long.parseLong(ts);
            if (timeUnit == TimeUnit.SECOND) {
                timeStamp = timeStamp * 1000;
            }
            return timeStampToTime(timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String timeStampToTime(long ts) {
        if (ts < 0) {
            return "";
        }
        return sdf.format(ts);
    }

    public static long timeToTimeStamp(String time, TimeUnit timeUnit) {
        if (StringUtils.isEmpty(time)) {
            return 0;
        }
        long millSeconds = timeToTimeStamp(time);
        if (timeUnit == TimeUnit.SECOND) {
            millSeconds = millSeconds / 1000;
        }
        return millSeconds;
    }


    private static long timeToTimeStamp(String time) {
        try {
            return sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
