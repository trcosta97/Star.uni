package star.uni.api.aluno;

import jakarta.validation.constraints.NotNull;
import star.uni.api.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoAlunoDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        Sala sala,
        DadosEnderecoDTO endereco) {
}
