package star.uni.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.uni.api.professor.DadosCadastroProfessorDTO;
import star.uni.api.professor.Professor;
import star.uni.api.professor.ProfessorRepository;

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


}
