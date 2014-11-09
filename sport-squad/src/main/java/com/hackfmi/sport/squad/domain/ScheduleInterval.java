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

	public boolean matches(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleInterval other = (ScheduleInterval) obj;
		if (this.daytime == Daytime.IRRELEVANT || other.daytime == Daytime.IRRELEVANT) {
			return (this.dayOfWeek == other.dayOfWeek);
		}
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (daytime != other.daytime)
			return false;
		return true;
	}
    
}
