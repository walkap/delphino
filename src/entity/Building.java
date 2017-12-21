package entity;

//This object is Building that contains rooms

import java.io.Serializable;

public class Building implements Serializable{

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private String name;
    private String area;

    public Building(String name, String area){
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }



}
