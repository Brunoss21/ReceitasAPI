package com.fatecrl.receitas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.receitas.model.Receita;

@Service
public class ReceitaService {
    private static List<Receita> receitas = new ArrayList<Receita>();

    public ReceitaService(){
        receitaFake();
    }

    private void receitaFake(){
        Receita receita = new Receita();
        receita.setNome("Bolo de Chocolate");
        receita.setId(0);
        receita.setIngredientes("Leite, Ovos, Chocolate em pó e açucar");
        receitas.add(receita);
    }

    public List<Receita> findAll(){
        return receitas;
    }

    public Receita find(Receita receita){
        return receitas.stream()
                        .filter(r -> r.equals(receita))
                        .findFirst().orElse(null);
    }

    public Receita find(long id){
        return find(new Receita());
    }

    public void create(Receita receita){
        Long newId = (long) (receitas.size() + 1);
        receita.setId(newId);
        receitas.add(receita);
    }

    public boolean delete(long id){
        Receita _receita = find(id);
        if(_receita != null){
            receitas.remove(_receita);
            return true;
        }
        return false;
    }

    public boolean update(Receita receita){
        Receita _receita = find(receita);
        if(_receita != null){
            if(receita.getNome() != null && !receita.getNome().isBlank()){
                _receita.setNome(receita.getNome());
            }

            if(receita.getIngredientes() != null && !receita.getIngredientes().isEmpty()){
                _receita.setIngredientes(receita.getIngredientes());
            }

            return true;

        }
        return false;
    }

}
