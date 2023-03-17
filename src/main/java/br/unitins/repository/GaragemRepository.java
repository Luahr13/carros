package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Garagem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GaragemRepository implements PanacheRepository<Garagem>{
    
    public List<Garagem> findByNomeList(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
