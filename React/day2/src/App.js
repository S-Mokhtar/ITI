import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./Components/Routing/Header";
import About from "./Components/Routing/About";
import Error from "./Components/Routing/Error";
import Home from "./Components/Routing/Home";
import ViewStudent from "./Components/Routing/ViewStudent";

let App = () => {
  return (
    <div>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/:id" element={<ViewStudent />} />
          <Route exact path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/error" element={<Error />} />
          <Route element={<Error />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
