import environment.*;
import environment.objects.*;
import exeptions.SleepException;
import human.Alive_human;
import human.Dead_human;
import human.Dream;
import human.Trauma;
import storyline.Helper;
import java.util.List;

public class Main {


    public static void main(String[] args){

        TouchableObject dew = new TouchableObject() {
            @Override
            public int beTouched() {
                return 3;}
        };

        Hill hill = new Hill();
        Road road = new Road();
        Carpet carpet = new Carpet();
        Branch branch = new Branch();
        Lawn lawn = new Lawn();
        Forest forest = new Forest();
        Dirt dirt = new Dirt();
        PineNeedles pineNeedles = new PineNeedles();
        Garage garage = new Garage();
        Trauma brokenCollarbone = new Trauma("cломанная ключица");
        Trauma dryBlood = new Trauma("полосы засохшей крови");
        Alive_human louise = new Alive_human("Луис", garage);
        Dead_human pascow = new Dead_human("Паскоу", lawn);
        pascow.addTrauma(brokenCollarbone);
        pascow.addTrauma(dryBlood);
        Dream louisesdream = new Dream(louise);
        lawn.setNeighbors(List.of(road, garage));
        garage.setNeighbors(List.of(road));
        road.setNeighbors(List.of(lawn, garage, forest));
        forest.setNeighbors(List.of(road, hill));
        hill.setNeighbors(List.of(forest));

        Helper plumber = new Helper(19);
        Helper rain_summoner = new Helper(19);
        try {
            louise.sleep(louisesdream);
        } catch (SleepException e){
            System.out.println(e.getMessage());
        }
        louise.see(pascow);
        pascow.lookBack();
        pascow.showEyes(louise);
        louise.see(pascow.checkTrauma());
        if(plumber.equals(rain_summoner)){
            boolean help = false;
        }
        pascow.move(road);
        louise.move(road);
        louise.touch(carpet);
        louise.touch(dew);
        louise.touch(pineNeedles);
        louise.think("Не думай об этом. Ты дома, в своей постели. Это всего лишь сон, не важно, насколько он правдоподобен. Как все другие сны, утром он покажется тебе смешным");
        louise.touch(branch);
        pascow.move(forest);
        louise.move(forest);
        louise.think("Я иду по лесу вслед за мертвецом. Я иду за мертвецом на Кладбище домашних животных, и это не сон. Господи, спаси, это не сон. Это наяву");
        louise.move(hill);
        louise.touch(dirt);
        louise.wakeup();
        louise.wakeup();
    }
}