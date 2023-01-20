package star.uni.api.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import star.uni.api.professor.*;

import java.util.List;

@RestController
@RequestMapping("professores")
public class  ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProfessor(@RequestBody @Valid DadosCadastroProfessorDTO dados, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dados);
        repository.save(professor);

        var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessorDTO(professor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProfessorDTO>> listarProfessores(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
        var page =  repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessorDTO::new);
        return ResponseEntity.ok(page);


    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarProfessor(@RequestBody @Valid DadosAtualizacaoProfessorDTO dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessorDTO(professor));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirProfessor(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();

        return ResponseEntity.noContent().build();
    }



}
