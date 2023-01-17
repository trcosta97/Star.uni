package star.uni.api.professor;

import star.uni.api.endereco.Endereco;

public record DadosCadastroProfessorDTO(String nome, String email, String cpf, Diciplina diciplina, Endereco endereco) {
}
