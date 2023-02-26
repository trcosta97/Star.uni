package star.uni.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import star.uni.api.domain.aluno.*;

@RestController
@RequestMapping("alunos")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAluno(@RequestBody @Valid DadosCadastroAlunoDTO dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);

        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAlunoDTO(aluno));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAlunoDTO>> listarAlunos(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAlunoDTO::new);

        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarAluno(@RequestBody @Valid DadosAtualizacaoAlunoDTO dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAlunoDTO(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirAluno(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detalharAluno(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAlunoDTO(aluno));
    }


}
