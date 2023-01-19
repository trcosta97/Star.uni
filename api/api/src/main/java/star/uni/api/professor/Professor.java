package star.uni.api.professor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import star.uni.api.endereco.Endereco;

@Table(name = "professores")
@Entity(name= "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

        public Professor(DadosCadastroProfessorDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.disciplina = dados.disciplina();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoProfessorDTO dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.disciplina() != null){
            this.disciplina = dados.disciplina();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
