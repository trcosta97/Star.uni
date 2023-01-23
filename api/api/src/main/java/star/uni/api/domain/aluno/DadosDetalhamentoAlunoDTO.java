package star.uni.api.domain.aluno;

import star.uni.api.domain.endereco.Endereco;

public record DadosDetalhamentoAlunoDTO(Long id, String nome, String email, String cpf, Sala sala, Endereco endereco) {

    public DadosDetalhamentoAlunoDTO(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getSala(), aluno.getEndereco());
    }
}
