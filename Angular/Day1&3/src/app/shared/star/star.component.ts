import { Component, EventEmitter, Input, OnChanges, OnInit } from '@angular/core';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit,OnChanges {
  @Input() rating=2;
  cwidth:number=0;
  constructor() {}
  ngOnInit(): void {
  }
  ngOnChanges(){
    this.cwidth=this.rating*15;
  }

}
