import React, { useState } from 'react'
import axios from 'axios'

export default function Registration() {
  const [inputValues, setInputValues] = useState(
    {
      name:"",
      email:"",
      password:"",
      confirmPassword:"",
      about:""
    });

    //called when we any value is put in text field
  const handleOnChange = (event) =>{
    setInputValues((previousValue)=>({
      ...previousValue,
      [event.target.name]:event.target.value
    }))
    console.log(inputValues);
  }

  const register = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8090/auth/register",inputValues)
      .then((response) =>{
        console.log(response);
      })
  }


  return (
    <>
      <form>
        <div className="mb-3" >
          <label className="form-label">Name</label>
          <input type="text" className="form-control" name="name" value={inputValues.name} onChange={handleOnChange} />
        </div>
        <div className="mb-3">
          <label className="form-label">Email address</label>
          <input type="email" className="form-control" name='email' value={inputValues.email} onChange={handleOnChange}/>
          <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div className="mb-3">
          <label className="form-label">Create Password</label>
          <input type="password" className="form-control" name='createPassword' value={inputValues.password} onChange={handleOnChange} />
        </div>
        <div className="mb-3">
          <label className="form-label">Confirm Password</label>
          <input type="password" className="form-control" name='confirmPassword' value={inputValues.confirmPassword} onChange={handleOnChange} />
        </div>
        <div className="mb-3" >
          <label className="form-label">Name</label>
          <input type="text" className="form-control" name="name" value={inputValues.about} onChange={handleOnChange} />
        </div>
        <div className="mb-3 form-check">
          <input type="checkbox" className="form-check-input" id="exampleCheck1" />
          <label className="form-check-label">Check me out</label>
        </div>
        <button type="submit" className="btn btn-primary" onClick={register}>Submit</button>
      </form>
    </>
  )
}
