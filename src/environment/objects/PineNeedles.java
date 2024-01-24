package environment.objects;
import human.Trauma;

public class PineNeedles implements HurtingObject {
    final int dangerLevel = 80;
    final int painmeter = 1;
    final int textureLevel = 4;
    public int beTouched() {
        return textureLevel;
    }
    public int getDangerlevel() {
        return dangerLevel;
    }
    public int getPainmeter() {
        return painmeter;
    }
    public Trauma getTrauma() {
        return new Trauma("Легкая боль в стопах");
    }
}
/*
перегрузить метод си
посмотреть, что можно еще перегрузить
хэшкод из первой буквы имени
тустринг?
!!!открыть окно это не написать на бумажке открыть окно
чайник не кипятит сам себя
массив с травмами, вывести его
побольше переменных состояния (репутация, здоровье, жажда, голод и тд). Они могут мекняться без вывода
Сделать вывод с рандомной переменной (человек услышал или не услышал)
создать методж сон, в него поместить действующие лица
человек говорит по-другому, при изменении переменной/энума (капсом, если больно)

*/
