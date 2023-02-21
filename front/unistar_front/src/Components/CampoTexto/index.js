import "./CampoTexto.css"

const CampoTexto = (props) => {
    return (
        <div className="campo-texto">


            <label>{props.label}</label>
            <input required={props.obrigatorio} placeholder={props.placeholder} value={props.value} onChange={props.onChange} />

        </div>
    )
}

export default CampoTexto