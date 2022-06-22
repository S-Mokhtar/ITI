import AddStudent from '../components/AddStudent';
import Students from "../components/Students";
import StudentsList from '../components/students.json';
import React, { Component } from 'react';

export default class Home extends Component {

  constructor(){
    super()
    this.state = {
      studentsArr:StudentsList.students
    }
  }    
  
  addNewStudentCallback = (data)=>{
    this.state.studentsArr.push(data)
    this.setState({studentsArr:this.state.studentsArr})
  }
  
  render() {
    return (
        <div>
            <AddStudent parentCallBack={this.addNewStudentCallback}></AddStudent>
            <Students studentsList={this.state.studentsArr}></Students>
        </div>
    )
  }
}

