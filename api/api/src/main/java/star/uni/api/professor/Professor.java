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

        public Professor(DadosCadastroProfessorDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.disciplina = dados.disciplina();
        this.endereco = new Endereco(dados.endereco());
    }
}
