package star.uni.api.aluno;

import star.uni.api.endereco.Endereco;

public record DadosCadastroAlunoDTO(String nome, String email, String cpf, Sala sala, Endereco endereco) {
}
