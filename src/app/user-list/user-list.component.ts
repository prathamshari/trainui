import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { DataService } from '../data.service';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
Users:any;
  constructor(public http:HttpClient,
    private service:DataService) { }

  ngOnInit() {
    let observableResult=  this.service.SelectUsers();
    observableResult.subscribe(
      (result)=>{
    console.log(result);
    this.Users = result;
  })
  }
}
