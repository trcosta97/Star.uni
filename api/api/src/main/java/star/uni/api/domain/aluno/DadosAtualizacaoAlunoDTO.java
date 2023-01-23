package star.uni.api.domain.aluno;

import jakarta.validation.constraints.NotNull;
import star.uni.api.domain.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoAlunoDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        Sala sala,
        DadosEnderecoDTO endereco) {
}
