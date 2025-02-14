import {persistReducer, persistStore} from "redux-persist";
import {combineReducers, configureStore} from "@reduxjs/toolkit";
import employeeReducer from "@D/store/features/employee-slice";
import projectReducer from "@D/store/features/project-slice";
import {employeePersistConfig, persistConfig, projectPersistConfig} from "@D/store/config";
import {TypedUseSelectorHook, useDispatch, useSelector} from "react-redux";

const reducers = combineReducers({
    projectStore: persistReducer(projectPersistConfig, projectReducer),
    employeeStore: persistReducer(employeePersistConfig, employeeReducer),
    // scheduleStore: persistReducer(schedulePersistConfig, scheduleReducer),
});

const persistedReducer = persistReducer(persistConfig, reducers);

export const demeterStore = configureStore({
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
            serializableCheck: false,
        }),
});

export const persistor = persistStore(demeterStore);
export type DemeterDispatch = typeof demeterStore.dispatch;
export type DemeterState = ReturnType<typeof demeterStore.getState>;
export const useDemeterSelector: TypedUseSelectorHook<DemeterState> = useSelector;
export const useDemeterDispatch = () => useDispatch<DemeterDispatch>();