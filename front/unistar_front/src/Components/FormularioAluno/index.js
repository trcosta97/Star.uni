
import { useState } from "react"
import Botao from "../Botao"
import CampoTexto from "../CampoTexto"
import Dropdown from "../Dropdown"
import "./FormularioAluno.css"

const FormularioAluno = () => {

    const salas = [
        'EM1 - a',
        'EM1 - b',
        'EM2 - a',
        'EM2 - a',
        'EM2 - b',
        'EM3 - a',
        'EM3 - b'
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

    const [nome, setNome] = useState('')
    const [cpf, setCpf] = useState('')
    const [sala, setSala] = useState('')
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
                <h2>Preencha os dados para cadastrar o aluno</h2>
                <CampoTexto value ={nome} obrigatorio = {true} label="Nome*" onChange={setNome} placeholder="Digite o nome" />
                <CampoTexto value ={cpf} obrigatorio = {true} label="CPF*" onChange={setCpf} placeholder="Digite o CPF" />
                <Dropdown value ={sala} obrigatorio = {true} label="Sala*" onChange={setSala} itens={salas} />
                <CampoTexto value ={cep} obrigatorio = {true} label="CEP*" onChange={setCep} placeholder="Digite o CEP" />
                <CampoTexto value ={logradouro} obrigatorio = {true} label="Logradouro*" onChange={setLogradouro} placeholder="Digite o logradouro" />
                <CampoTexto value ={numero} obrigatorio = {false} label="Numero" onChange={setNumero} placeholder="Digite o número" />
                <CampoTexto value ={bairro} obrigatorio = {true} label="Bairro*" onChange={setBairro} placeholder="Digite o bairro" />
                <CampoTexto value ={complemento} obrigatorio = {false} label="Complemento" onChange={setComplemento} placeholder="Digite o complemento" />
                <CampoTexto value ={cidade} obrigatorio = {true} label="Cidade*" onChange={setCidade} placeholder="Digite a cidade" />
                <Dropdown value ={uf} obrigatorio = {true} label="UF*" onChange={setUf} itens={estados} />
                <h5>* Campos obrigatórios</h5>
                <Botao>
                    Cadastrar
                </Botao>

            </form>
        </section> 
    )
}

export default FormularioAluno