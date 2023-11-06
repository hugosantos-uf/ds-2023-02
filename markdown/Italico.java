public class Italico implements Markdown {
    private Markdown texto;

    public Italico(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print("_");
        texto.exibe();
        System.out.print("_");
    }
}
