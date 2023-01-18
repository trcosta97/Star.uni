package star.uni.api.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import star.uni.api.professor.DadosCadastroProfessorDTO;
import star.uni.api.professor.DadosListagemProfessorDTO;
import star.uni.api.professor.Professor;
import star.uni.api.professor.ProfessorRepository;

import java.util.List;

@RestController
@RequestMapping("professores")
public class  ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarProfessor(@RequestBody DadosCadastroProfessorDTO dados){
        repository.save(new Professor(dados));
    }

    @GetMapping
    public Page<DadosListagemProfessorDTO> listarProfessores(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProfessorDTO::new);
    }


}
