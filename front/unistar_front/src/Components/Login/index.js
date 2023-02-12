
import { useState } from "react"
import BotaoLogin from "../BotaoLogin"
import CampoTexto from "../CampoTexto"
import "./Login.css"
import axios from "axios"

const Login = () => {

    const [login, setLogin] = useState('')
    const [senha, setSenha] = useState('')

    const aoSubmeterFormulario = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/login', { login, senha });
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    };


    return (
        <section className="bg">
            <div className="login">

                <form onSubmit={aoSubmeterFormulario}>
                    <CampoTexto value={login} obrigatorio={true} label="Login" onChange={(event)=>setLogin(event.target.value)}  />
                    <CampoTexto value={senha} obrigatorio={true} label="Senha" onChange={(event) => setSenha(event.target.value)}  />
                    <BotaoLogin className="botaoLogin">
                        Login
                    </BotaoLogin>
                </form>



            </div>

        </section>


    )
}

export default Login