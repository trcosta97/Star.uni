package star.uni.api.domain.aluno;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import star.uni.api.domain.endereco.DadosEnderecoDTO;

public record DadosCadastroAlunoDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,11}")
        String cpf,
        @NotNull
        Sala sala,
        @NotNull @Valid
        DadosEnderecoDTO endereco)
{

}

