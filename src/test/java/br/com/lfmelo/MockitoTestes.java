package br.com.lfmelo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class) //para usar as notações do Mock
public class MockitoTestes {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {
        Mockito.when( lista.size() ).thenReturn(20);

        int tamanhoLista = lista.size();

        Assertions.assertThat(tamanhoLista).isEqualTo(20);

    }
}
