import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService  implements CanActivate
{
  dbuser:any;
  train:any
  baseUrl="http://localhost:8080/Railway_Reservation/users/login"
  baseUrl1="http://localhost:8080/Railway_Reservation/users/login/search-train"

  loginsuc=false;
  
  constructor(private router:Router, public http: HttpClient) { }
  storeTrain(trainCredentials)
  {
    this.http.post(this.baseUrl1,trainCredentials).subscribe((res)=>{
      console.log(res);
      this.train=res;
        sessionStorage.setItem("trainData",JSON.stringify(this.dbuser));
        
      })
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
   if(this.IsLoggedIn())
   {
     console.log("User Has Logged in");
     return true;
   }
   else
   {
    console.log("User Has not Logged in");
     this.router.navigate(['/login']);
     return false;  
   }
  }
  

  IsLoggedIn()
  {
    
    if(window.sessionStorage.getItem("isActive")!=null 
        && 
       (window.sessionStorage.getItem("isActive")=="1" || window.sessionStorage.getItem("isActive")=="2"))
    {
      console.log("user logged successfully");
      return true;
    }
    else{
      this.loginsuc = true;
      return false;

    }
  }

  obsRes:any;

  CheckCredentialsWithDB(credentials)
  {
    this.http.post(this.baseUrl,credentials).subscribe((res)=>{
      console.log(res);
      this.dbuser=res;

      if(this.dbuser.role == "ADMIN")
       {
        window.sessionStorage.setItem("isActive", "1");
        sessionStorage.setItem("user",JSON.stringify(this.dbuser));
        this.router.navigate(['/admin']);
        return true;
      }
      else if(this.dbuser.role == "USER")
      {
        window.sessionStorage.setItem("isActive", "2");
        sessionStorage.setItem("user",JSON.stringify(this.dbuser));
        this.router.navigate(['/home']);
        return true;
      }
      else
      {
        return false;
      }
      return false;
    },(error)=>{
      console.log(error);
    })
  }

  LogOut()
  {
    console.log("before logout");
    window.sessionStorage.setItem("isActive", "0");
    this.router.navigate(['/login']);
  }

}