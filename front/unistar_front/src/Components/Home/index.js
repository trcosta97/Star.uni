
import Banner from "../Banner"
import BotaoLink from "../BotaoLink"
import "./Home.css"

const Home = (props) => {
    
   

    
    
    return(
        <div className="home">
            <Banner/>
            <BotaoLink className="botaoHome" endereco="/cadastroProfessor" >
                Cadastro de Professores
            </BotaoLink>
            <BotaoLink className="botaoHome" endereco="/cadastroAluno" >
                Cadastro de Alunos
            </BotaoLink>
            
        </div>
    )
}

export default Home