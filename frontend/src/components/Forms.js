import React, { useState } from 'react'
import Login from './Login';
import Registration from './Registration';

export default function Forms({close}) {
  const [formType , setFormType] = useState("");

  const onClickLogin = () => {
    setFormType("login");
  }
  const onClickRegistration = () => {
    setFormType("register");
  }
console.log(formType);
  return (
    <>
    <div className='modal-wrapper' onClick={close}></div>
      <div className='modal-container'>
        <div>
          
          <button onClick={onClickLogin}>Login</button>
          <button onClick={onClickRegistration}>Register</button>
          {formType==="login" ? <Login/> : <Registration/>}
          
        </div>
        <button onClick={close}>close</button>
      </div>
    </>
    
  )
}
