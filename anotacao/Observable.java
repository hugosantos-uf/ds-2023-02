import java.util.ArrayList;
import java.util.List;

public class Observable {
    private String identificador;
    private List<Object> observers;

    public Observable(String identificador) {
        this.identificador = identificador;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Object observer) {
        if (observer.getClass().isAnnotationPresent(Observer.class)) {
            Observer annotation = observer.getClass().getAnnotation(Observer.class);
            if (annotation.observado().equals(identificador)) {
                observers.add(observer);
            } else {
                throw new IllegalArgumentException("O identificador do observer não coincide com o identificador do objeto observado.");
            }
        } else {
            throw new IllegalArgumentException("A classe do observer não está marcada com a anotação @Observer.");
        }
    }
}
