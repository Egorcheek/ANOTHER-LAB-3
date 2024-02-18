package environment.objects;
import environment.Forest;
import environment.Landscape;
import environment.Road;
import human.Trauma;

import java.util.List;

public class Branch implements HurtingObject {
    final int painmeter = 10;
    final int dangerlevel = 30;
    final int textureLevel = 3;
    public int getPainmeter() {
        return painmeter;
    }

    public int getDangerlevel() {
        return dangerlevel;
    }
    public Trauma getTrauma(){
        return new Trauma("Царапина");
    }
    public int beTouched(){
        return textureLevel;
    }
    private List<Landscape> locations;
    public List<Landscape> checkAvailability() {
        return locations;
    }
    public Branch(){
        this.locations = List.of(new Forest());
    }
}
