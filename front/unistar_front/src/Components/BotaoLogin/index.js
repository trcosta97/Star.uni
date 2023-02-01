import './BotaoLogin.css'

const BotaoLogin = (props) =>{
    return(
        <button className='botaoLogin'>
            {props.children}
        </button>
    )
}
export default BotaoLogin