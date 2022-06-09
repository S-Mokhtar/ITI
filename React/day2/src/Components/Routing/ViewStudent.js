import React, { Component } from "react";
import { useParams, Navigate } from "react-router-dom";
import StudentsList from "../components/students.json";

let ViewStudent = () => {
  let arr = StudentsList.students;
  let { id } = useParams();
  const std = arr.filter((s) => s.id == id);
  if (std.length > 0) {
    return (
      <div
        style={{ width: "30rem" }}
        className="card studentItem col-6 offset-4"
      >
        <div className="card-body">
          <h1 className="card-title">Student ID: {std[0].id}</h1>
          <p className="card-text">
            <h2>Name: {std[0].name}</h2>
            <h2>Age: {std[0].age}</h2>
            <h2>Email: {std[0].email}</h2>
          </p>
        </div>
      </div>
    );
  }
  return <Navigate to="/error" />;
};
export default ViewStudent;
