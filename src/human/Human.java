package human;

import java.util.ArrayList;
import java.util.List;
import environment.*;
import exeptions.LocationException;

public abstract class Human {
    protected String name;
    protected Landscape place;
    protected ArrayList<Trauma> trauma;
    ArrayList<Trauma> traumas = new ArrayList<>();
    public Landscape getPlace() {
        return place;
    }
    protected void setPlace(Landscape place) {
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
    protected boolean isValidMove(Landscape destination) {
        List<Landscape> availablePaths = place.checkAvailablePath();
        return availablePaths.contains(destination);
    }
    public void move(Landscape destination){
        if (isValidMove(destination)) {
            place = destination;
        } else {
            throw new LocationException("Недопустимое перемещение: " + place.getClass().getSimpleName() +
                    " -> " + destination.getClass().getSimpleName());
        }
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