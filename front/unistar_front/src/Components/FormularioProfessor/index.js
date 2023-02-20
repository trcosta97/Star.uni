
import { useState } from "react"
import Botao from "../Botao"
import CampoTexto from "../CampoTexto"
import Dropdown from "../Dropdown"
import "./FormularioProfessor.css"

const FormularioProfessor = () => {

    const disciplinas = [
        'PORTUGUÊS',
        'MATEMÁTICA',
        'FÍSICA',
        'QUÍMICA',
        'BIOLOGIA',
        'HISTÓRIA',
        'INGLÊS',
        'GEOGRAFIA',
        'FILOSOFIA',
        'EDUCAÇÃO FÍSICA'

    ]
    const estados = [
        'AC',
        'AL',
        'AP',
        'AM',
        'BA',
        'CE',
        'DF',
        'ES',
        'GO',
        'MA',
        'MT',
        'MS',
        'MG',
        'PA',
        'PB',
        'PR',
        'PE',
        'PI',
        'RJ',
        'RN',
        'RS',
        'RO',
        'RR',
        'SC',
        'SP',
        'SE',
        'TO'
    ]

    const aoSalvar = (evento) => {
        evento.preventDefault()
        alert('formulário submetido')
    }

    const token = sessionStorage.getItem('token')
 
    const [nome, setNome] = useState('')
    const [cpf, setCpf] = useState('')
    const [disciplina, setDisciplina] = useState('')
    const [cep, setCep] = useState('')
    const [logradouro, setLogradouro] = useState('')
    const [numero, setNumero] = useState('')
    const [bairro, setBairro] = useState('')
    const [complemento, setComplemento] = useState('')
    const [cidade, setCidade] = useState('')
    const [uf, setUf] = useState('')

    return (
        <section className="formulario">
            <form onSubmit={aoSalvar}>
                <h2>Preencha os dados para cadastrar o professor</h2>
                <CampoTexto value ={nome} obrigatorio = {true} label="Nome*" onChange={setNome} placeholder="Digite o nome" />
                <CampoTexto value ={cpf} obrigatorio = {true} label="CPF*" nChange={setCpf} placeholder="Digite o CPF" />
                <Dropdown value ={disciplina} obrigatorio = {true} label="Disciplina*" nChange={setDisciplina} itens={disciplinas} />
                <CampoTexto value ={cep} obrigatorio = {true} label="CEP*" nChange={setCep} placeholder="Digite o CEP" />
                <CampoTexto value ={logradouro} obrigatorio = {true} label="Logradouro*" nChange={setLogradouro} placeholder="Digite o logradouro" />
                <CampoTexto value ={numero} obrigatorio = {false} label="Numero" nChange={setNumero} placeholder="Digite o número" />
                <CampoTexto value ={bairro} obrigatorio = {true} label="Bairro*" nChange={setBairro} placeholder="Digite o bairro" />
                <CampoTexto value ={complemento} obrigatorio = {false} label="Complemento" nChange={setComplemento} placeholder="Digite o complemento" />
                <CampoTexto value ={cidade} obrigatorio = {true} label="Cidade*" nChange={setCidade} placeholder="Digite a cidade" />
                <Dropdown value ={uf} obrigatorio = {true} label="UF*" nChange={setUf} itens={estados} />
                <h5>* Campos obrigatórios</h5>
                <Botao>
                    Cadastrar
                </Botao>

            </form>
        </section> 
    )
}

export default FormularioProfessor