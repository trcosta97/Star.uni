import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home"
import Login from "./components/Login";
import FormularioAluno from "./components/FormularioAluno";
import FormularioProfessor from "./components/FormularioProfessor";

function App(){
  return(
    <div className="App">
      
      <BrowserRouter>
        <Routes>
        <Route path="/" element={<Login/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/cadastroProfessor" element={<FormularioProfessor/>}/>
          <Route path="/cadastroaLUNO" element={<FormularioAluno/>}/>
        </Routes>
      </BrowserRouter>
      
   
    </div>
   

  );
}

export default App