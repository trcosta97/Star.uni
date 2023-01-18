package star.uni.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import star.uni.api.aluno.Aluno;
import star.uni.api.aluno.AlunoRepository;
import star.uni.api.aluno.DadosCadastroAlunoDTO;
import star.uni.api.aluno.DadosListagemAlunoDTO;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody DadosCadastroAlunoDTO dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAlunoDTO> listarAlunos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAlunoDTO::new);
    }
}
