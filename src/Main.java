import basic_solution.WeatherData;
import observer.Forecast;
import observer.MobileForecast;
import observer.Сurrent;

public class Main {

    //Ответ на вопрос по ислючениям

//    static Object object;                                    // Объявление(декларация)
//
//    public static void main(String[] args) {
//
//        //Если нет инициализации, то возникнет исключение(Exception) - непредвиденная ситуация
//        //  object = new Object();                             // Инициализация(присвоение) переменной - теперь у ссылки есть значение в куче
//        try {   // Проверить код(try - попробовать) в скобках указывается код, который может отработать некорректно
//            System.out.println(object.toString());
//        }
//        catch (Exception ex){       // catch - поймать. Блок кода, вызывается в случае, если возникла непредвиденная ситуация в блоке try
//            System.out.println("Что-то пошло не так");
//            ex.printStackTrace();
//        }
//
//        System.out.println("Программа продолжает работать");
//    }

    // Часть урока по паттерну Наблюдатель

    /*
    Теория
    Наблюдатель позволяет подключать к определенной расслылке информации слушателей. Пример паттерна Наблюдатель -
    рассылка газет. Можно как подписаться на получение газеты так и отписаться на нее. Стоит обратить внимание, что
    остальной функционал как продавца газет так и покупателя ни как не зависит от состояния подписки или отписки от
    газеты - реализована так называемая слабая связь.

    Важно правило:
    Изменяемые параметры дучше программировать не на уровне класса, а на уровне интерфейса(создавать контракт)

    Задачу прочитать в книге на странице 72. Вторая глава паттерн "Наблюдатель"

    Первый способ решения выявил отстуствие гибкость подлючения новых клиентов к нашей рассылке - попробуйте добавить пару
    классов в пакет basic_solution и получать в них данные из класcа WeatherData. Насколько тот подход удобен? А что если нужно
    еще и отписывать несколько классов каждый пару дней динамически. Представьте, что в программе не 20 строк кода, а 20 тыс
    строк.


     */

    public static void main(String[] args) {
        // Первый способ решения(пакет basic_solution)
        System.out.println("Работает простое решение: ");
        WeatherData weatherData = new WeatherData();
        weatherData.change(20, 40, 130);
        weatherData.change(21, 38, 127);

        // Второй способ решения(Observer)
        System.out.println("Работает Observer: ");
        observer.WeatherData subject = new observer.WeatherData(); // Такой синтаксис потому что в программе присутсвует два класса с одинаковым именем, чтобы их различать указывается пакет классов
        observer.Сurrent cur = new Сurrent();
        subject.registerObserver(cur);
        subject.setChanges(10, 45, 140);
        observer.Forecast cast = new Forecast();
        subject.registerObserver(cast);
        subject.setChanges(12, 43, 150);
        observer.MobileForecast mob = new MobileForecast();
        subject.registerObserver(mob);
        subject.setChanges(14, 38, 137);
        subject.removeObserver(cur);
        subject.setChanges(15, 28, 139);
    }
}

/*
ДЗ
Повторить паттерн "Наблюдатель". Прочитать вторую главу книги "Паттерны проектирования" - 71 страница
 */
