import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {DataService } from '../data.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user={
    "fName":"",
    "lName":"",
    "dob":"",
    "email":"",
    "mobile":"",
    "gender":"",
    "city":"",
    "state":"",
    "pincode":"",
    "password":"",
    "question":"",
    "answer":""
  }
constructor(private route:ActivatedRoute,
private router:Router,
private service:DataService) { }

  ngOnInit() {
  }
 
  Insert()
  {
    let status=this.service.Insert(this.user);
    status.subscribe((result)=>{
      console.log(result);
      this.router.navigate(['login']);//
    });
  }

}
