public class Negrito implements Markdown {
    private Markdown texto;

    public Negrito(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print("**");
        texto.exibe();
        System.out.print("**");
    }
}
