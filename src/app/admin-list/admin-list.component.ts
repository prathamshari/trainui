import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {
  Users:any;
  constructor(public http:HttpClient,
    private service:DataService) { }

  ngOnInit() {
    let observableResult=  this.service.SelectAdmin();
    observableResult.subscribe(
      (result)=>{
    console.log(result);
    this.Users = result;
  })
  }

}
