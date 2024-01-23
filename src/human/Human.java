package human;

import java.util.ArrayList;
import environment.*;
import exeptions.LocationException;

public abstract class Human {
    protected String name;
    protected String clothes;
    protected String place;
    protected ArrayList<Trauma> trauma;
    ArrayList<Trauma> traumas = new ArrayList<>();
    public String getName(){
        return  name;
    }
    //public String getClothes() {
    //    return clothes;
   // } сделать аррау лист как травмы
    public String getPlace() {
        return place;
    }
    protected void setPlace(String place) {
        this.place = place;
    }
    public void see(String obj){

    }
    public void see(Human human, String land) throws LocationException {
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

}





//56 page