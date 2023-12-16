import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import "./index.css";
import UsersPage from "./pages/UsersPage";
import AnimalsPage from "./pages/AnimalsPage";
import WalksPage from "./pages/WalksPage";
import UserPage from "./pages/UserPage";
import AnimalPage from "./pages/AnimalPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
                path: "/users",
                element: <UsersPage/>
            },
            {
                path: "/animals",
                element: <AnimalsPage />
            },
            {
                path: "/walks",
                element: <WalksPage />
            },
            {
                path: "/users/:userID",
                element: <UserPage />
            },
            {
                path: "/animals/:animalID",
                element: <AnimalPage />
            }
        ]
    },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
  </React.StrictMode>
);

