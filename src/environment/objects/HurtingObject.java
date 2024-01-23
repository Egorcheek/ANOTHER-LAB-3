package environment.objects;
import human.Trauma;
public interface HurtingObject extends TouchableObject {
    int getDangerlevel();
    int getPainmeter();
    Trauma getTrauma();
}
