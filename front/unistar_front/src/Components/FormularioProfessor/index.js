import { useState } from "react"
import Botao from "../Botao"
import CampoTexto from "../CampoTexto"
import Dropdown from "../Dropdown"
import axios from "axios"
import "./FormularioProfessor.css"

const FormularioProfessor = () => {

    const disciplinas = [
        'PORTUGUES',
        'MATEMATICA',
        'FISICA',
        'QUIMICA',
        'BIOLOGIA',
        'HISTORIA',
        'INGLES',
        'GEOGRAFIA',
        'FILOSOFIA',
        'EDUCACAO_FISICA'

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

    const token = sessionStorage.getItem('token')
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;


    const aoSalvar = (event) => {
        event.preventDefault();
        setDisciplina(disciplina);
        const data = {
            nome: nome,
            email: email,
            cpf: cpf,
            disciplina: disciplina,
            cep: cep,
            logradouro: logradouro,
            numero: numero,
            bairro: bairro,
            complemento: complemento,
            cidade: cidade,
            uf: uf
        };
        axios.post('http://localhost:8080/professores', data)
            .then(response => {
                console.log(response.data);
                
            })
            .catch(error => {
                console.log(error);
                console.log(data)
                
            });
    };


    const [nome, setNome] = useState('')
    const [email, setEmail] = useState('')
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
                <CampoTexto value={nome} obrigatorio={true} label="Nome*" onChange={event => setNome(event.target.value)} placeholder="Digite o nome" />
                <CampoTexto value={email} obrigatorio={true} label="Email*" onChange={event => setEmail(event.target.value)} placeholder="Digite o email" />
                <CampoTexto value={cpf} obrigatorio={true} label="CPF*" onChange={event =>setCpf(event.target.value)} placeholder="Digite o CPF" />
                <Dropdown value={disciplina} obrigatorio={true} label="Disciplina*" onChange={event =>setDisciplina(event.target.value)} itens={disciplinas} />
                <CampoTexto value={cep} obrigatorio={true} label="CEP*" onChange={event =>setCep(event.target.value)} placeholder="Digite o CEP" />
                <CampoTexto value={logradouro} obrigatorio={true} label="Logradouro*" onChange={event =>setLogradouro(event.target.value)} placeholder="Digite o logradouro" />
                <CampoTexto value={numero} obrigatorio={false} label="Numero" onChange={event =>setNumero(event.target.value)} placeholder="Digite o número" />
                <CampoTexto value={bairro} obrigatorio={true} label="Bairro*" onChange={event =>setBairro(event.target.value)} placeholder="Digite o bairro" />
                <CampoTexto value={complemento} obrigatorio={false} label="Complemento" onChange={event =>setComplemento(event.target.value)} placeholder="Digite o complemento" />
                <CampoTexto value={cidade} obrigatorio={true} label="Cidade*" onChange={event =>setCidade(event.target.value)} placeholder="Digite a cidade" />
                <Dropdown value={uf} obrigatorio={true} label="UF*" onChange={event =>setUf(event.target.value)} itens={estados} />
                <h5>* Campos obrigatórios</h5>
                <Botao>
                    Cadastrar
                </Botao>

            </form>
        </section>
    )
}

export default FormularioProfessor