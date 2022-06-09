import { NavLink } from "react-router-dom";

let StudentItem = ({ artistInfo }) => {
  console.log(artistInfo);
  return (
    <div className="container background py-4 text-center">
      <div>
        <NavLink to={`/artists/${artistInfo.id}`}>
        <img
            alt="artist"
            src={`./imagesDay3/covers/${artistInfo.cover}.jpg`}
          />
        </NavLink>
      </div>
      <NavLink
        to={`/artists/${artistInfo.id}`}
        className="btn btn-outline-primary my-3"
        style={{ fontSize: "50px" }}
      >
        {artistInfo.name}
      </NavLink>
    </div>
  );
};

export default StudentItem;
