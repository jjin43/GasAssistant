package gasassistant;

import java.io.Serializable;
import java.util.Date;


public class DateEvent implements Serializable, Comparable<DateEvent> {

    private Date date;
    private double unitRate, gallons;

    public DateEvent(Date date, double unitRate, double gallons) {
        this.date = date;
        this.unitRate = unitRate;
        this.gallons = gallons;
    }

    public Date getDate() {
        return date;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public double getGallons() {
        return gallons;
    }

    public double getCost() {
        return unitRate * gallons;
    }

    @Override
    public String toString() { 
        return("Date: " + date + "\n"
        + "Unit Rate: " + unitRate + "\n"
        + "Gallons: " + gallons);
    } 

    @Override
    public int compareTo(DateEvent o) {
        return date.compareTo(o.date);
    }

}