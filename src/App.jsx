import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';
import Header from './components/Header';
import { ExpenseList } from './components/ExpenseList';
import { ExpenseRequest } from './components/ExpenseRequest.jsx';

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/list_requests" />
      </Routes>
    </BrowserRouter>
    <div className="App">
      <Header />
      <ExpenseRequest />
      <ExpenseList />
    
    </div>
    </>
  );
}

export default App;
