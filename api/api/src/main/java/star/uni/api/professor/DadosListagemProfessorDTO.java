package star.uni.api.professor;

public record DadosListagemProfessorDTO(String nome, String email, Disciplina disciplina) {

    public DadosListagemProfessorDTO(Professor professor){
        this(professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }

}
