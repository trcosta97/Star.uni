import Banner from "../Banner"
import BotaoLogin from "../BotaoLogin"
import CampoTexto from "../CampoTexto"
import "./Login.css"

const Login = () => {
    return (
        <header className="login">
            <Banner/>
            <form>
                <CampoTexto obrigatorio={true} label="Login" placeholder="" />
                <CampoTexto obrigatorio={true} label="Senha" placeholder="" />
                <BotaoLogin className="botaoLogin">
                    Login
                </BotaoLogin>
            </form>
        </header>

    )
}

export default Login