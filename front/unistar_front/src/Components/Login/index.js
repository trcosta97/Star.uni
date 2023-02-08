
import { useState } from "react"
import BotaoLogin from "../BotaoLogin"
import CampoTexto from "../CampoTexto"
import "./Login.css"

const Login = () => {
    
    const [login, setLogin] = useState('')
    const [senha, setSenha] = useState('')
 
    
    
    return (
        <header className="bg">
            <div className="login">
            
            <form>
                <CampoTexto value={login} obrigatorio={true} label="Login" onChange={setLogin} placeholder="" />
                <CampoTexto value={login} obrigatorio={true} label="Senha" onChange={setSenha} placeholder="" />
                <BotaoLogin className="botaoLogin">
                    Login
                </BotaoLogin>
            </form>

           

        </div>

        </header>
        

    )
}

export default Login