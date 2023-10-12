package com.ronaldo.projetoesig.service;

import com.ronaldo.projetoesig.model.Responsavel;
import com.ronaldo.projetoesig.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {
    @Autowired
    private ResponsavelRepository responsavelRepository;
    public List<Responsavel> findAll(){
        return this.responsavelRepository.findAll();
    }
}
