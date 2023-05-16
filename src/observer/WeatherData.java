package observer;

import java.util.ArrayList;

public class WeatherData implements Subject{

    /*
    ArrayList - класс, который позволяет работать с массивом, т.к. в нем кроме самого массива уже есть основные методы
    для работы с ним
     */
    private ArrayList observers = new ArrayList();      // Поля класса
    private int temp;
    private float humidity;
    private float pressure;
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);         // Добавляю наблюдателя в массив
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temp, humidity, pressure);
        }
    }
                                 //Параметры метода
    public void setChanges(int temp, float humidity, float pressure){
        /*
        У нас параметры методы имеют такое же название и поля класса, чтобы присовить
        значеня параметров полям воспользуемся словом this.
        this - это ссылка на текущий экземпляр, т.е. команда this.temp вызовет объект класса
        и в нем возьмет поле, таким образом команда:
        this.temp = temp означает присвоить значение параметра temp полю объекта temp
         */
        this.temp = temp;                // Присваиваем новые значения
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();               // Рассылаем данные наблюдателям
    }

}
