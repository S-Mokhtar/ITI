import { Component, OnInit } from '@angular/core';
import { User } from '../_models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  user: User = new User(0, '', '');
  constructor() {}
  showForm(t:any){
    console.log(t);
  }
  add(){
    console.log(this.user);
  }
  ngOnInit(): void {}
}
