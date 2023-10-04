public class CalculadoraRaizQuadrada {
    // Método para calcular a raiz quadrada usando o método de Newton
    public static double calcularRaizQuadrada(double numero, double tolerancia) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }

        double aproximacao = numero / 2; // Começa com uma aproximação inicial
        while (Math.abs(aproximacao * aproximacao - numero) > tolerancia) {
            aproximacao = 0.5 * (aproximacao + numero / aproximacao); // Fórmula de Newton
        }

        return aproximacao;
    }
}
