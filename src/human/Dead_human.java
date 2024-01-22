public class Dead_human extends Human {
    private String Trauma;

    public String getTrauma() {
        return Trauma;
    }

    public void setTrauma(String trauma) {
        Trauma = trauma;
    }

    public Dead_human(String name, String clothes, String place){
        this.clothes = clothes;
        this.name = name;
        this.place = place;
    }
    public void showEyes(Alive_human aliveHuman){
        aliveHuman.changefearlevel(15);
    }

}
