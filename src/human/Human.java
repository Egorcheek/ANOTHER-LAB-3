package human;

import java.util.ArrayList;
import environment.*;
import exeptions.LocationException;

public abstract class Human {
    protected String name;
    protected String place;
    protected ArrayList<Trauma> trauma;
    ArrayList<Trauma> traumas = new ArrayList<>();
    public String getPlace() {
        return place;
    }
    protected void setPlace(String place) {
        this.place = place;
    }
    public void see(String obj){

    }
    public void see(Human human) throws LocationException {
        if (this.place == human.getPlace()){
            throw new LocationException("Невозможно увидеть: люди в разных локациях");
        }
    }
    public void lookBack(){

    }
    public void move(Landscape landscape){
        setPlace(landscape.Location());
    }
    public void addTrauma(Trauma trauma){
        this.trauma.add(trauma);
    }
    public String checkTrauma() {
        StringBuilder result = new StringBuilder();
        for (Trauma ttrauma : trauma) {
            result.append(ttrauma.getDescription()).append(", ");
        }
        if (!result.isEmpty()){
            result.delete(result.length() - 2, result.length());
        }
        return (result.toString());
    }
}





//56 page