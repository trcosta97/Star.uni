package star.uni.api.professor;

import jakarta.validation.constraints.NotNull;
import star.uni.api.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoProfessorDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        Disciplina disciplina,
        DadosEnderecoDTO endereco) {
}
