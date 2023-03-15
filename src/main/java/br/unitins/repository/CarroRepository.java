package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Carro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CarroRepository implements PanacheRepository<Carro> {

    public List<Carro> findByNomeList(String modelo){
        if (modelo == null)
            return null;
        return find("UPPER(modelo) LIKE ?1 ", "%"+modelo.toUpperCase()+"%").list();
    }
}
