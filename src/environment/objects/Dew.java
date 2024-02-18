package environment.objects;

import environment.Landscape;
import environment.Road;

import java.util.List;

public class Dew implements TouchableObject {
    final int textureLevel = 2;
    public int beTouched() {
        return textureLevel;
    }
    private List<Landscape> locations;
    public List<Landscape> checkAvailability() {
        return locations;
    }
    public Dew(){
        this.locations = List.of(new Road());
    }
}
