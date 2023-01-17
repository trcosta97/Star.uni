package star.uni.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.uni.api.aluno.DadosCadastroAlunoDTO;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @PostMapping
    public void cadastrarAluno(@RequestBody DadosCadastroAlunoDTO dados){
        System.out.println(dados);
    }

}
