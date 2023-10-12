package com.ronaldo.projetoesig.repository;

import com.ronaldo.projetoesig.dto.FiltroDTO;
import com.ronaldo.projetoesig.model.Tarefa;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TarefaRepositoryImpl {

    @Autowired
    private EntityManager entityManager;

    public List<Tarefa> filtrar(FiltroDTO filtro) {

        StringBuilder jpql = new StringBuilder("SELECT t FROM Tarefa t WHERE 1=1 ");
        Map<String, Object> parameters = new HashMap<>();

        if (filtro.getId() != null) {
            jpql.append("AND t.id = :id ");
            parameters.put("id", filtro.getId());
        }

        if (filtro.getTitulo() != null && !filtro.getTitulo().trim().isEmpty()) {
            jpql.append("AND t.titulo LIKE :titulo ");
            parameters.put("titulo", "%" + filtro.getTitulo() + "%");
        }

        if (filtro.getResponsavel() != null)  {
            jpql.append("AND t.responsavel = :responsavel ");
            parameters.put("responsavel",   filtro.getResponsavel() );
        }

        if (filtro.getSituacao() != null && !filtro.getSituacao().toString().trim().isEmpty()) {
            jpql.append("AND t.situacao = :situacao ");
            parameters.put("situacao", filtro.getSituacao());
        }

        TypedQuery<Tarefa> query = entityManager.createQuery(jpql.toString(), Tarefa.class);

        for (Map.Entry<String, Object> param : parameters.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }

        return query.getResultList();
    }
}

