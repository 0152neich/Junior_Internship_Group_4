package model;

import java.util.Date;

public class Promotion {
    private String idofpromotion;
    private String idproduction;
    private Date start;
    private Date end;
    private String condition ;
    private String description;

    public Promotion() {
    }

    public Promotion(String idofpromotion, String idproduction, Date start, Date end, String condition, String description) {
        this.idofpromotion = idofpromotion;
        this.idproduction = idproduction;
        this.start = start;
        this.end = end;
        this.condition = condition;
        this.description = description;
    }

    public String getIdofpromotion() {
        return idofpromotion;
    }

    public void setIdofpromotion(String idofpromotion) {
        this.idofpromotion = idofpromotion;
    }

    public String getIdproduction() {
        return idproduction;
    }

    public void setIdproduction(String idproduction) {
        this.idproduction = idproduction;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "idofpromotion='" + idofpromotion + '\'' +
                ", idproduction='" + idproduction + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
