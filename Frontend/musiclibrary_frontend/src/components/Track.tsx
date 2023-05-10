import React from "react";
import { TrackType } from "../types/Types";
import { useState } from "react";
import "../components/TrackList.css";
import EditTrackModal from "./EditTrackModal";

interface Props {
  data: TrackType;
  onUpdate: (id: number, track: TrackType) => void;
  onDelete: (id: number) => void;
}

const Track: React.FC<Props> = ({ data, onUpdate, onDelete }) => {

  const [showEditTrackModal, setEditTrackModal] = useState(false);

  function CloseEditTrackModal() {
    setEditTrackModal(false);
  }

  return (
    <tr key={data.id}>
      <td>{data.title}</td>
      <td>{data.artist}</td>
      <td>{data.genre}</td>
      <td>{data.bpm}</td>
      <td>
        <button className="button" onClick={() => setEditTrackModal(true)}>
          Update
        </button>
        <button className="button" onClick={() => onDelete(data.id)}>
          Delete
        </button>
      </td>
      <EditTrackModal isOpen={showEditTrackModal} trackData={data} onUpdate={onUpdate} onClose={CloseEditTrackModal}/>
    </tr>
  );
};

export default Track;
