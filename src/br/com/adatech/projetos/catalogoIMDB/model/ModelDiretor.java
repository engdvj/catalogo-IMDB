package br.com.adatech.projetos.catalogoIMDB.model;


import br.com.adatech.projetos.catalogoIMDB.util.Util;

import java.util.HashMap;

/**
 * Classe que representa um Diretor de filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelDiretor extends ModelPessoa {

    private int quantidadeDeFilmesDirigidos;
    private final HashMap<ModelFilme, Enum<?>> area = new HashMap<>();


    public ModelDiretor(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public int getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }

    @Override
    public void novaParticipacao(Enum<?> areaDiretor, ModelFilme filme) {
        quantidadeDeFilmesDirigidos++;
        super.participacoes.add(filme);
        area.put(filme,areaDiretor);
    }
    public Util.AreaDiretor getAreaDiretor(String tituloFilme) {
        for (HashMap.Entry<ModelFilme, Enum<?>> entrada : this.area.entrySet()) {
            if (entrada.getKey().getTitulo().equals(tituloFilme)) {
                return (Util.AreaDiretor) entrada.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  "\n   Nome:'" + nome;
    }
}
