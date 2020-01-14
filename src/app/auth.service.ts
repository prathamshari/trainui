// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService implements{

//   constructor() { }
// }

import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate
{

  constructor(private router:Router) 
  {


  }
  canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot) 
  {

    
    if(this.isLoggedIn())
    {
      return true;
    }
    else
    {
      this.router.navigate(['login']);
      return false;
    }
   
  }

  isLoggedIn()
  {
    if(window.sessionStorage.getItem('active')!=null && window.sessionStorage.getItem('active')=="1")
    {
      return true;
    }
    else
    {
        return false;
    }
  }

  Login(userdetails)
  {
    if(userdetails.uname=='abc' && userdetails.password=="abc@123")
    {
      window.sessionStorage.setItem('active','1');
      return true;
    }
    else{
      return false;
    }
  }
  LogOut()
  {
    
      window.sessionStorage.setItem('active','0');
  
  }

}