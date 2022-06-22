import ReactDom from 'react-dom/client';
import './main.css';
import App from './App.js';
import "bootstrap/dist/css/bootstrap.min.css";


 let root = ReactDom.createRoot(document.querySelector("#root"))
 root.render(<App/>)

