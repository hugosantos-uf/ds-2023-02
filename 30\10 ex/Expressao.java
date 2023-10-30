public interface Expressao {
    float valor();
}

// Classe Constante
public class Constante implements Expressao {
    private float valor;

    public Constante(float valor) {
        this.valor = valor;
    }

    @Override
    public float valor() {
        return valor;
    }
}
