package com.hackfmi.sport.squad.web.controller.command;

import com.hackfmi.sport.squad.domain.DayOfWeek;

/**
 * Created by inakov on 14-11-8.
 */
public class Moments {
    private DayOfWeek day;
    private Integer hour;

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}
