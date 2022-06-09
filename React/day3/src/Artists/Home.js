import { NavLink } from "react-router-dom";

let home = () => {
  return (
    <div className="container-sm text-center p-5">
      <div className="home">
        <NavLink className="btn btn-outline-primary homeBtn" to={"/artists"}>
          Go to artists
        </NavLink>
      </div>
    </div>
  );
};

export default home;
