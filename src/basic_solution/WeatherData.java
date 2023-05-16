package basic_solution;

public class WeatherData {
    Statistics statistics;  // Декларируем экземпляры классов
    Forecast forecast;
    Current current;

    public void change(int temp, float humidity, float pressure){
        current = new Current();                  // Инициализируем переменные классов, которые объявили выше. Теперь можно с ними корректно работать
        forecast = new Forecast();
        statistics = new Statistics();

        current.update(temp, humidity, pressure);          //  Обновляем данные
        forecast.update(temp, humidity, pressure);
        statistics.update(temp, humidity, pressure);
    }
}
