import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios';
export default function ViewUsers() {
    const{id}=useParams();
    const[user,setUser]=useState({
        name:"",
       username:"",
       email:""
});
    useEffect(()=>{
        loadUser();
    },[]);
    const loadUser =async ()=>{
        const result = await axios.get(`http://localhost:9191/user/${id}`);
        setUser(result.data);
    }
  return (
    <div className='container'>
    <div className='row'>
    <div className='col-md-6 offset-md-3 boredr rounded p-4 mt-2 shadow'>
    <h2 className='text-center m-4'>User Details</h2>
    <div className="card">
    <div className="card-header">
      Details of user <b>id: {user.id}  </b>
      <ul className="list-group list-group-flush">
      <li className="list-group-item">
      <b>Name:</b>
        {user.name}
      </li>
      <li className="list-group-item">
      <b>UserName:</b>
         {user.username}
      </li>
      <li className="list-group-item">
      <b>Email:</b>
       {user.email}
      </li>
      </ul>
    </div>
    </div>
    <Link className='btn btn-primary my-2' to={'/'}>Home</Link>
    </div>
    </div>
    </div>
  )
}
