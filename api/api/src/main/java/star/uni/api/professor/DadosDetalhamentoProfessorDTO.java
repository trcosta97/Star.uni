package star.uni.api.professor;

import star.uni.api.endereco.Endereco;

public record DadosDetalhamentoProfessorDTO(Long id, String nome, String email, String cpf, Disciplina disciplina, Endereco endereco) {

    public DadosDetalhamentoProfessorDTO(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getDisciplina(), professor.getEndereco());
    }

}
