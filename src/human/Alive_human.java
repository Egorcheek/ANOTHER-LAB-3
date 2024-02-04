package human;

import java.util.ArrayList;
import java.util.Objects;

import environment.*;
import environment.objects.*;
import exeptions.*;
import enums.*;

public class Alive_human extends Human {
    private class Feelings {
        private int fearlevel = 0;
        private int painLevel = 0;
    }
    Feelings feelings = new Feelings();
    private int heartRate = 75;

    final int wakeupchance = 30;
    private Dream dream;
    private SleepStatus sleepStatus = SleepStatus.AWAKE;
    private int bodyTemperature = 36;
    public Alive_human(String name, Landscape landscape) {
        this.name = name;
        setPlace(landscape);
        this.trauma = new ArrayList<>();
    }
    public void touch (TouchableObject touchableObject){
        if (touchableObject instanceof TemperatureObject touchableObject1){
            if (sleepStatus == SleepStatus.SLEEP){
                dream.setRealismLevel(dream.getRealismLevel() +  30 + touchableObject1.beTouched());
            }
            bodyTemperature = bodyTemperature + touchableObject1.getTemperaturechange();
        } else {
            if(touchableObject instanceof HurtingObject touchableObject2){
                if (sleepStatus == SleepStatus.SLEEP){
                    dream.setRealismLevel(dream.getRealismLevel() +  40 + touchableObject2.beTouched());
                }
                if (Math.random()*100 < touchableObject2.getDangerlevel()){
                    hurt(touchableObject2);
                }
            } else {
                if (sleepStatus == SleepStatus.SLEEP){
                    dream.setRealismLevel(dream.getRealismLevel() +  20 + touchableObject.beTouched());
                }
            }
        }
    }
    public void think (String thought){
        System.out.println(name + " подумал: '" + thought + "'");
    }
    public void hurt (HurtingObject hurtingObject){
        feelings.painLevel = feelings.painLevel + hurtingObject.getPainmeter();
        this.addTrauma(hurtingObject.getTrauma());
    }
    private void checkFearLevel(){
        if (feelings.fearlevel >= 10 && feelings.fearlevel < 20){
            this.feel(Emotion.FEAR);
        }
        if (feelings.fearlevel >= 20 && feelings.fearlevel < 40){
            this.feel(Emotion.HORROR);
        }
        if (feelings.fearlevel < 10){
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
        if (Objects.equals(this.place, deadHuman.getPlace())){

            System.out.println("ОШИБКА");
        new LocationException("Невозможно увидеть: люди в разных локациях");
        }
        feelings.fearlevel = feelings.fearlevel + 10;
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
        feelings.fearlevel = feelings.fearlevel + a;
    }
}
