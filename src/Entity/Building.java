package Entity;

//This object is Building that contains rooms

public class Building {

    private String name;

    private int numbersOfFloors;

    public Building(String name, int numbersOfFloors){

        this.name = name;
        this.numbersOfFloors = numbersOfFloors;
    }

    public String getName() {
        return name;
    }

    public int getNumbersOfFloors() {
        return numbersOfFloors;
    }



}
