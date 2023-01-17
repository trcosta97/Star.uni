package star.uni.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.uni.api.professor.DadosCadastroProfessorDTO;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @PostMapping
    public void cadastrarProfessor(@RequestBody DadosCadastroProfessorDTO dados){
        System.out.println(dados);
    }


}
