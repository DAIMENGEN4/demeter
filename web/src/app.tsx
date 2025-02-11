import "./app.scss";
import {BrowserRouter} from "react-router-dom";
import {AppRoutes} from "@D/app-routes.tsx";

function App() {
    return (
        <BrowserRouter>
            <AppRoutes/>
        </BrowserRouter>
    )
}

export default App
