package environment.objects;
import human.Trauma;
public interface HurtingObject extends TouchableObject {
    public int getDangerlevel();
    public int getPainmeter();
    public Trauma getTrauma();
}
