import java.util.*;

// Classe Estudante
class Estudante {
    private String nome;
    private String sobrenome;
    private int idade;
    private double media;

    public Estudante(String nome, String sobrenome, int idade, double media) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " (Idade: " + idade + ", Média: " + media + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        // Criar uma lista de estudantes
        List<Estudante> listaEstudantes = new ArrayList<>();
        listaEstudantes.add(new Estudante("João", "Silva", 20, 8.5));
        listaEstudantes.add(new Estudante("Maria", "Santos", 22, 7.0));
        listaEstudantes.add(new Estudante("Pedro", "Ferreira", 19, 9.2));

        // Ordenar a lista por Nome
        Collections.sort(listaEstudantes, Comparator.comparing(Estudante::getNome));
        System.out.println("Ordenado por Nome:");
        for (Estudante estudante : listaEstudantes) {
            System.out.println(estudante);
        }

        // Ordenar a lista por Sobrenome
        Collections.sort(listaEstudantes, Comparator.comparing(Estudante::getSobrenome));
        System.out.println("\nOrdenado por Sobrenome:");
        for (Estudante estudante : listaEstudantes) {
            System.out.println(estudante);
        }

        // Outros critérios de ordenação (Idade, Média, etc.) podem ser aplicados da mesma forma
    }
}
