import "./index.scss";
import App from "@D/app.tsx";
import {StrictMode} from "react"
import {createRoot} from "react-dom/client"
import {PRIMARY_COLOR} from "@D/theme/theme";
import {ConfigProvider} from "antd";
import {Provider} from "react-redux";
import {demeterStore, persistor} from "@D/store/store";
import {PersistGate} from "redux-persist/integration/react";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <ConfigProvider theme={{
            token: {
                colorPrimary: PRIMARY_COLOR,
            },
        }}>
            <Provider store={demeterStore}>
                <PersistGate persistor={persistor} loading={null}>
                    <App/>
                </PersistGate>
            </Provider>
        </ConfigProvider>
    </StrictMode>,
)
