
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
    
    const uf = [
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

    

    return (
        <section className="formulario">
            <form onSubmit={aoSalvar}>
                <h2>Preencha os dados para cadastrar o aluno</h2>
                <CampoTexto obrigatorio = {true} label="Nome" placeholder="Digite o nome" />
                <CampoTexto obrigatorio = {true} label="CPF" placeholder="Digite o CPF" />
                <Dropdown obrigatorio = {true} label="Sala" itens={salas} />
                <CampoTexto obrigatorio = {true} label="CEP" placeholder="Digite o CEP" />
                <CampoTexto obrigatorio = {true} label="Logradouro" placeholder="Digite o logradouro" />
                <CampoTexto obrigatorio = {false} label="Numero" placeholder="Digite o número" />
                <CampoTexto obrigatorio = {true} label="Bairro" placeholder="Digite o bairro" />
                <CampoTexto obrigatorio = {false} label="Complemento" placeholder="Digite o complemento" />
                <CampoTexto obrigatorio = {true} label="Cidade" placeholder="Digite a cidade" />
                <Dropdown obrigatorio = {true} label="UF" itens={uf} />
                <Botao>
                    Cadastrar
                </Botao>

            </form>
        </section> 
    )
}

export default FormularioAluno