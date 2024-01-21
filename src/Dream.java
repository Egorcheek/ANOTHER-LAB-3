public class Dream {
//set characters
    private int realismLevel;
    private Alive_human sleeper;
    public int getRealismLevel() {
        return realismLevel;
    }

    public void setRealismLevel(int realismLevel) {
        this.realismLevel = realismLevel;
    }

    public Dream(Alive_human sleeper) {
        this.sleeper = sleeper;
    }
    public void checkrealism(){
        if (realismLevel > 100){
            sleeper.changefearlevel(2);
        }
    }
}
