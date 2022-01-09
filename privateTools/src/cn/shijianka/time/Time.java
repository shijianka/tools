package cn.shijianka.time;

/**
 * 可以测量两个时间标记点间的毫秒值，单位：ms
 */
public class Time {
    private Time() {
    }

    /**
     * 声明枚举变量 毫秒 秒 分 时 天 月 年 世纪
     */
    private enum time {
        ms,
        s,
        minute,
        hour,
        day,
        month,
        year,
        century
    }

    /**
     * 声明开始和结束的时间标记点
     */

    private static long start = 0;
    private static long end = 0;

    /**
     * 第一次调用会标记一个时间点
     * 第二次调用会返回距离标记时间点的毫秒值，并清除时间标记点
     */
    public static long timeTest() {
        end = start == 0 ? 0 : System.currentTimeMillis();
        start = start == 0 ? System.currentTimeMillis() : start;
        long result = end - start;
        result = start != 0 && end != 0 ? result : 0;
        if (result != 0) {
            reSet();
        }
        return result;
    }

    /**
     * 清除标记点
     */
    public static void reSet() {
        start = 0;
        end = 0;
    }

    public static long timeTest(time type) {
        switch (type) {
            case ms:
                return timeTest();
            case s:
                return switchSeconds(timeTest());
            case minute:
                return switchMinutes(timeTest());
            case hour:
                return switchHours(timeTest());
            case day:
                return switchDays(timeTest());
            case month:
                return switchMonths(timeTest());
            case year:
                return switchYears(timeTest());
            case century:
                return switchCentury(timeTest());
            default:
                return -1;
        }
    }

    /**
     * 将毫秒值的转换为秒值
     */
    public static long switchSeconds(long ms) {
        return ms / 1000;
    }

    /**
     * 将毫秒值的转换为分钟值
     */
    public static long switchMinutes(long ms) {
        return ms / 1000 / 60;
    }


    /**
     * 将毫秒值的转换为小时
     */
    public static long switchHours(long ms) {
        return ms / 1000 / 60 / 60;
    }

    /**
     * 将毫秒值的转换为日
     */
    public static long switchDays(long ms) {
        return ms / 1000 / 60 / 60 / 24;
    }

    /**
     * 将毫秒值的转换月
     */
    public static long switchMonths(long ms) {
        return ms / 1000 / 60 / 60 / 24 / 30;
    }


    /**
     * 将毫秒值的转换年
     */
    public static long switchYears(long ms) {
        return ms / 1000 / 60 / 60 / 24 / 30 / 12;
    }

    /**
     * 将毫秒值转换为世纪
     */
    public static long switchCentury(long ms) {
        return ms / 1000 / 60 / 60 / 24 / 30 / 12 / 100;
    }
}


