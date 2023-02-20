
import Banner from "../Banner"
import BotaoLink from "../BotaoLink"
import "./Home.css"

const Home = (props) => {

    return (
        <div className="home">
            <Banner />
            <div className="botoes">
                <BotaoLink className="botaoHome" endereco="/cadastroProfessor" >
                    Cadastro de Professores
                </BotaoLink>
                <BotaoLink className="botaoHome" endereco="/cadastroAluno" >
                    Cadastro de Alunos
                </BotaoLink>
                <BotaoLink className="botaoHome" endereco="/alunos" >
                    Alunos Cadastrados
                </BotaoLink>
            </div>


        </div>
    )
}

export default Home