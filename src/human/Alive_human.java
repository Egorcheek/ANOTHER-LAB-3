import java.util.ArrayList;

public class Alive_human extends Human {
    private int painLevel = 0;
    private int fearlevel = 0;
    private int wakeupchance = 30;
    private Dream dream;
    private SleepStatus sleepStatus = SleepStatus.AWAKE;
    public int getPainLevel() {
        return painLevel;
    }
    private int bodyTemperature = 36;

    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getFearlevel() {
        return fearlevel;
    }

    private void setFearlevel(int fearlevel) {
        this.fearlevel = fearlevel;
    }

    private void setPainLevel(int ppainLevel) {
        painLevel = ppainLevel;
    }

    public Alive_human(String name, String clothes, String place) {
        this.clothes = clothes;
        this.name = name;
        this.place = place;
        this.trauma = new ArrayList<>();
    }

    public void touch (TouchableObject touchableObject){
        touchableObject.beTouched();
        if (sleepStatus == SleepStatus.SLEEP){
            dream.setRealismLevel(dream.getRealismLevel() +  20);
        }
    }
    public void touch (TemperatureObject temperatureObject){
        temperatureObject.beTouched();
        if (sleepStatus == SleepStatus.SLEEP){
            dream.setRealismLevel(dream.getRealismLevel() +  30);
        }
        bodyTemperature = bodyTemperature + temperatureObject.getTemperaturechange();
    }
    public void touch (HurtingObject hurtingObject){
        hurtingObject.beTouched();
        if (sleepStatus == SleepStatus.SLEEP){
            dream.setRealismLevel(dream.getRealismLevel() +  40);
        }
        if (Math.random()*100 < hurtingObject.getDangerlevel()){
            hurt(hurtingObject);
        }
    }

    public void think (String thought){
        System.out.println(" ");
        System.out.print(name);
        System.out.print(" подумал: '");
        System.out.print(thought);
        System.out.print("'");
    }
    public void hurt (HurtingObject hurtingObject){
        painLevel = painLevel + hurtingObject.getPainmeter();
        this.addTrauma(hurtingObject.getTrauma());
       // this.checkPainLevel();
    }
    /*private void checkPainLevel(){
        if (painLevel >= 10 && painLevel < 20){
            System.out.println(" ");
            System.out.print(name);
            System.out.print(" вздрогнул от боли! ");
        }
        if (painLevel >= 20 && painLevel < 40){
            System.out.println(" ");
            System.out.print(name);
            System.out.print(" вскрикнул от боли! ");
        }
        if (painLevel >= 40 && painLevel < 60){
            System.out.println(" ");
            System.out.print(name);
            System.out.print(" ОРЕТ ОТ БОЛИ! ");
        }
    }*/
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
        }
        if(emotion == Emotion.HORROR){
        }
        if(emotion == Emotion.CALM){
        }
    }

    public void see(Dead_human deadHuman) {
        fearlevel = fearlevel + 10;
        this.checkFearLevel();
    }
    public void checkTrauma() {
        if (trauma.isEmpty()) {
            System.out.println(name + " не имеет травм.");
        } else {
            System.out.println(name + " имеет следующие травмы:");
            for (Trauma ttrauma : trauma) {
                System.out.println("- " + ttrauma.getDescription());
            }
        }
    }
    public void sleep(Dream dream) throws SleepException{

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
            if(Math.random()*100 < wakeupchance - dream.getRealismLevel()){
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
            landscape.changeLocation();
        }
    }
}
