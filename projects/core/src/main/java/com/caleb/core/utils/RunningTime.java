package com.caleb.core.utils;

/**
 * @author calebman
 * @Date 2018-5-17
 * <p>
 * 计时工具类
 * </p>
 */
public class RunningTime {

    /*
    计时开启时间
     */
    long startRunTime = 0;
    /*
    计时结束时间
     */
    long endRunTime = 0;

    public long getStartRunTime() {
        return startRunTime;
    }

    public void setStartRunTime(long startRunTime) {
        this.startRunTime = startRunTime;
    }

    public long getEndRunTime() {
        return endRunTime;
    }

    public void setEndRunTime(long endRunTime) {
        this.endRunTime = endRunTime;
    }

    public long getRunningTime() {
        this.setEndRunTime(System.currentTimeMillis());
        return this.getEndRunTime() - this.getStartRunTime();
    }

    public String getFormatTime() {
        long mss = getRunningTime();
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        long millSeconds = mss % 1000;
        if (minutes > 0) {
            return minutes + "m" + seconds + "s";
        }
        if (seconds >= 10) {
            return seconds + "," + millSeconds;
        }
        return millSeconds + "ms";
    }

    /*
     创建一个计时对象
     */
    public static RunningTime generator() {
        RunningTime running = new RunningTime();
        running.setStartRunTime(System.currentTimeMillis());
        return running;
    }

    /*
    重新计时
     */
    public void reComplete() {
        this.setStartRunTime(System.currentTimeMillis());
    }


    public void printInfo() {
        this.printInfo("");
    }

    /**
     * 打印计时信息
     *
     * @param flag 需要额外添加的标志内容
     */
    public void printInfo(String flag) {
        this.setEndRunTime(System.currentTimeMillis());
        System.out.println(flag + " running " + (this.getEndRunTime() - this.getStartRunTime()) + "ms");
    }
}
