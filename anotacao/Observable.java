import java.util.ArrayList;
import java.util.List;

public class Observable {
    private String identificador;
    private List<Observer> observers = new ArrayList<>();

    public Observable(String identificador) {
        this.identificador = identificador;
    }

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void notificarObservers() {
        observers.forEach(observer -> {
            if (isObserverForIdentificador(observer, identificador)) {
                observer.update();
            }
        });
    }

    private boolean isObserverForIdentificador(Observer observer, String identificador) {
        return observer.getClass().isAnnotationPresent(Observer.class) &&
               observer.getClass().getAnnotation(Observer.class).observado().equals(identificador);
    }

    public static void main(String[] args) {
        Observable carroObservable = new Observable("carro");

        Observer observer1 = () -> System.out.println("Observador 1 notificado");
        Observer observer2 = () -> System.out.println("Observador 2 notificado");

        carroObservable.adicionarObserver(observer1);
        carroObservable.adicionarObserver(observer2);

        carroObservable.notificarObservers();
    }
}
