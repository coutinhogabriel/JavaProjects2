

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class TestCalculadora {
    Calculadora calculadora = new Calculadora();

    //Criar testes
    @Test
    public void testSoma() {
        double resultado = calculadora.soma(2, 3);
        assertEquals(5, resultado, 0);
    }

    //Criar teste subtração
    @Test
    public void testSubtracao() {
        double resultado = calculadora.subtracao(5, 3);
        assertEquals(2, resultado, 0);
    }

    //Criar teste multiplicação
    @Test
    public void testMultiplicacao() {
        double resultado = calculadora.multiplicacao(2, 3);
        assertEquals(6, resultado, 0);
    }

    //Criar teste divisão
    @Test
    public void testDivisao() {
        double resultado = calculadora.divisao(6, 3);
        assertEquals(2, resultado, 0);
    }

    //Criar teste divisao por 0
    @Test
    public void testDivisaoPorZero() {
        assertThrows(IllegalArgumentException.class,()-> calculadora.divisao(10, 0));
    }
}
