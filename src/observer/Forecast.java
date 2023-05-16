package observer;

public class Forecast implements Observer{
    @Override
    public void update(int temp, float humidity, float pressure) {
        System.out.println("Данные изменены с учетом полученной информации для класса Forecast");
    }
}
