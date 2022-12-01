package br.com.lfmelo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class) //para usar as notações do Mock
public class MockitoTestes {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {
        Mockito.when( lista.size() ).thenReturn(20);

        int tamanhoLista = lista.size();

        Assertions.assertThat(tamanhoLista).isEqualTo(20);

        Mockito.verify(lista).size(); //valida se realmente chamou o método que precisa ser validada.

        //Mockito.verify(lista, Mockito.times(1)).size(); //verifica quantas vezes chamou o método.
    }
}
