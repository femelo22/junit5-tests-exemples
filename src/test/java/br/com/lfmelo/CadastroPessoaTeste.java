package br.com.lfmelo;

import br.com.lfmelo.exceptions.CadastroVazioException;
import br.com.lfmelo.exceptions.PessoaSemNomeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaTeste {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarOCadastroDePessoas() {
        CadastroPessoa cadastro = new CadastroPessoa();

        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
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

    @Test
    @DisplayName("Nao deve adicionar uma pessoa sem nome")
    public void naoDeveAdicionarPessoaSemNome() {
        //cenario
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        //execucao
        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa")
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

    @Test
    @DisplayName("Não deve remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        //cenario
        CadastroPessoa cadastroPessoas = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        //execucao
        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa));
    }
}
