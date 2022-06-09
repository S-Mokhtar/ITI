import React, { Component } from 'react';

export default class AddStudent extends Component {
  
  constructor(props){
    super(props)
    this.state = {
      formData:{
        name:'',
        age:0,
      }
    }
  }

  render() {
    const onAddStudentClick=()=>{
      this.props.parentCallBack(this.state.formData) 
    };

    const updateName = (inputValue) => {
        this.setState({
          formData: {
            name:inputValue,
            age:this.state.formData.age
          }
        })
    };

    const updateAge = (inputValue) => {
        this.setState({
          formData: {
            name:this.state.formData.name,
            age:inputValue,
          }
        })
    };

    return (
      <div class="col-6 offset-3">
        <div class="mb-3">
          <input
            class="form-control"
            id="exampleFormControlInput1"
            name={"name"}
            placeholder={"Enter Name"}
            onChange={(e) => updateName(e.target.value)}
          />
        </div>
        <div class="mb-3">
          <input
            class="form-control"
            id="exampleFormControlInput1"
            name={"age"}
            placeholder={"Enter Age"}
            onChange={(e) => updateAge(e.target.value)}
          />
        </div>
        <button
          type="button"
          class="btn btn-primary"
          onClick={onAddStudentClick}
        >
          Add
        </button>
      </div>
    );
  }
}
