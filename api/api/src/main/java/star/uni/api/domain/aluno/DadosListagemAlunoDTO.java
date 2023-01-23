package star.uni.api.domain.aluno;

public record DadosListagemAlunoDTO(Long id, String nome, String email, Sala sala) {

    public DadosListagemAlunoDTO(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getSala());
    }


}
