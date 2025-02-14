import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {ProjectDTO} from "@D/http/service/project-service.ts";

export type ProjectStore = {
    projectDTOS: Array<ProjectDTO>;
}

const initialState: ProjectStore = {
    projectDTOS: []
}

const projectStoreSlice = createSlice({
    name: "project",
    initialState,
    reducers: {
        createProjectDTO(state, action: PayloadAction<ProjectDTO>) {
            state.projectDTOS.push(action.payload);
        },
        createProjectDTOS(state, action: PayloadAction<Array<ProjectDTO>>) {
            state.projectDTOS.push(...action.payload);
        },
        updateProjectDTO(state, action: PayloadAction<ProjectDTO>) {
            const projectId = action.payload.id;
            const index = state.projectDTOS.findIndex(project => project.id === projectId);
            if (index !== -1) {
                state.projectDTOS[index] = action.payload;
            } else {
                console.error(`Project with ID ${projectId} not found in the state.`);
            }
        },
        updateProjectDTOS(state, action: PayloadAction<Array<ProjectDTO>>) {
            action.payload.forEach(updatedProject => {
                const index = state.projectDTOS.findIndex(project => project.id === updatedProject.id);
                if (index !== -1) {
                    state.projectDTOS[index] = updatedProject;
                } else {
                    console.error(`Project with ID ${updatedProject.id} not found in the state.`);
                }
            });
        },
        deleteProjectDTO(state, action: PayloadAction<ProjectDTO>) {
            state.projectDTOS = state.projectDTOS.filter(project => project.id !== action.payload.id);
        },
        deleteProjectDTOS(state, action: PayloadAction<Array<ProjectDTO>>) {
            state.projectDTOS = state.projectDTOS.filter(project => !action.payload.some(deletedProject => deletedProject.id === project.id));
        },
        setProjectDTOS(state, action: PayloadAction<Array<ProjectDTO>>) {
            state.projectDTOS = action.payload;
        }
    }
});

export const {
    createProjectDTO,
    createProjectDTOS,
    updateProjectDTO,
    updateProjectDTOS,
    deleteProjectDTO,
    deleteProjectDTOS,
    setProjectDTOS
} = projectStoreSlice.actions;
export default projectStoreSlice.reducer;