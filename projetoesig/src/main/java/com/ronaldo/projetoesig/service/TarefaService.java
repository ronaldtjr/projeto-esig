package com.ronaldo.projetoesig.service;

import com.ronaldo.projetoesig.common.util.Util;
import com.ronaldo.projetoesig.common.util.exception.ValidationException;
import com.ronaldo.projetoesig.dto.FiltroDTO;
import com.ronaldo.projetoesig.enums.Situacao;
import com.ronaldo.projetoesig.model.Tarefa;
import com.ronaldo.projetoesig.repository.ResponsavelRepository;
import com.ronaldo.projetoesig.repository.TarefaRepository;
import com.ronaldo.projetoesig.repository.TarefaRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaRepositoryImpl tarefaRepositoryImpl;
    private final ResponsavelRepository responsavelRepository;

    public TarefaService(TarefaRepository tarefaRepository, TarefaRepositoryImpl tarefaRepositoryImpl, ResponsavelRepository responsavelRepository) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaRepositoryImpl = tarefaRepositoryImpl;
        this.responsavelRepository = responsavelRepository;
    }

    public Long criar(Tarefa tarefaDTO) {

        var tarefa = tarefaDTO;

        var responsavelOpt = responsavelRepository.findById(tarefaDTO.getResponsavel().getId());

        if (responsavelOpt.isEmpty()) {
            throw new ValidationException("Você deve inserir um responsável válido para a tarefa.");
        }

        tarefa.setResponsavel(responsavelOpt.get());

        validarTarefa(tarefa);

        tarefa.setSituacao(Situacao.EM_ANDAMENTO);
        return tarefaRepository.save(tarefa).getId();
    }

    public Long editar(Tarefa tarefa) {

        validarTarefa(tarefa);

        return tarefaRepository.save(tarefa).getId();
    }

    public List<Tarefa> filtrar(FiltroDTO filtro){
        return this.tarefaRepositoryImpl.filtrar(filtro);
    }

    public List<Tarefa> listarTarefa() {
        return tarefaRepository.findAll();
    }

    public void excluir(Long tarefaId) {

        var tarefa =  tarefaRepository.findById(tarefaId);

        if(tarefa.isEmpty()){
            throw new ValidationException("Tarefa não encontrada");
        }

        tarefaRepository.delete(tarefa.get());
    }

    public Tarefa buscarPorId(Long tarefaId) {

        var tarefa =  tarefaRepository.findById(tarefaId);

        if(tarefa.isEmpty()){
            throw new ValidationException("Tarefa não encontrada");
        }

        return tarefa.get();

    }

    public void concluir(Long tarefaId) {

        var tarefaOptional = tarefaRepository.findById(tarefaId);

        if (tarefaOptional.isEmpty()) {
            throw new ValidationException("Tarefa não encontrada");
        }

        var tarefa = tarefaOptional.get();
        tarefa.setSituacao(Situacao.CONCLUIDO);
        tarefaRepository.save(tarefa);

    }


    private void validarTarefa(Tarefa tarefa)  {

        if (Util.isEmpty(tarefa.getTitulo())) {
            throw new ValidationException("Você deve inserir um título para a tarefa.");
        }

        if (tarefa.getTitulo().length() < 3) {
            throw new ValidationException("Você deve inserir um título com mais de 3 caracteres.");
        }

        if (Util.isEmpty(tarefa.getDescricao())) {
            throw new ValidationException("Você deve inserir uma descrição para a tarefa.");
        }

        if (tarefa.getDescricao().length() < 3) {
            throw new ValidationException("Você deve inserir uma descrição com mais de 3 caracteres.");
        }

        if (tarefa.getResponsavel() == null) {
            throw new ValidationException("Você deve inserir um responsável para a tarefa.");
        }

    }

}
