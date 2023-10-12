package com.ronaldo.projetoesig.controller;

import com.ronaldo.projetoesig.dto.FiltroDTO;
import com.ronaldo.projetoesig.model.Tarefa;
import com.ronaldo.projetoesig.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Long> criarTarefa(@RequestBody Tarefa dto) {
       return ResponseEntity.ok(tarefaService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefa(){
        return ResponseEntity.ok(tarefaService.listarTarefa());
    }

    @PostMapping("/filtrar")
    public ResponseEntity<List<Tarefa>> filtrar(@RequestBody FiltroDTO filtro) {
        return ResponseEntity.ok(tarefaService.filtrar(filtro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirTarefa(@PathVariable("id") Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.ok("Tarefa excluída com sucesso!");
    }

    @PutMapping("/concluir/{id}")
    public ResponseEntity<String> concluir(@PathVariable("id") Long id) {
        tarefaService.concluir(id);
        return ResponseEntity.ok("Tarefa concluída com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> editarTarefa(@RequestBody Tarefa tarefa){
        return ResponseEntity.ok(tarefaService.editar(tarefa));
    }

}
