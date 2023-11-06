public class Item implements Markdown {
    private Markdown texto;

    public Item(Markdown texto) {
        this.texto = texto;
    }

    @Override
    public void exibe() {
        System.out.print("- ");
        texto.exibe();
        System.out.println();
    }
}
