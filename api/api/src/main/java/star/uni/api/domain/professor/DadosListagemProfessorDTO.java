package star.uni.api.domain.professor;

public record DadosListagemProfessorDTO(Long id, String nome, String email, Disciplina disciplina) {

    public DadosListagemProfessorDTO(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }

}
