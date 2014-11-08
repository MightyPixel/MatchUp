package com.hackfmi.sport.squad.domain;

/**
 * Created by inakov on 14-11-8.
 */
public class ScheduleInterval {
    DayOfWeek dayOfWeek;
    Daytime daytime;

    public ScheduleInterval(){}

    public ScheduleInterval(DayOfWeek dayOfWeek, Daytime daytime) {
        this.dayOfWeek = dayOfWeek;
        this.daytime = daytime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Daytime getDaytime() {
        return daytime;
    }

    public void setDaytime(Daytime daytime) {
        this.daytime = daytime;
    }
}
