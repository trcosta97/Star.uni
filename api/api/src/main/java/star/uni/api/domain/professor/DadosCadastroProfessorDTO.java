package star.uni.api.domain.professor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import star.uni.api.domain.endereco.DadosEnderecoDTO;

public record DadosCadastroProfessorDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,11}")
        String cpf,
        @NotNull
        Disciplina disciplina,
        @NotNull @Valid
        DadosEnderecoDTO endereco) {
}
