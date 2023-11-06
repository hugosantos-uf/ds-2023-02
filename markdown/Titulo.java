public class Titulo implements Markdown {
    private Markdown texto;

    public Titulo(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print("# ");
        texto.exibe();
        System.out.println();
    }
}
