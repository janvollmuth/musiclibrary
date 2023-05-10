import React, { useState } from "react";
import { TrackType } from "../types/Types";
import ReactModal from "react-modal";
import "../components/Modal.css";

type EditTrackModalProps = {
  isOpen: boolean;
  trackData: TrackType;
  onClose: () => void;
  onUpdate: (id: number, track: TrackType) => void;
};

const EditTrackModal: React.FC<EditTrackModalProps> = ({
  isOpen,
  trackData,
  onClose,
  onUpdate,
}) => {
  const [title, setTitle] = useState(trackData.title);
  const [artist, setArtist] = useState(trackData.artist);
  const [genre, setGenre] = useState(trackData.genre);
  const [bpm, setBPM] = useState(trackData.bpm);

  function handleSubmit(event: React.FormEvent) {
    event.preventDefault();
    console.log(trackData.id);
    const updatedTrack = {
      id: trackData.id,
      title: title,
      artist: artist,
      genre: genre,
      bpm: bpm,
    };
    onUpdate(trackData.id, updatedTrack);
    onClose();
  }
  return (
    <ReactModal isOpen={isOpen} onRequestClose={onClose}>
      <div>
        <div>
          <h2 className="modal-title">Update Track</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Title:</label>
              <input
                className="form-control"
                type="text"
                placeholder={trackData.title}
                value={title}
                onChange={(event) => setTitle(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>Artist:</label>
              <input
                className="form-control"
                type="text"
                placeholder={trackData.artist}
                value={artist}
                onChange={(event) => setArtist(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>Genre:</label>
              <input
                className="form-control"
                type="text"
                placeholder={trackData.genre}
                value={genre}
                onChange={(event) => setGenre(event.target.value)}
              />
            </div>
            <div className="form-group">
              <label>BPM:</label>
              <input
                className="form-control"
                type="number"
                placeholder={trackData.bpm.toString()}
                value={bpm}
                onChange={(event) => setBPM(parseInt(event.target.value))}
              />
            </div>
            <div className="modal-buttons">
              <button className="button" type="submit">
                Update
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

export default EditTrackModal;
