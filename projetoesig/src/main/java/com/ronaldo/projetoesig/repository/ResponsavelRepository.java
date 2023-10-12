package com.ronaldo.projetoesig.repository;

import com.ronaldo.projetoesig.model.Responsavel;
import com.ronaldo.projetoesig.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}
