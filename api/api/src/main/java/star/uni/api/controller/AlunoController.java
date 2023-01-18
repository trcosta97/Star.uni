package star.uni.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.uni.api.aluno.Aluno;
import star.uni.api.aluno.AlunoRepository;
import star.uni.api.aluno.DadosCadastroAlunoDTO;

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

}
