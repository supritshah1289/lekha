import React from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./app/App";
import registerServiceWorker from "./registerServiceWorker";
import { BrowserRouter as Router } from "react-router-dom";
import { store } from "./redux/store";
import { Provider } from "react-redux";

const container = document.getElementById("root");
const root = createRoot(container);

root.render(
  <Provider store={store}>
    <Router>
      <App />
    </Router>
  </Provider>
);

registerServiceWorker();
