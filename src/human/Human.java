package human;

import java.util.ArrayList;
import java.util.Objects;
import environment.*;

public abstract class Human {
    protected String name;
    protected String clothes;
    protected String place;
    protected ArrayList<Trauma> trauma;
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


    /*public void setClothes(String clothes){
        this.clothes = clothes;
    }
    */


    public void see(String obj){

    }
    public void see(String obj, String land){

    }

    public void lookBack(){

    }
    public void move(Landscape landscape){
        landscape.changeLocation();
    }
    public void addTrauma(Trauma trauma){
        this.trauma.add(trauma);
    }

}





//56 page