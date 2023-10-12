package com.ronaldo.projetoesig.controller;

import com.ronaldo.projetoesig.model.Responsavel;
import com.ronaldo.projetoesig.service.ResponsavelService;
import com.ronaldo.projetoesig.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> findAll() {
        return ResponseEntity.ok(this.responsavelService.findAll());
    }


}
