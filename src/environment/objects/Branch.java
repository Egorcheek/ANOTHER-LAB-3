package environment.objects;
import human.Trauma;
public class Branch implements HurtingObject {
    final int painmeter = 10;
    final int dangerlevel = 30;

    public int getPainmeter() {
        return painmeter;
    }

    public int getDangerlevel() {
        return dangerlevel;
    }
    public Trauma getTrauma(){
        return new Trauma("Царапина");
    }
    public void beTouched(){}
}
