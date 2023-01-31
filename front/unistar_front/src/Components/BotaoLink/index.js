import { Link } from "react-router-dom"
import "./BotaoLink.css"


const BotaoLink = (props) => {
    return (
        <div >
            <Link to={props.endereco}>
                <button className="botaoLink" type="button">
                    {props.children}
                </button>
            </Link>
        </div>
    )

}

export default BotaoLink