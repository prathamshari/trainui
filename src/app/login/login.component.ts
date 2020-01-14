import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {DataService } from '../data.service'
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userdetail={
    uname:"",
    password:""
  };
  constructor(private service:AuthService,
    private router:Router) 
    { }

    msg;

    SignIn()
    {
      let isvalid=this.service.Login(this.userdetail);
      if(isvalid)
      {
        this.router.navigate(['home']);
      }
      else
      {
        this.msg="Uname /password is incorrect";
      }
    }
  ngOnInit() {
  }

}
