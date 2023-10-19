package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.Tarefas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends  CrudRepository<Tarefas, Long>{
    
}
