import './BotaoLogin.css'

const BotaoLogin = (props) =>{
    return(
        <button className='botaoLogin' type="submit">
            {props.children}
        </button>
    )
}
export default BotaoLogin