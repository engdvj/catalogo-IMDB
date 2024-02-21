package br.com.adatech.projetos.catalogoIMDB.model;


/**
 * Classe que representa um Diretor de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelDiretor extends ModelPessoa {

    private int quantidadeDeFilmesDirigidos;

    public ModelDiretor(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public int getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }

    public void novoFilme(ModelFilme filme) {
        quantidadeDeFilmesDirigidos++;
        super.participacoes.add(filme);

    }

    @Override
    public String toString() {
        return  "\n   Nome:'" + nome;
    }
}
