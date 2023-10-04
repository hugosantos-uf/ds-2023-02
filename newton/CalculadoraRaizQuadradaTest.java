import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraRaizQuadradaTest {

    @Test
    public void testRaizQuadrada() {
        double resultado = CalculadoraRaizQuadrada.calcularRaizQuadrada(4, 0.001);
        assertEquals(2.0, resultado, 0.001); // Esperado: 2.0

        resultado = CalculadoraRaizQuadrada.calcularRaizQuadrada(25, 0.001);
        assertEquals(5.0, resultado, 0.001); // Esperado: 5.0

        resultado = CalculadoraRaizQuadrada.calcularRaizQuadrada(9, 0.001);
        assertEquals(3.0, resultado, 0.001); // Esperado: 3.0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRaizQuadradaDeNumeroNegativo() {
        CalculadoraRaizQuadrada.calcularRaizQuadrada(-1, 0.001);
    }
}
