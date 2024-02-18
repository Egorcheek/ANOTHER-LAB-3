package environment.objects;

import environment.Hill;
import environment.Landscape;

import java.util.List;

public class Dirt implements TemperatureObject {
    final  int temperatureChange = -2;
    final int textureLevel = 5;
    public int beTouched() {
    return textureLevel;
    }
    public int getTemperaturechange() {
        return temperatureChange;
    }
    private List<Landscape> locations;
    public List<Landscape> checkAvailability() {
        return locations;
    }
    public Dirt(){
        this.locations = List.of(new Hill());
    }
}
