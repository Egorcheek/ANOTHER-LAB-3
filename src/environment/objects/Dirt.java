package environment.objects;

public class Dirt implements TemperatureObject {
    final  int temperatureChange = -2;
    public void beTouched() {
    }
    public int getTemperaturechange() {
        return temperatureChange;
    }
}
