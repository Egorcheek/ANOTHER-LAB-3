package human;

import environment.Landscape;
import java.util.ArrayList;

public class Dead_human extends Human {

    public Dead_human(String name, String clothes, Landscape landscape){
        this.clothes = clothes;
        this.name = name;
        setPlace(landscape.Location());
        this.trauma = new ArrayList<>();
    }
    public void showEyes(Alive_human aliveHuman){
        aliveHuman.changefearlevel(15);
    }

}
