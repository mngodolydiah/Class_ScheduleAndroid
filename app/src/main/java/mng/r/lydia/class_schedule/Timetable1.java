package mng.r.lydia.class_schedule;

/**
 * Created by user on 5/16/2016.
 */
public class Timetable1 {

    private String course,name,dg,ds;

    public Timetable1(String code,String name, String datg, String dats) {
        super();
        this.course = code;
        this.name = name;
        this.dg = datg;
        this.ds = dats;


    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDg() {
        return dg;
    }

    public void setDg(String dg) {
        this.dg = dg;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    }
