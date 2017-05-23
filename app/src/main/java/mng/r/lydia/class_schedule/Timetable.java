package mng.r.lydia.class_schedule;

import android.graphics.Bitmap;


public class Timetable {

    private String course,day,time,venue,lec;

    public Timetable(String units,String day, String date, String time, String venue) {
        super();
        this.course = units;
        this.day = day;
        this.lec = date;
        this.time = time;
        this.venue = venue;

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLec() {
        return lec;
    }

    public void setLec(String lec) {
        this.lec = lec;
    }
}
