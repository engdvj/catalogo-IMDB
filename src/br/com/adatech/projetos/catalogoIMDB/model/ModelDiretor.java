package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.LocalDate;

/**
 * Classe que representa um Diretor de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelDiretor extends ModelPessoa {

    private int quantidadeDeFilmesDirigidos;
    private String area;

    public ModelDiretor(String dados []) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        this.area = "não definida";
    }

    public int getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }

    public void setQuantidadeDeFilmesDirigidos(int quantidadeDeFilmesDirigidos) {
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return  "\n   Nome:'" + nome + "'\'   Area:'" + area;
    }
}
