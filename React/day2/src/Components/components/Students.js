import { NavLink } from "react-router-dom";

let Students = ({ studentsList }) => {
  let renderStudnets = () => {
    if (studentsList.length > 0) {
      return studentsList.map((student) => {
        return (
          <div style={{ width: "18rem" }} className="card studentItem">
            <div className="card-body">
              <h5 className="card-title">{student.name}</h5>
              <p className="card-text">{student.age}</p>
              <NavLink to={"/" + student.id} className="btn btn-primary">
                View Student
              </NavLink>
            </div>
          </div>
        );
      });
    } else {
      return <h1>No Students</h1>;
    }
  };

  return (
    <div className="addStudent d-flex flex-column align-items-center">
      <h3 className="header">Students</h3>
      {renderStudnets()}
    </div>
  );
};

export default Students;
