import { NavLink } from "react-router-dom";

let navbar = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light background">
        <div className="container-fluid">
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink
                  to={"/home"}
                  className="nav-link active text-primary"
                  aria-current="page"
                >
                  Home
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink to={"/artists"} className="nav-link text-primary">
                  Artists
                </NavLink>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default navbar;
