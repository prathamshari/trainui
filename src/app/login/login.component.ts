// // import { Component, OnInit } from '@angular/core';
// // import { ActivatedRoute,Router } from '@angular/router';
// // import {DataService } from '../data.service'
// // import { AuthService } from '../auth.service';

// // @Component({
// //   selector: 'app-login',
// //   templateUrl: './login.component.html',
// //   styleUrls: ['./login.component.css']
// // })
// // export class LoginComponent implements OnInit {

// //   userdetail={
// //     uname:"",
// //     password:""
// //   };
// //   constructor(private service:AuthService,
// //     private router:Router) 
// //     { }

// //     msg;

// //     SignIn(loginForm)
// //     {
// //       // let isvalid=this.service.Login(this.userdetail);
// //       // if(isvalid==1)
// //       // {
// //       //   this.router.navigate(['home']);
// //       // }
// //       // else if(isvalid==2)
// //       // {
// //       //   this.router.navigate(['admin'])
// //       // }
// //       // else
// //       // {
// //       //   this.msg="Uname /password is incorrect";
// //       // }

// //     }
// //   ngOnInit() {
// //   }

// // }



// 
// import { Component, OnInit } from '@angular/core';
// import { AuthService } from '../auth.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent implements OnInit {
 
//   constructor(private service: AuthService, private router: Router) 
//   {

//   }

//   ngOnInit() 
//   {
//   }

//   SignIn(loginForm)
//   {
//     let loginCredentials = loginForm.form.value;
//     console.log(loginCredentials);

//      this.service.CheckCredentialsWithDB(loginCredentials);

   
//     // let isUserValid= this.service.CheckCredentialsWithDB(loginCredentials);
//     // console.log(isUserValid);
  
//     // if(isUserValid !=null)
//     // {
//     //   console.log("User Is Valid");
      
//     //   this.router.navigate(['/book']); 
//     // }
//     // else{
//     //   this.message = "User Name / Password is Invalid!";
//     // }
//   }

//   Register()
//   {
//     this.router.navigate(['/register']);
//   }
// }



import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  constructor(private service: AuthService, private router: Router) 
  {

  }

  ngOnInit() 
  {
  }

  SignIn(loginForm)
  {
    
    let loginCredentials = loginForm.form.value;
    console.log("in ts of login")
    console.log(loginCredentials);
     this.service.CheckCredentialsWithDB(loginCredentials);

   
    // let isUserValid= this.service.CheckCredentialsWithDB(loginCredentials);
    // console.log(isUserValid);
  
    // if(isUserValid !=null)
    // {
    //   console.log("User Is Valid");
      
    //   this.router.navigate(['/book']); 
    // }
    // else{
    //   this.message = "User Name / Password is Invalid!";
    // }
  }

  Register()
  {
    this.router.navigate(['/register']);
  }
}
