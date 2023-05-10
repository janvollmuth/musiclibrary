import React from "react";
import { useState, useEffect } from "react";
import Track from "./Track";
import { TrackType } from "../types/Types";
import "../components/TrackList.css";
import axios from "axios";
import AddTrackModal from "./AddTrackModal";


function TrackList() {
  const [tracks, setTracks] = useState([]);
  const [showAddTrackModal, setAddTrackModal] = useState(false);

  useEffect(() => {
    fetch("http://localhost:8080/tracks")
      .then((response) => response.json())
      .then((data) => setTracks(data))
      .catch((err) => console.log(err));
  }, []);

  function updateTrackList() {
    fetch("http://localhost:8080/tracks")
      .then((response) => response.json())
      .then((data) => setTracks(data))
      .catch((err) => console.log(err));
  }

  async function RemoveTrack(id: number) {
    var url = "http://localhost:8080/tracks/" + id.toString();

    await axios
      .delete(url)
      .then((response) => {
        console.log("Track successfully removed!");
      })
      .catch((error) => {
        console.log(error);
      });
      updateTrackList();
  }

  async function AddTrack(newTrack: TrackType) {
    await axios
      .post("http://localhost:8080/tracks", newTrack)
      .then((response) => {
        console.log("Track successfully added!");
      })
      .catch((error) => {
        console.log(error);
      });
      updateTrackList();
  }

  async function UpdateTrack(id: number, track: TrackType) {
    var url = "http://localhost:8080/tracks/" + id.toString();
    console.log(url);
    await axios.put(url, track)
    .then((response) => {
        console.log("Track successfully updated!");
    })
    .catch((error) => {
        console.log(error);
    })
    updateTrackList();
  }

  function CloseAddTrackModal() {
    setAddTrackModal(false);
  }

  return (
    <div>
      <h2>Favorite Tracks</h2>
      <table className="center">
        <thead>
          <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Genre</th>
            <th>BPM</th>
            <th>Remove Track</th>
          </tr>
        </thead>
        <tbody>
          {tracks.map((track: TrackType) => (
            <Track data={track} onUpdate={UpdateTrack} onDelete={RemoveTrack} />
          ))}
        </tbody>
      </table>
      <button className="buttonAdd" onClick={() => setAddTrackModal(true)}>
        Add Track
      </button>
      <AddTrackModal isOpen={showAddTrackModal} onAdd={AddTrack} onClose={CloseAddTrackModal}/>
    </div>
  );
}

export default TrackList;
