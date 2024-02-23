package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;
import java.util.HashMap;


/**
 * Classe que representa um Ator de filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelAtor extends ModelPessoa {
    private int quantidadeDePapel;
    private final HashMap<ModelFilme, Enum<?>> area = new HashMap<>();

    public ModelAtor(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public int getQuantidadeDePapel() {
        return quantidadeDePapel;
    }
    @Override
    public void novaParticipacao(Enum<?> papelAtor, ModelFilme filme) {
        quantidadeDePapel++;
        super.participacoes.add(filme);
        area.put(filme,papelAtor);
    }
    public void removeParticipacao(Enum<?> papelAtor, ModelFilme filme) {
        quantidadeDePapel--;
        super.participacoes.remove(filme);
        area.remove(filme,papelAtor);
    }
    public PapelAtor getPapelAtor(String tituloFilme) {
        for (HashMap.Entry<ModelFilme, Enum<?>> entrada : this.area.entrySet()) {
            if (entrada.getKey().getTitulo().equals(tituloFilme)) {
                return (PapelAtor) entrada.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
