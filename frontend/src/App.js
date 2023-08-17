import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Forms from './components/Forms'
import Navbar from './components/Navbar'

export default function working() {
  return (
    <>
    <Navbar />
    <Routes>
    
      <Route path='/' element={<Home />}></Route>
      <Route path='/forms' element={<Forms />}></Route>
    </Routes>
    </>
  )
}
