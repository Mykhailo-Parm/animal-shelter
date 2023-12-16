import './App.css';
import Navbar from "./components/common/Navbar";
import {Outlet} from "react-router-dom";

function App() {

    return (
        <>
            <Navbar/>
            <Outlet/>
        </>
    );
}

export default App;
