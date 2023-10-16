import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    @Test
    public void testBuilder() {
        Endereco endereco = Endereco.builder()
                .rua("Rua A")
                .setor("Setor X")
                .cep("12345-678")
                .numero("123")
                .cidade("Cidade A")
                .estado("Estado A")
                .bloco("Bloco B")
                .quadra("Quadra C")
                .build();

        assertEquals("Rua A", endereco.getRua());
        assertEquals("Setor X", endereco.getSetor());
        assertEquals("12345-678", endereco.getCep());
        assertEquals("123", endereco.getNumero());
        assertEquals("Cidade A", endereco.getCidade());
        assertEquals("Estado A", endereco.getEstado());
        assertEquals("Bloco B", endereco.getBloco());
        assertEquals("Quadra C", endereco.getQuadra());
    }

    @Test
    public void testBuilderWithDefaults() {
        Endereco endereco = Endereco.builder()
                .rua("Rua A")
                .cep("12345-678")
                .build();

        assertEquals("Rua A", endereco.getRua());
        assertNull(endereco.getSetor());
        assertEquals("12345-678", endereco.getCep());
        assertNull(endereco.getNumero());
        assertNull(endereco.getCidade());
        assertNull(endereco.getEstado());
        assertNull(endereco.getBloco());
        assertNull(endereco.getQuadra());
    }
}

