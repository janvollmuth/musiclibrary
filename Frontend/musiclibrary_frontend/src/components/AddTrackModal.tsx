import React, { useState } from "react";
import { TrackType } from "../types/Types";
import ReactModal from "react-modal";
import "../components/Modal.css";

type AddTrackModalProps = {
  isOpen: boolean;
  onClose: () => void;
  onAdd: (track: TrackType) => void;
};

const AddTrackModal: React.FC<AddTrackModalProps> = ({
  isOpen,
  onClose,
  onAdd,
}) => {
  const [title, setTitle] = useState("");
  const [artist, setArtist] = useState("");
  const [genre, setGenre] = useState("");
  const [bpm, setBPM] = useState(0);

  function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    const newTrack = {
      id: 0,
      title: title,
      artist: artist,
      genre: genre,
      bpm: bpm,
    };
    onAdd(newTrack);
    onClose();
  }
  return (
    <ReactModal isOpen={isOpen} onRequestClose={onClose}>
      <div>
        <div>
          <h2 className="modal-title">Add Track</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Title:</label>
              <input
                className="form-control"
                type="text"
                value={title}
                onChange={(event) => setTitle(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>Artist:</label>
              <input
                className="form-control"
                type="text"
                value={artist}
                onChange={(event) => setArtist(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>Genre:</label>
              <input
                className="form-control"
                type="text"
                value={genre}
                onChange={(event) => setGenre(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>BPM:</label>
              <input
                className="form-control"
                type="number"
                value={bpm}
                onChange={(event) => setBPM(parseInt(event.target.value))}
              />
            </div>
            <div className="modal-buttons">
              <button className="button" type="submit">
                Add
              </button>
              <button className="button" type="button" onClick={onClose}>
                Cancle
              </button>
            </div>
          </form>
        </div>
      </div>
    </ReactModal>
  );
};

export default AddTrackModal;
