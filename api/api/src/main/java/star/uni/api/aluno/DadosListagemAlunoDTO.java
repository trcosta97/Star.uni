package star.uni.api.aluno;

public record DadosListagemAlunoDTO(String nome, String email, Sala sala) {

    public DadosListagemAlunoDTO(Aluno aluno){
        this(aluno.getNome(), aluno.getEmail(), aluno.getSala());
    }

}
