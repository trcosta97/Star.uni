import axios from "axios";
import React, { useState, useEffect } from 'react';
import "./Alunos.css";

const Alunos =()=>{
    
    const token = sessionStorage.getItem('token');
    const [alunos, setAlunos] = useState([]);

    useEffect(()=>{
        axios.get('http://localhost:8000/alunos',{
            headers:{
                'Authorization':`Bearer ${token}`
            }
        })
        .then(response => {
           setAlunos(response.data);
        })
        .catch(error => {
           console.log(error);
        });
    }, [])

    return(
        <div className="alunos">
            <h1>Alunos</h1>
            {alunos.map(aluno => (
              <div className="aluno" key={aluno.id}>
                  <ul>
                      <li>Id: {aluno.id}</li>
                      <li>Nome: {aluno.nome}</li>
                      <li>Email: {aluno.email}</li>
                      <li>Sala: {aluno.sala}</li>
                  </ul>
              </div>
            ))}
        </div>
    );
}

export default Alunos;
