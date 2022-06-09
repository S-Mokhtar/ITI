import { NavLink } from "react-router-dom";

let Header = ()=>{
    return (
      <div id="menu-outer" className="col-6 offset-5">
        <div>
          <ul id="horizontal-list">
            <li>
              <NavLink to={"/home"} className="btn btn-primary">
                Home
              </NavLink>
            </li>
            <li>
              <NavLink to={"/about"} className="btn btn-primary">
                About
              </NavLink>
            </li>
            <li>
              <NavLink to={"*"} className="btn btn-primary">
                Error
              </NavLink>
            </li>
          </ul>
        </div>
      </div>
    );
}

export default Header;