import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/_models/student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  std:Student=new Student(1,'Shaimaa',23,1);
  stds:Student[]=[
    new Student(1,'Shaimaa',23,1),
    new Student(2,'Radwa',24,1),
    new Student(3,'Mahitab',23,1)
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
