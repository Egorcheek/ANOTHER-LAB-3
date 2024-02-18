package environment.objects;
import environment.Forest;
import environment.Landscape;
import environment.Road;
import human.Trauma;
import environment.objects.*;

import java.util.List;

public class PineNeedles implements HurtingObject {
    final int dangerLevel = 80;
    final int painmeter = 1;
    final int textureLevel = 4;
    public int beTouched() {
        return textureLevel;
    }
    public int getDangerlevel() {
        return dangerLevel;
    }
    public int getPainmeter() {
        return painmeter;
    }
    public Trauma getTrauma() {
        return new Trauma("Легкая боль в стопах");
    }
    private List<Landscape> locations;
    public List<Landscape> checkAvailability() {
        return locations;
    }
    public PineNeedles(){
        this.locations = List.of(new Road());
    }

}
