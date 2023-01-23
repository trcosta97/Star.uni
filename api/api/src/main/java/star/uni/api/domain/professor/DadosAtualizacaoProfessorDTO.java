package star.uni.api.domain.professor;

import jakarta.validation.constraints.NotNull;
import star.uni.api.domain.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoProfessorDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        Disciplina disciplina,
        DadosEnderecoDTO endereco) {
}
