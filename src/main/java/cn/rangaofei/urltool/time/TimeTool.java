package cn.rangaofei.urltool.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeTool {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String timeStampToTime(long ts) {
        if (ts < 0) {
            return "";
        }
        return sdf.format(ts);
    }

    public static long timeToTimeStamp(String time) {
        try {
            return sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
