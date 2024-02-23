package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;
import java.util.*;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelRoteirista extends ModelPessoa {

    public ModelRoteirista(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public void novaParticipacao(Enum<?> area,ModelFilme filme) {
        super.participacoes.add(filme);
        this.area.put(filme,area);
    }
    public void removeParticipacao(Enum<?> areaRoteirista, ModelFilme filme) {
        super.participacoes.remove(filme);
        area.remove(filme,areaRoteirista);
    }

    public AreaRoteirista getAreaRoteirista(String tituloFilme) {
        for (HashMap.Entry<ModelFilme, Enum<?>> entrada : this.area.entrySet()) {
            if (entrada.getKey().getTitulo().equals(tituloFilme)) {
                return (AreaRoteirista) entrada.getValue();
            }
        }
        return null;
    }

    @Override
    protected String getTitle() {
        return "INFORMAÇÕES DO ROTERISTA";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
