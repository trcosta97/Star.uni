package star.uni.api.professor;

public record DadosListagemProfessorDTO(Long id, String nome, String email, Disciplina disciplina) {

    public DadosListagemProfessorDTO(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }

}
