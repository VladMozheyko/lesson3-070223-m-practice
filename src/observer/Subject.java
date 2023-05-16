package observer;

public interface Subject {    // В данном паттерне, тот кто отправляет уведомления называется субъект
    void registerObserver(Observer observer);  // Закладываем в контракт функционал для сервера
    void removeObserver(Observer observer);
    void notifyObservers();
}
