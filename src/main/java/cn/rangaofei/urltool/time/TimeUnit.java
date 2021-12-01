package cn.rangaofei.urltool.time;

public enum TimeUnit {
    MILL_SECOND("毫秒(ms)"),
    SECOND("秒(s)"),
    ;
    private String name;

    TimeUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
