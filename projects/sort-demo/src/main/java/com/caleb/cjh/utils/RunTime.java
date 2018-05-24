package com.caleb.cjh.utils;

/**
 * @author calebman
 * @Date 2018-5-17
 * <p>
 * 计时工具类
 * </p>
 */
public class RunTime {

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

    /*
    创建一个计时对象
     */
    public static RunTime generatorRunTimeAndstart() {
        RunTime runTime = new RunTime();
        runTime.setStartRunTime(System.currentTimeMillis());
        return runTime;
    }

    /*
    重新计时
     */
    public void reTiming() {
        this.setStartRunTime(System.currentTimeMillis());
    }


    public void printRunningTime() {
        this.printRunningTime("");
    }

    /**
     * 打印计时信息
     *
     * @param flag 需要额外添加的标志内容
     */
    public void printRunningTime(String flag) {
        this.setEndRunTime(System.currentTimeMillis());
        System.out.println(flag + (this.getEndRunTime() - this.getStartRunTime()) + "ms");
    }
}
