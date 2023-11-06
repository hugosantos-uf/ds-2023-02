public class Exemplo {
    public static void main(String[] args) {
        Markdown titulo = new Titulo(new Texto("Título"));
        Markdown linha = new Texto("Uma simples linha, com ");
        Markdown negrito = new Negrito(new Texto("negrito"));
        Markdown italico = new Italico(new Texto("itálico"));
        Markdown item = new Item(new Italico(new Texto("Primeiro item da linha com ")));
        
        Markdown mensagem = new Concatena(new Concatena(new Concatena(new Concatena(titulo, linha), negrito), new Texto(" e ")), italico);
        mensagem.exibe();
        item.exibe();
    }
}
