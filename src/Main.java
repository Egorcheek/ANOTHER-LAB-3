public class Main {


    public static void main(String[] args) throws Exception {

        TouchableObject dew = new TouchableObject() {
            @Override
            public void beTouched() {}
        };
        TouchableObject pine = new TouchableObject() {
            @Override
            public void beTouched() {}
        };

        Narrator narrator = new Narrator();
        Dead_human pascow = new Dead_human("Паскоу", "Шорты", "Лужайка");
        pascow.setTrauma("cломанная ключица, полосы засохшей крови");
        Hill hill = new Hill();
        Road road = new Road();
       // Dew dew = new Dew();
        Carpet carpet = new Carpet();
        Branch branch = new Branch();
        Lawn lawn = new Lawn();
        Dirt dirt = new Dirt();
        Pine_needles pineNeedles = new Pine_needles();
        Alive_human louise = new Alive_human("Луис", "неизвестно", "Гараж");
        Dream louisesdream = new Dream(louise);

        Helper plumber = new Helper();
        Helper rain_summoner = new Helper();
        plumber.setPossibility(19);
        rain_summoner.setPossibility(19);
        try {
            louise.sleep(louisesdream);
        } catch (SleepException e){
            System.out.println(e.getMessage());
        }
        louise.see(pascow);
        louise.move(lawn);
        pascow.lookBack();
        pascow.showEyes(louise);
        louise.see(pascow.getTrauma());
        if(plumber == rain_summoner){
            boolean help = false;
        }
        pascow.move(road);
        louise.move(road);
        louise.touch(carpet);
        louise.touch(dew);
        louise.touch(pineNeedles);
        louise.think("Не думай об этом. Ты дома, в своей постели. Это всего лишь сон, не важно, насколько он правдоподобен. Как все другие сны, утром он покажется тебе смешным");
        louise.touch(branch);
        louise.changefearlevel(100);
        louise.think("Я иду по лесу вслед за мертвецом. Я иду за мертвецом на Кладбище домашних животных, и это не сон. Господи, спаси, это не сон. Это наяву");
        louise.move(hill);
        louise.touch(dirt);
        louise.wakeup();
        louise.wakeup();
    }
}