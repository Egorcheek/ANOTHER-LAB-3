package human;

import java.util.ArrayList;
import environment.*;
import environment.objects.*;
import exeptions.*;
import enums.*;

public class Alive_human extends Human {
    private int painLevel = 0;
    private int heartRate = 75;
    private int fearlevel = 0;
    final int wakeupchance = 30;
    private Dream dream;
    private SleepStatus sleepStatus = SleepStatus.AWAKE;
    private int bodyTemperature = 36;
    public Alive_human(String name, String clothes, Landscape landscape) {
        this.clothes = clothes;
        this.name = name;
        setPlace(landscape.Location());
        this.trauma = new ArrayList<>();
    }
    public void touch (TouchableObject touchableObject){
        if (touchableObject instanceof TemperatureObject touchableObject1){
            if (sleepStatus == SleepStatus.SLEEP){
                dream.setRealismLevel(dream.getRealismLevel() +  30);
            }
            bodyTemperature = bodyTemperature + touchableObject1.getTemperaturechange();
        } else {
            if(touchableObject instanceof HurtingObject touchableObject2){
                touchableObject2.beTouched();
                if (sleepStatus == SleepStatus.SLEEP){
                    dream.setRealismLevel(dream.getRealismLevel() +  40);
                }
                if (Math.random()*100 < touchableObject2.getDangerlevel()){
                    hurt(touchableObject2);
                }
            } else {
                touchableObject.beTouched();
                if (sleepStatus == SleepStatus.SLEEP){
                    dream.setRealismLevel(dream.getRealismLevel() +  20);
                }
            }
        }
    }
    public void think (String thought){
        System.out.println(name + " подумал: '" + thought + "'");
    }
    public void hurt (HurtingObject hurtingObject){
        painLevel = painLevel + hurtingObject.getPainmeter();
        this.addTrauma(hurtingObject.getTrauma());
    }
    private void checkFearLevel(){
        if (fearlevel >= 10 && fearlevel < 20){
            this.feel(Emotion.FEAR);
        }
        if (painLevel >= 20 && painLevel < 40){
            this.feel(Emotion.HORROR);
        }
        if (painLevel < 10){
            this.feel(Emotion.CALM);
        }
    }
    public void feel (Emotion emotion){

        if(emotion == Emotion.FEAR){
            heartRate = 100;
        }
        if(emotion == Emotion.HORROR){
            heartRate = 150;
        }
        if(emotion == Emotion.CALM){
            heartRate = 75;
        }
    }
    public void see(Dead_human deadHuman) {
        if (this.place == deadHuman.getPlace()){
            throw new LocationException("Невозможно увидеть: люди в разных локациях");
        }
        fearlevel = fearlevel + 10;
        this.checkFearLevel();
    }
    public void sleep(Dream dream) throws SleepException {

        if (this.sleepStatus == SleepStatus.SLEEP){
            throw new SleepException("Невозможно уснуть: человек уже спит!");
        } else{
            this.sleepStatus = SleepStatus.SLEEP;
            this.dream = dream;
        }
    }
    public void wakeup(){
        if (this.sleepStatus == SleepStatus.AWAKE){
            throw new Error("Невозможно проснуться, персонаж не спит!");
        } else{
            if(Math.random()*100 < wakeupchance - dream.getRealismLevel() + heartRate/15){
                this.sleepStatus = SleepStatus.AWAKE;
            }
        }
    }

    public void changefearlevel(int a){
        fearlevel = fearlevel + a;
    }
    @Override
    public void move(Landscape landscape){
        if (Math.random()*50 > fearlevel){
            setPlace(landscape.Location());
        }
    }
}
