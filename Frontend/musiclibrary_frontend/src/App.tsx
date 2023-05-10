import React from "react";
import "./App.css";
import TrackList from "./components/TrackList";

function App() {
  return (
    <div className="App">
      <h1>Music Library</h1>
      <div>
        <TrackList />
      </div>
    </div>
  );
}

export default App;
