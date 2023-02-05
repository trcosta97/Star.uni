
import BotaoLogin from "../BotaoLogin"
import CampoTexto from "../CampoTexto"
import "./Login.css"

const Login = () => {
    return (
        <header className="bg">
            <div className="login">
            
            <form>
                <CampoTexto obrigatorio={true} label="Login" placeholder="" />
                <CampoTexto obrigatorio={true} label="Senha" placeholder="" />
                <BotaoLogin className="botaoLogin">
                    Login
                </BotaoLogin>
            </form>

           

        </div>

        </header>
        

    )
}

export default Login