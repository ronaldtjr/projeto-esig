package com.ronaldo.projetoesig.repository;

import com.ronaldo.projetoesig.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TarefaRepository2")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}





