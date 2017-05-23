package mng.r.lydia.class_schedule;

/**
 * Created by user on 3/17/2016.
 */
public class Show {
    String unit;
    String day;
    String date;
    String time;
    String venue;



    String unt;
    String name;
    String dgiven;
    String dsub;


    public Show(String unit,String day,String date,String time,String venue){
     this.unit=unit;
        this.day=day;
        this.date=date;
        this.time=time;
        this.venue=venue;

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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




    public Show(String unt,String name,String dgiven,String dsub){
        this.unt=unt;
        this.name=name;
        this.dgiven=dgiven;
        this.dsub=dsub;


    }

    public String getUnt() {
        return unt;
    }

    public void setUnt(String unt) {
        this.unt = unt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDgiven() {
        return dgiven;
    }

    public void setDgiven(String dgiven) {
        this.dgiven = dgiven;
    }

    public String getDsub() {
        return dsub;
    }

    public void setDsub(String dsub) {
        this.dsub = dsub;
    }


}



