import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  user={
    "userId":"",
    "email":"",
    "password":"",
    "password2":""
  };

  u:any
  
  constructor(private service:DataService,
    private route:Router) { }

  ngOnInit() {
    this.u = JSON.parse(sessionStorage.getItem("user"));
    console.log(this.u);
  }
  ChangePassword()
  {
    if(this.user.password==this.user.password2)
    {
      this.user.email=this.u.email;
      this.user.userId=this.u.userId;
      console.log(this.user.email);
      //userid and email are assigned to this object from session scope
      console.log("id is : "+this.user.userId);
      let res=this.service.ChangePassword(this.user);
      res.subscribe((result)=>{
        console.log(result);
      })
      if(this.u.role=="USER")
      {
        this.route.navigate(['home']);
      }
      else
      {
        this.route.navigate(['admin']);
      }
    }
    else
    { 
      alert("Password are not matching");
    }
  }
}
