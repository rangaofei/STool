package cn.rangaofei.urltool.time;

public enum TimeFormat {
    YMDHMS("yyyy-MM-dd hh:mm:ss"),
    YMD("yyyy-MM-dd"),
    YMDHM("yyyy-MM-dd hh:mm"),
    YMDHMSS("yyyy-MM-dd hh:mm:ss:SSS"),
    ;
    private String formatLayout;

    public String getFormatLayout() {
        return formatLayout;
    }

    TimeFormat(String formatLayout) {
        this.formatLayout = formatLayout;
    }

    @Override
    public String toString() {
        return formatLayout;
    }
}
