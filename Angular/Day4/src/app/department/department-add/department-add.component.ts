import { Component, OnInit } from '@angular/core';
import { DepartmentService } from 'src/app/department.service';
import { Department } from 'src/app/_models/department';

@Component({
  selector: 'app-department-add',
  templateUrl: './department-add.component.html',
  styleUrls: ['./department-add.component.css']
})
export class DepartmentAddComponent implements OnInit {
  ndept:Department=new Department(0,'','');
  save(){
    this.deptser.addDepartment(this.ndept);
  }
  constructor(public deptser: DepartmentService) {}

  ngOnInit(): void {}
}
