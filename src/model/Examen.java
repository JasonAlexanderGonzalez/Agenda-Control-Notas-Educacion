
package model;

public class Examen {
    
    protected String date;
    protected int points;
    protected double average;
    
    public Examen(){
        
    }

    public Examen(String date, int points, double average) {
        this.date = date;
        this.points = points;
        this.average = average;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return   date + ";" + points + ";" + average + "%";
    }
    
    
    
}
