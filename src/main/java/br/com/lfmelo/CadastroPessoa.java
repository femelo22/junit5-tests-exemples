package br.com.lfmelo;

import br.com.lfmelo.exceptions.CadastroVazioException;
import br.com.lfmelo.exceptions.PessoaSemNomeException;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {

    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        if(pessoa.getNome() == null) {
            throw new PessoaSemNomeException();
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if(this.pessoas.isEmpty()) {
            throw new CadastroVazioException();
        }
        this.pessoas.remove(pessoa);
    }
}
