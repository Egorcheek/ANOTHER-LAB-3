package environment.objects;

public class Dirt implements TemperatureObject {
    final  int temperatureChange = -2;
    final int textureLevel = 5;
    public int beTouched() {
    return textureLevel;
    }
    public int getTemperaturechange() {
        return temperatureChange;
    }
}
