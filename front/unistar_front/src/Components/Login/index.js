
import { useState } from "react"
import BotaoLogin from "../BotaoLogin"
import CampoTexto from "../CampoTexto"
import "./Login.css"
import axios from "axios"
import { useNavigate } from 'react-router-dom'



const Login = () => {

    const [login, setLogin] = useState('')
    const [senha, setSenha] = useState('')
    const navigate = useNavigate()
   

    const aoSubmeterFormulario = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/login', { login, senha });
            sessionStorage.setItem('token', response.data.token)
            navigate('/home');
        } catch (error) {
            console.error(error)
            alert('Falha no login')
            setLogin('')
            setSenha('')
            
            
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