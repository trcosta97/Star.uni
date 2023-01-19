package star.uni.api.aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import star.uni.api.endereco.Endereco;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Sala sala;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Aluno(DadosCadastroAlunoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.sala = dados.sala();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoAlunoDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.sala() != null){
            this.sala = dados.sala();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
