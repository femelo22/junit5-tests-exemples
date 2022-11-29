package br.com.lfmelo;

import br.com.lfmelo.exceptions.CadastroVazioException;
import br.com.lfmelo.exceptions.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTeste {

    @Test
    public void deveCriarOCadastroDePessoas() {
        CadastroPessoa cadastro = new CadastroPessoa();

        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        //cenário
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fernando");

        //execucao
        cadastroPessoas.adicionar(pessoa);

        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);

    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaSemNome() {
        //cenario
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        //execucao
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {
        //cenario
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fernando");
        cadastroPessoas.adicionar(pessoa);

        //execucao
        cadastroPessoas.remover(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        //cenario
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        //execucao
        cadastroPessoas.remover(pessoa);
    }
}
