package br.com.lfmelo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    Calculadora calculadora;

    @BeforeEach
    public void criarCalc() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros() {
        int numero1 = 10, numero2 = 5;

        //execucao
        int resultado = calculadora.somar(numero1, numero2);

        //verificacao
        Assertions.assertThat(resultado).isEqualTo(15);
    }


    @Test
    public void naoDeveSomarNumerosNegativos(){
        //cenario
        int numero1 = -10, numero2 = 5;

        //execucao
        org.junit.jupiter.api.Assertions
                .assertThrows( RuntimeException.class, () -> calculadora.somar(numero1, numero2));
    }

    @Test
    public void deveSubtrairDoisNumeros() {
        //cenario
        int num1 = 10, num2 = 5;

        //execucao
        int resultado = calculadora.subtrair(num1, num2);

        //validacao
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void deveDividirDoisNumeros() {
        int num1 = 10, num2 = 2;

        int resultado = calculadora.dividir(num1, num2);

        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void naoDeveDividirNumeroPorZero() {
        int num1 = 10, num2 = 0;

        org.junit.jupiter.api.Assertions
                .assertThrows( RuntimeException.class, () -> calculadora.dividir(num1, num2));
    }

    @Test
    public void deveMultiplicarDoisNumeros() {
        int num1 = 10, num2 = 2;

        int resultado = calculadora.multiplicar(num1, num2);

        Assertions.assertThat(resultado).isEqualTo(20);
    }


}

class Calculadora {
    int somar(int num1, int num2) {
        if(num1 < 0 || num2 < 0) {
            throw new RuntimeException("Nao e permitido somar numeros negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2) {
        return num1 - num2;
    }

    int dividir(int num1, int num2) {
        if(num2 == 0) {
            throw new RuntimeException("Nao e possivel dividir numero por 0");
        }
        return num1 / num2;
    }

    int multiplicar(int num1, int num2) {
        return num1 * num2;
    }
}
